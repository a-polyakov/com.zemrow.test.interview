package interview.mongodb.connectiopool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolImpl implements IConnectionPool {

    private final BlockingQueue<IConnection> pool;
    private final AtomicInteger created;
    private final int maxPoolSize;
    private final int connectionTimeout;

    public ConnectionPoolImpl(int minIdle, int maxPoolSize, int connectionTimeout) {
        this.pool = new LinkedBlockingQueue<>();
        for (int i = 0; i < minIdle; i++) {
            pool.add(newConnection());
        }
        this.created = new AtomicInteger(pool.size());
        this.maxPoolSize = maxPoolSize;
        this.connectionTimeout = connectionTimeout;
    }

    @Override
    public IConnection getConnection() {
        try {
            IConnection connection = pool.poll();
            if (connection != null) {
                return connection;
            }
            if (created.get() < maxPoolSize) {
                if (created.incrementAndGet() <= maxPoolSize) {
                    return newConnection();
                }
                created.decrementAndGet();
            }
            connection = pool.poll(connectionTimeout, TimeUnit.MILLISECONDS);
            if (connection == null) {
                throw new TimeoutException(
                        "Timeout waiting for connection from pool"
                );
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void release(ConnectionImpl connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }

    private IConnection newConnection() {
        return new ConnectionImpl(this);
    }
}
