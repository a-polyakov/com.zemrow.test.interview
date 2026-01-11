package preparing.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentTask08Futures {
    public static void main(String[] args) throws Exception {

        final ExecutorService service = Executors.newSingleThreadExecutor();

        final Future<Long> sumResult = service.submit(() -> {
            long sum = 0;
            for (int i = 0; i < 100_000_000; i++) {
                sum += i;
            }
            return sum;
        });

        System.out.println(sumResult.isDone() ? sumResult.get() : "No any result yet!");

        System.out.println(sumResult.get());

        service.shutdown();
    }
}
