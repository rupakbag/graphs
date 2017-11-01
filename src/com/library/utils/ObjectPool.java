package com.library.utils;

import java.util.LinkedList;

public abstract class ObjectPool<T extends allowPooling<T>> {
    private LinkedList<T> free;
    protected abstract T create();
    protected abstract boolean validObject(T t);

    public ObjectPool() {
        this.free = new LinkedList<>();
    }

    public T getInstance() {
        if (free.size() > 0) {
            return free.remove();
        }
        return create();
    }

    public void returnInstance(T t) {
        if (validObject(t)) {
            t.clear();
            this.free.add(t);
        }
    }
}
