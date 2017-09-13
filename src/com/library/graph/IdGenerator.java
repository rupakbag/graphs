package com.library.graph;

import java.util.concurrent.atomic.AtomicInteger;

public final class IdGenerator {
    private static AtomicInteger i = new AtomicInteger();
    private static IdGenerator instance = new IdGenerator();

    private IdGenerator() {
        i = new AtomicInteger();
    }

    public static IdGenerator getInstance(){
        return instance;
    }

    public int getNextId(){
        return this.i.incrementAndGet();
    }
}
