package preparing.concurrent;

public class ConcurrentTask07Volatile {
    public static boolean shutdown = false;
//    public static volatile boolean shutdown = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(){
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {
                }
                shutdown=true;
                System.out.println("Thread 1 finish");
            }
        };
        Thread thread2=new Thread(){
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                int i=0;
                while (!shutdown){
                    i++;
                }
                System.out.println("Thread 2 finish, i:"+i);
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Test end");
    }
}
