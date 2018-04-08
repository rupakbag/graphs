package com.library.misc;

import java.io.Serializable;

public class SingletonDemo {

    public static class SingletonEagerInitialization {
        // No exception handling. A static block can be used instead to handle exception
        private static final SingletonEagerInitialization instance = new SingletonEagerInitialization();
        private SingletonEagerInitialization() {}
        public static SingletonEagerInitialization getInstance() {
            return instance;
        }
    }

    public static class SingletonLazyInitialization {
        private static SingletonLazyInitialization instance;

        private SingletonLazyInitialization() {}

        public static SingletonLazyInitialization getInstance(){
            if (instance == null) {
                instance = new SingletonLazyInitialization();
            }
            return instance;
        }
    }

    public static class SingletonThreadSafe {
        private static SingletonThreadSafe instance;

        private SingletonThreadSafe() {
        }

        public static SingletonThreadSafe getInstance() {
            if (instance == null) {
                synchronized (SingletonThreadSafe.class) {
                    if (instance == null) {
                        instance = new SingletonThreadSafe();
                    }
                }
            }
            return instance;
        }
    }

    public static class SingletonInnerStaticClass{
        private SingletonInnerStaticClass() {}

        private static class SingletonHelper{
            private static final SingletonInnerStaticClass instance = new SingletonInnerStaticClass();
        }

        public static SingletonInnerStaticClass getInstance(){
            return SingletonHelper.instance;
        }
    }

    public static class SingletonSerializationSafe implements Serializable {
        private SingletonSerializationSafe() {}
        private static class SingletonHelper{
            private static final SingletonSerializationSafe instance = new SingletonSerializationSafe();
        }

        public static SingletonSerializationSafe getInstance() {
            return SingletonSerializationSafe.SingletonHelper.instance;
        }

        protected Object readResolve() {
            return SingletonHelper.instance;
        }
    }
}
