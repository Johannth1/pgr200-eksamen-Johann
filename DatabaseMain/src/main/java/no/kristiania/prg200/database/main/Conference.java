package no.kristiania.prg200.database.main;

import no.kristiania.prg200.Client.SendRequest;
import no.kristiania.prg200.Server.HttpEchoServer;
import no.kristiania.prg200.database.core.*;

import java.io.IOException;
import java.sql.SQLException;


public class Conference {

    SendRequest sr = new SendRequest ();

    public static void main(String[] args) throws IOException, SQLException {
        /*Creates a DBConnection-object that connects us to our DB*/
        //Properties prop = null;
        new HttpEchoServer ( 10081 );
        DBConnection dbConnection = new DBConnection();
        new Conference ().runInserts (args);

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

    public void runInserts(String[] args) throws IOException, SQLException {
        String message = "Vennligst skriv inn følgende felter i ";

        System.out.println (message + "rooms: ");
        System.out.println ("rooms_room");
        sr.insertRoom ();

        System.out.println (message + "talks: ");
        System.out.println ("talks_title, talks_description, talks_topic");
        sr.insertTalk ();

        System.out.println (message + "days: ");
        System.out.println ("days_day, days_date");
        sr.insertDay ();

        System.out.println (message + "timeslots: ");
        System.out.println ("timeslots_time");
        sr.insertTimeslots ();

        System.out.println (message + "tracks: ");
        System.out.println ("tracks_tracks, talks_id, days_id, timeslots_id, rooms_id");
        sr.insertTracks ();

    }


}
