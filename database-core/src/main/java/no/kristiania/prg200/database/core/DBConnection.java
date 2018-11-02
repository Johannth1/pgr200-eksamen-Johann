package no.kristiania.prg200.database.core;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * Creates a connection to our DB.
 */

public class DBConnection {

//    public static void main(String[] args) throws SQLException {
//        DataSource dataSource = createDataSource();
//        dataSource.getConnection();
//    }

    public static DataSource createDataSource() {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setURL("jdbc:postgresql://localhost:5433/jdbc_innlevering");
        //dataSource.setURL("jdbc:postgresql://localhost:5433/postgres");
        dataSource.setUser("postgres");
        dataSource.setPassword("root");

        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setBaselineOnMigrate(true);

        //flyway.configure();


        flyway.migrate();
        //flyway.clean();

        return dataSource;
    }
}
