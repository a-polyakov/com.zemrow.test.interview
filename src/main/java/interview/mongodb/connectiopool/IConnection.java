package interview.mongodb.connectiopool;


import java.io.Closeable;

/**
 * Simplified version
 * @see java.sql.Connection
 */
public interface IConnection extends Closeable {
    void execute(String sql);
}
