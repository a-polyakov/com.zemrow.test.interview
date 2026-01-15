package interview.mongodb.connectiopool;

import java.util.Random;
import java.util.UUID;

public class ConnectionImpl implements IConnection {

    private final UUID id;
    private final IConnectionPool connectionPool;

    public ConnectionImpl(IConnectionPool connectionPool) {
        id = UUID.randomUUID();
        System.out.println("Create new connection " + id);
        this.connectionPool = connectionPool;
    }

    @Override
    public void execute(String sql) {
        System.out.println("Executing on connection " + id);
        try {
            Thread.sleep(new Random().nextInt(50, 200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        System.out.println("Release connection " + id);
        connectionPool.release(this);
    }
}
