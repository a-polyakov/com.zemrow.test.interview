package interview.mongodb.connectiopool;

import javax.sql.DataSource;

/**
 * Simplified version
 * @see javax.sql.DataSource
 */
public interface IConnectionPool {
    IConnection getConnection();

    void release(ConnectionImpl connection);
}
