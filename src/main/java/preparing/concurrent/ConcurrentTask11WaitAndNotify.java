package preparing.concurrent;

import java.util.Random;
import java.util.UUID;

public class ConcurrentTask11WaitAndNotify {
    public static class Processor {

        private UUID data = null;

        public synchronized void produce() throws InterruptedException {
            System.out.println("Produce start");
            while (data != null) {
                // wait consumer
                wait();
            }

//            System.out.println("Producing data...");
            Thread.sleep(new Random().nextInt(100, 250));
            data = UUID.randomUUID();

            // notify consumer
            System.out.println("Produce finish data: " + data);
            notify();
        }

        public synchronized void consume() throws InterruptedException {
            System.out.println("Consume start");
            while (data == null) {
                // wait producer
                wait();
            }

//            System.out.println("Consuming data...");
            Thread.sleep(new Random().nextInt(100, 500));
            System.out.println("Consume finish data: " + data);
            data = null;

            // notify producer
            notify();
        }
    }

    public static final int COUNT = 50;

    public static void main(String[] args) throws InterruptedException {
        final Processor processor = new Processor();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                for (int i = 0; i < COUNT; i++) {
                    try {
                        processor.produce();
                    } catch (InterruptedException ignore) {
                    }
                }
                System.out.println("Thread 1 finish");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                for (int i = 0; i < COUNT; i++) {
                    try {
                        processor.consume();
                    } catch (InterruptedException ignore) {
                    }
                }
                System.out.println("Thread 2 finish");
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Test end");
    }
}
