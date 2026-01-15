package interview.mongodb.connectiopool;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunMyConnectionPool {
    private final static int THREAD_COUNT = 20;

    public static void main(String[] args) {
        try (final ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT)) {
            final IConnectionPool connectionPool = new ConnectionPoolImpl(4, 10, 10000);
            for (int i = 0; i < THREAD_COUNT; i++) {
                service.execute(() -> {
                    try (IConnection connection = connectionPool.getConnection()) {
                        int queryCount = new Random().nextInt(1, 5);
                        for (int j = 0; j < queryCount; j++) {
                            connection.execute("select * from users");
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
        System.out.println("Test end");
    }
}
