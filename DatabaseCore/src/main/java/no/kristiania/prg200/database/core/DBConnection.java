package no.kristiania.prg200.database.core;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Creates a connection to our DB.
 *
 * Todo: flyway.migration() + flyway.clean()
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
        //flyway.clean();

        return dataSource;
    }

    /*public static Flyway configureFlyway() throws IOException{
        Properties properties = new Properties (  );
        InputStream inputStream = null;

        inputStream = new FileInputStream ( "innlevering.properties" );
        properties.load ( inputStream );

        Flyway flyway = Flyway.configure()
                .dataSource(
                properties.getProperty ( "url" ),
                properties.getProperty ( "username" ),
                properties.getProperty ( "password" )
                ).load();
        return flyway;
    }*/

}
