package preparing.concurrent;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConcurrentTask09BlockingQueue {
    public static final int COUNT = 50;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<UUID> queue = new ArrayBlockingQueue<UUID>(10);
        Random random = new Random();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                for (int i=0; i<COUNT; i++) {
                    try {
                        Thread.sleep(random.nextInt(100, 500));
                        UUID value = UUID.randomUUID();
                        queue.put(value);
                        System.out.println("Put "+ value+ " Queue size:"+ queue.size());
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
                for (int i=0; i<COUNT; i++) {
                    try {
                        UUID value = queue.take();
                        System.out.println("Taken "+ value+ " Queue size:"+ queue.size());
                        Thread.sleep(random.nextInt(100, 1000));
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
