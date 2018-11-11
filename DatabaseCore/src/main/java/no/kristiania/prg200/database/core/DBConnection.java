package no.kristiania.prg200.database.core;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConnection {

    public static DataSource createDataSource() {
        Properties properties = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream("/Users/linenathalieronning/Desktop/AvansertJavaMappe/--EKSAMEN--JAVA--/pgr200-eksamen-LegoLine/DatabaseCore/src/main/resources/innlevering.properties");
            properties.load(input);
            PGPoolingDataSource dataSource = new PGPoolingDataSource();
            dataSource.setUrl(properties.getProperty("dataSource.url"));
            dataSource.setUser(properties.getProperty("dataSource.username"));
            dataSource.setPassword(properties.getProperty("dataSource.password"));
            Flyway.configure().dataSource(dataSource).load().migrate();

            return dataSource;

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }
}

/*
package no.kristiania.prg200.database.core;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


*/
/**
 * Creates a connection to our DB.
 * <p>
 * Todo: flyway.migration() + flyway.clean()
 *//*


public class DBConnection {

    private static Properties prop = null;
    private static Flyway flyway;
    private static InputStream input = null;

    */
/*public static void main(String[] args) {
        try {
            createDataSource (prop);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }*//*


    public static DataSource createDataSource() throws NullPointerException, IOException {
        PGPoolingDataSource dataSource = new PGPoolingDataSource ();
        dataSource.setURL (prop.getProperty ( "jdbc:postgresql://localhost:5433/postgres"));
        dataSource.setUser ( prop.getProperty ( "postgres" ) );
        dataSource.setPassword ( prop.getProperty ( "root" ) );
        configureFlyway ().load();
        return dataSource;
    }

    public static DataSource configureFlyway() throws IOException {
        try {
            String fileName = "innlevering.properties";
            input = DBConnection.class.getClassLoader ().getResourceAsStream ( fileName );
            prop.load ( input );
        } catch (IOException io) {
            io.printStackTrace ();
        } finally {
            if (input != null) {
                try {
                    input.close ();
                } catch (IOException io) {
                    System.out.println ("Error: ");
                    io.printStackTrace ();
                }
            }
        }
        flyway = Flyway.configure().dataSource (
                prop.getProperty ( "dataSource.url" ),
                prop.getProperty ( "dataSource.username" ),
                prop.getProperty ( "dataSource.password" )).load();
        flyway.setBaselineOnMigrate ( true );

        DataSource dataSource = createDataSource ();
//        DataSource dataSource = createDataSource (prop);
        try {
            executeConnection ( dataSource, readFile ( "/Users/linenathalieronning/Desktop/AvansertJavaMappe/--EKSAMEN--JAVA--/pgr200-eksamen-LegoLine/DatabaseCore/src/main/resources/db/migration/V001__create_table_talks.sql" ) );
            executeConnection ( dataSource, readFile ( "/Users/linenathalieronning/Desktop/AvansertJavaMappe/--EKSAMEN--JAVA--/pgr200-eksamen-LegoLine/DatabaseCore/src/main/resources/db/migration/V002__create_table_days.sql" ) );
            executeConnection ( dataSource, readFile ( "/Users/linenathalieronning/Desktop/AvansertJavaMappe/--EKSAMEN--JAVA--/pgr200-eksamen-LegoLine/DatabaseCore/src/main/resources/db/migration/V003__create_table_timeslots.sql" ) );
            executeConnection ( dataSource, readFile ( "/Users/linenathalieronning/Desktop/AvansertJavaMappe/--EKSAMEN--JAVA--/pgr200-eksamen-LegoLine/DatabaseCore/src/main/resources/db/migration/V004__create_table_rooms.sql" ) );
            executeConnection ( dataSource, readFile ( "/Users/linenathalieronning/Desktop/AvansertJavaMappe/--EKSAMEN--JAVA--/pgr200-eksamen-LegoLine/DatabaseCore/src/main/resources/db/migration/V005__create_table_tracks.sql" ) );
        } catch (SQLException e){
            e.printStackTrace ();
        }
        return dataSource;
    }
    private static int executeConnection(DataSource data, String query) throws SQLException {
        return executeUpdate(data.getConnection(), query);
    }
    private static String readFile(String filePath) {
        try (FileInputStream is = new FileInputStream (new File (filePath))) {
            char[] charArray = new char[is.available()];
            while (is.available() > 0) {
                charArray[charArray.length - is.available()] = (char) is.read();
            }
            return new String(charArray);
        } catch (IOException io) {
            io.printStackTrace();
        }
        return "";
    }
    private static int executeUpdate(Connection conn, String query) throws SQLException {
        if (conn == null) {
            System.err.println("Connection not reached!\n" + query);
            return -1;
        }
        Statement s = conn.createStatement();
        int r = s.executeUpdate(query);
        s.close();
        return r;
    }

}
*/
