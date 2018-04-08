package com.threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* Thread T1 prints "One", Thread T2 prints "Two", Thread T3 prints "Three"
*  Print One Two Three One Two ... in this order
*/

public class PrintInSequence{
    Lock l = new ReentrantLock();
    Condition c = l.newCondition();
    int val = 0;

    public PrintInSequence() {
        new Thread(new Print("One", 0, c), "T1").start();
        new Thread(new Print("Two", 1, c), "T2").start();
        new Thread(new Print("Three", 2, c), "T3").start();
    }

    class Print implements Runnable {
        final String s;
        final int myVal;
        Condition c;
        public Print(String s, int myVal, Condition c) {
            this.s = s;
            this.myVal = myVal;
            this.c = c;
        }

        @Override
        public void run() {
            while (true) {
                l.lock();
                try {
                    while (val != myVal) {
                        c.await();
                    }
                    System.out.println(s);
                    val = (val + 1)%3;
                    c.signalAll();
                } catch (InterruptedException e) {
                } finally {
                    l.unlock();
                }
            }
        }
    }

    public static void main(String[] args){
        new PrintInSequence();
    }
}
