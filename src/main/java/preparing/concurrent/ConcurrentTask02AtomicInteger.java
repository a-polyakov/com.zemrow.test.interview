package preparing.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentTask02AtomicInteger {
    public static class Counter {
        private final AtomicInteger count = new AtomicInteger();

        public int getCount() {
            return count.get();
        }

        public void increment() {
            count.incrementAndGet();
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
