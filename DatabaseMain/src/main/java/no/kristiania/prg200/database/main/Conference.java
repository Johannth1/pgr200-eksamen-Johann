package no.kristiania.prg200.database.main;

import no.kristiania.prg200.Client.SendRequest;
import no.kristiania.prg200.Server.HttpEchoServer;
import no.kristiania.prg200.database.core.*;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;


public class Conference {

    SendRequest sr = new SendRequest ();

    public static void main(String[] args) throws IOException, SQLException {

        //starter opp serveren og kobler den sammen med postgres-databasen
        new HttpEchoServer ( DBConnection.createDataSource (), 10081 );

        //tar imot brukerinput fra terminal og gjør om til en URI/URL som etter hvert kan sendes med en type outputstream.
        SendRequest.runUserbasedInsertsTalks (args);



        //Prøver å sende String via en type OutputStream GET/echo?add=talks.talks_title, talks_description, talks_topic(?, ?, ?)
        //videre til DBen og så dekode stringen så det blir en SQL request

//        SendRequest sr = new SendRequest ();
//        PrintWriter pw = null;
//        sr.sendRequestTarget ( pw );
        //pw = new PrintWriter (sr.sendRequestTarget ( pw ));
        //pw.println (  );
        //sr.sendRequestTarget ( pw );
        //System.out.println (pw);


        //Legger inn tilfeldige data i tabellene i databasen vår.
        Tracks tracks = new Tracks ( DBConnection.createDataSource () );
        TracksDao tracksDao = new TracksDao (DBConnection.createDataSource ());

        Tracks sampleTrack = tracks.createStandardTracks ();
        Tracks sampleTrack1 = tracks.createStandardTracks ();
        Tracks sampleTrack2 = tracks.createStandardTracks ();

        tracksDao.save ( sampleTrack );
        tracksDao.save ( sampleTrack1 );
        tracksDao.save ( sampleTrack2 );

        //Lister opp dataene i databasen vår.
        tracksDao.listAll ();



    }




}
