package com.threading;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    private LinkedList<Integer> data = new LinkedList<>();
    Lock lock = new ReentrantLock();
    Condition okToProceed = lock.newCondition();

    public ProducerConsumer() {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    private class Producer implements Runnable{

        @Override
        public void run() {
            while (true) {
                int i = (int) (Math.random() * 100000);
                lock.lock();
                try {
                    while (!spaceAvailable()) {
                        System.out.println("No space available");
                        try {
                            okToProceed.await();
                        } catch (InterruptedException e) {}
                    }
                    data.add(i);
                    okToProceed.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private boolean spaceAvailable() {
        return data.size() < 10;
    }

    private class Consumer implements Runnable{

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (!dataAvailable()) {
                        System.out.println("No data available. Going to sleep");
                        try {
                            okToProceed.await();
                        } catch (InterruptedException e) {}
                    }
                    System.out.println(data.remove());
                    okToProceed.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private boolean dataAvailable() {
        return data.size() > 0;
    }

    public static void main(String[] args) {
        new ProducerConsumer();
    }
}
