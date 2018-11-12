package no.kristiania.prg200.database.main;

import no.kristiania.prg200.Client.SendRequest;
import no.kristiania.prg200.Server.HttpEchoServer;
import no.kristiania.prg200.database.core.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;


public class Conference {

    SendRequest sr = new SendRequest ();

    public static void main(String[] args) throws IOException, SQLException {

        new HttpEchoServer ( DBConnection.createDataSource (), 10081 );

        new Conference ().runUserbasedInsertsTalks (args);

        SendRequest sendRequest = new SendRequest ();
        SendRequest test = sendRequest.sendRequestTarget ();
        InputStream inputStream = null;
        inputStream.read (test);




    }

    public void runUserbasedInsertsTalks(String[] args) throws IOException, SQLException {
        String message = "Vennligst skriv inn følgende felter i ";

//        System.out.println (message + "rooms: ");
//        System.out.println ("rooms_room");
//        sr.insertRoom ();

        System.out.println (message + "talks: ");
        System.out.println ("talks_title, talks_description, talks_topic");
        sr.insertTalk ();

//        System.out.println (message + "days: ");
//        System.out.println ("days_day, days_date");
//        sr.insertDay ();
//
//        System.out.println (message + "timeslots: ");
//        System.out.println ("timeslots_time");
//        sr.insertTimeslots ();
//
//        System.out.println (message + "tracks: ");
//        System.out.println ("tracks_tracks, talks_id, days_id, timeslots_id, rooms_id");
//        sr.insertTracks ();

    }


}
