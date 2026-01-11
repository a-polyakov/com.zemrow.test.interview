package preparing.concurrent;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ConcurrentTask13ThreadStatus {

    public static void main(String[] args) throws InterruptedException {
//        NEW
//        RUNNABLE
//        BLOCKED
//        WAITING
//        TIMED_WAITING
//        TERMINATED

        final Object resource = "resource";

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread start");
                long time = System.currentTimeMillis();
                while (System.currentTimeMillis()-time<1000){
                    Math.sin(System.currentTimeMillis());
                }
                synchronized (resource) { // BLOCKED
                    try {
                        resource.wait(); // WAITING
                    } catch (InterruptedException ignore) {
                    }
                }
                try {
                    Thread.sleep(1000); // TIMED_WAITING
                } catch (InterruptedException ignore) {
                }
                System.out.println("Thread finish");
            }
        }; // NEW

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Status: " + thread.getState());
        }, 500, 1000, TimeUnit.MILLISECONDS);

        Thread.sleep(1000);
        synchronized (resource) {
            thread.start(); // RUNNABLE
            Thread.sleep(2000); // BLOCKED
        }
        Thread.sleep(1000);
        synchronized (resource) {
            resource.notify(); // End WAITING
        }
        thread.join();
        // TERMINATED
        Thread.sleep(1000);
        scheduler.shutdown();
    }
}
