package no.kristiania.prg200.database.main;

import no.kristiania.prg200.database.*;

import no.kristiania.prg200.database.core.*;
import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;
import org.xml.sax.ext.Locator2;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


public class Conference {

    public static void main(String[] args) throws IOException, SQLException {
        /*Creates a DBConnection-object that connects us to our DB*/
        DBConnection dbConnection = new DBConnection ();
        DataSource dataSource = dbConnection.createDataSource();
        dataSource.getConnection();

        /*Forsøker å lage et standard-objekt av track og skrive dem ut*/
        Tracks tracks = new Tracks(dataSource);
        tracks.createStandardTracks();

//        ArrayList<Tracks> tracksArrayList = new ArrayList<>();

        /*Tester ut metodene fra RoomsDao mot selve databasen*/
//        Rooms rooms = new Rooms(2L, "Rosérommet");
//        Rooms rooms1 = new Rooms(3L, "Testrom");
//        Rooms rooms2 = new Rooms(4L, "Himmelsalen");
//
//        RoomsDao roomsDao = new RoomsDao(dataSource);
//        roomsDao.save(rooms);
//        roomsDao.save(rooms1);
//        roomsDao.save(rooms2);
//
//        roomsDao.listAll();
//
//        Days days = new Days(1L, "Mandag", "22.10.2018");
//        Days days1 = new Days(1L, "Mandag", "22.10.2018");
//        Days days2 = new Days(1L, "Mandag", "22.10.2018");
//
//        DaysDao daysDao = new DaysDao(dataSource);
//        daysDao.save(days);
//        daysDao.save(days1);
//        daysDao.save(days2);
//
//        daysDao.listAll ();


//        createProperties ();
//        createProperties2 ();
    }


//    public static Properties createProperties(){
//        Properties properties = new Properties ();
//        try ( FileReader reader = new FileReader("innlevering.properties")) {
//            properties.load(reader);
//        } catch (IOException e){
//            System.out.println (e.getMessage ());
//        }
//        return properties;
//    }
//
//    public static void createProperties2(){
//        Properties properties = new Properties ();
//        try ( FileReader reader = new FileReader("innlevering.properties") ) {
//            properties.load(reader);
//        } catch (IOException e){
//            System.out.println (e.getMessage ());
//        }
//    }

}
