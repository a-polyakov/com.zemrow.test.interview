package preparing.concurrent;

public class ConcurrentTask05DeadLock {

    public static void main(String[] args) throws InterruptedException {
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                synchronized (resource1) {
                    System.out.println("Thread 1: locked resource 1");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ignore) {
                    }

                    System.out.println("Thread 1: Try lock resource 2");
                    synchronized (resource2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
                System.out.println("Thread 1 finish");
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }

                    System.out.println("Thread 2: Try lock resource 1");
                    synchronized (resource1) {
                        System.out.println("Thread 2: locked resource 1");
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
