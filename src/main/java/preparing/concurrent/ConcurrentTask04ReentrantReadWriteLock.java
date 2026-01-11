package preparing.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentTask04ReentrantReadWriteLock {
    public static class Counter {

        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        private volatile int count;

        public int getCount() {
            lock.readLock().lock();
            try {
                return count;
            } finally {
                lock.readLock().unlock();
            }
        }

        public void increment() {
            lock.writeLock().lock();
            try {
                count = count + 1;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                for (int i = 0; i < 100_000; i++) {
                    counter.increment();
                }
                System.out.println("Thread 1 finish, Counter:" + counter.getCount());
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                for (int i = 0; i < 100_000; i++) {
                    counter.increment();
                }
                System.out.println("Thread 1 finish, Counter:" + counter.getCount());
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Test end, Counter:" + counter.getCount());
    }
}
