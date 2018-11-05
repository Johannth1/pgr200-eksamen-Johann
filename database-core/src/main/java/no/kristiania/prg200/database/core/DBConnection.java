package no.kristiania.prg200.database.core;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;
import javax.sql.DataSource;


/**
 * Creates a connection to our DB.
 *
 * Todo: Få flyway.migration() til å funke.
 */

public class DBConnection {

    public static DataSource createDataSource() throws NullPointerException {
        PGPoolingDataSource dataSource = new PGPoolingDataSource ();
        dataSource.setURL ( "jdbc:postgresql://localhost:5433/postgres" );
        dataSource.setUser ( "postgres" );
        dataSource.setPassword ( "root" );

        Flyway flyway = new Flyway ();
        flyway.setDataSource ( dataSource );
        flyway.setBaselineOnMigrate ( true );
        flyway.migrate();
        flyway.clean();

        return dataSource;
    }

}
