package no.kristiania.prg200.database.main;

import no.kristiania.prg200.Server.HttpEchoServer;
import no.kristiania.prg200.database.core.*;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;


public class Conference {

    SendRequest sr = new SendRequest ();

    public static void main(String[] args) throws IOException, SQLException {
        /*Creates a DBConnection-object that connects us to our DB*/
        //Properties prop = null;
        new HttpEchoServer ( 10081 );
        DBConnection dbConnection = new DBConnection();
        new Conference ().run(args);
//        DataSource dataSource = dbConnection.createDataSource();

        //DataSource dataSource = dbConnection.createDataSource( prop );
        //dataSource.getConnection();
//     configureFlyway ();

        //HttpEchoServer echoServer = new HttpEchoServer ( 5433 );
        //echoServer.main ( args );

//        /*Forsøker å lage et standard-objekt av track og skrive dem ut*/
//        Tracks tracks = new Tracks(dataSource);
////        RandomObject ro = new RandomObject ();
////        TimeslotsDao timeslotsDao = new TimeslotsDao ( dataSource );
////        Timeslots timeslots = new Timeslots(ro.randomLong (), ro.randomTime ());
////        timeslotsDao.save ( timeslots );
//
//        tracks.createStandardTracks();
//        Tracks test = tracks.createStandardTracks();
//        Tracks test2 = tracks.createStandardTracks ();
//        Tracks test3 = tracks.createStandardTracks ();
////
//        TracksDao tracksDao = new TracksDao ( dataSource );
//        tracksDao.save(test);
//        tracksDao.save(test2);
//        tracksDao.save(test3);
////        tracksDao.listAll();




    }

    public void run(String[] args) throws IOException, SQLException {
        sr.insertRoom ();
    }


}
