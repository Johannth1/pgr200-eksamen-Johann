package no.kristiania.prg200.database;

import org.flywaydb.core.Flyway;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;

public class TestDataSource {

    public static DataSource createDataSource(){
        JdbcDataSource dataSource = new JdbcDataSource ();
        dataSource.setUrl ( "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1" );
        dataSource.setUser ( "postgres" );
        dataSource.setPassword("root");

        Flyway flyway = new Flyway (  );
        flyway.setDataSource ( dataSource );
        flyway.migrate ();

        return dataSource;
    }
}
