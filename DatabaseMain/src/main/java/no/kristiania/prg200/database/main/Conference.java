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

        new HttpEchoServer ( DBConnection.createDataSource (), 10081 );

        new Conference ().runUserbasedInsertsTalks (args);



        //Prøver å sende String via en type OutputStream GET/echo?add=talks.talks_title, talks_description, talks_topic(?, ?, ?)
        //videre til DBen og så dekode stringen så det blir en SQL request

        SendRequest sr = new SendRequest ();
        PrintWriter pw = null;
        pw = new PrintWriter (sr.sendRequestTarget ( pw ));
        //sr.sendRequestTarget ( pw );
        System.out.println (pw);


    }


    public void runUserbasedInsertsTalks(String[] args) throws IOException, SQLException {
        String message = "Vennligst skriv inn følgende felter i ";

        System.out.println (message + "talks: ");
        System.out.println ("talks_title, talks_description, talks_topic");
        sr.insertTalk ();

        /*Prøvde å skrive ut URIen som en String med sout sånn at det var mulig å se den i sin helhet*/
//        String uriString;
//        uriString = sr.insertTalk ();
//        System.out.println (uriString);


    }


}
