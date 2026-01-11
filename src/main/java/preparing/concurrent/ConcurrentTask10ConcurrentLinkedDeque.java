package preparing.concurrent;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentTask10ConcurrentLinkedDeque {
    public static final int COUNT = 50;

    public static void main(String[] args) throws Exception {

        ConcurrentLinkedDeque<UUID> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

        Random random = new Random();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                for (int i=0; i<COUNT; i++) {
                    try {
                        Thread.sleep(random.nextInt(100, 500));
                        UUID value = UUID.randomUUID();
                        concurrentLinkedDeque.addFirst(value);
                        System.out.println("AddFirst "+ value+ " Queue size:"+ concurrentLinkedDeque.size());
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
                        Thread.sleep(random.nextInt(100, 500));
                        UUID value = UUID.randomUUID();
                        concurrentLinkedDeque.addLast(value);
                        System.out.println("AddLast "+ value+ " Queue size:"+ concurrentLinkedDeque.size());
                    } catch (InterruptedException ignore) {
                    }
                }
                System.out.println("Thread 2 finish");
            }
        };
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 3 start");
                for (int i=0; i<COUNT; i++) {
                    try {
                        UUID value = concurrentLinkedDeque.pollFirst();
                        System.out.println("PollFirst "+ value+ " Queue size:"+ concurrentLinkedDeque.size());
                        Thread.sleep(random.nextInt(100, 1000));
                    } catch (InterruptedException ignore) {
                    }
                }
                System.out.println("Thread 3 finish");
            }
        };
        Thread thread4 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 4 start");
                for (int i=0; i<COUNT; i++) {
                    try {
                        UUID value = concurrentLinkedDeque.pollLast();
                        System.out.println("PollLast "+ value+ " Queue size:"+ concurrentLinkedDeque.size());
                        Thread.sleep(random.nextInt(100, 1000));
                    } catch (InterruptedException ignore) {
                    }
                }
                System.out.println("Thread 4 finish");
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println("Test end");
    }
}
