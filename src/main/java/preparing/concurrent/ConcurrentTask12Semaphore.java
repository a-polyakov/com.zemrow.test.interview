package preparing.concurrent;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class ConcurrentTask12Semaphore {
    public static class Processor {

        private final Semaphore semaphore = new Semaphore(3);

        public void use(String threadName) {
            try {
                semaphore.acquire();
                System.out.println(threadName + " acquired permit");

                Thread.sleep(new Random().nextInt(100, 500));

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println(threadName + " released permit");
                semaphore.release();
            }
        }
    }

    public static final int COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        final Processor processor = new Processor();
        for (int i = 0; i < COUNT; i++) {
            final int iFinal = i;
            Thread thread = new Thread() {
                @Override
                public void run() {
                    System.out.println("Thread " + iFinal + " start");
                    processor.use("Thread " + iFinal);
                    System.out.println("Thread " + iFinal + " finish");
                }
            };
            thread.start();
        }

        System.out.println("Test end");
    }
}
