package preparing.concurrent;

import java.util.concurrent.CountDownLatch;

public class ConcurrentTask06CountDownLatch {
    public static final int COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(COUNT);

        for (int i = 0; i < COUNT; i++) {
            final int iFinal = i;
            Thread thread = new Thread() {
                @Override
                public void run() {
                    System.out.println("Thread " + iFinal + " start");
                    try {
                        Thread.sleep((long) (10000 * Math.random()));
                    } catch (InterruptedException ignore) {
                    }
                    latch.countDown();
                    System.out.println("Thread " + iFinal + " finish");
                }
            };
            thread.start();
        }

        latch.await();
        System.out.println("Test end");
    }
}
