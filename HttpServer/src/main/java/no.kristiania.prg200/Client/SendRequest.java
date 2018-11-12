package no.kristiania.prg200.Client;



import no.kristiania.prg200.Server.HttpQuery;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

public class SendRequest {

    private static HttpRequest hr;
    OutputStream output;
    HttpQuery httpQuery = new HttpQuery (  );

    public static void runUserbasedInsertsTalks(String[] args) throws IOException, SQLException {
        String message = "Vennligst skriv inn følgende felter i ";

        System.out.println (message + "talks: ");
        System.out.println ("talks_title, talks_description, talks_topic");
        insertTalk ();

        /*Prøvde å skrive ut URIen som en String med sout sånn at det var mulig å se den i sin helhet*/
//        String uriString;
//        uriString = sr.insertTalk ();
//        System.out.println (uriString);


    }

//    public PrintWriter sendRequestTarget(PrintWriter pw) throws IOException, SQLException {
//        String test = httpQuery.urlEncode(insertTalk ());
//        pw = new PrintWriter ( insertTalk () );
//        //output.;
//        System.out.println ("printer ut pw :\n" + pw);
//        return pw;
//    }


    public static String insertTalk() throws IOException, SQLException {

        Scanner reader = new Scanner(System.in);

        String title = reader.nextLine ();
        String description = reader.nextLine ();
        String topic = reader.nextLine ();

        String requestTarget = "/echo?add=talks.talks_title, talks_description, talks_topic("
                + title + ", " + description + ", " + topic + ")";

        hr = new HttpRequest("localhost", 10081, requestTarget);
        hr.execute ();

        return requestTarget;
    }

    public void insertRoom() throws IOException, SQLException {

        Scanner reader = new Scanner(System.in);

        String room = reader.nextLine ();

        String requestTarget = "/echo?add=rooms.rooms_room(" + room + ")";

        hr = new HttpRequest("localhost", 10081, requestTarget);

        hr.execute ();
    }


    public void insertDay() throws IOException, SQLException {

        Scanner reader = new Scanner(System.in);

        String day = reader.nextLine ();
        String date = reader.nextLine ();

        String requestTarget = "/echo?add=days.days_day, days_date ("
                                                    + day + ", " + date + ")";

        hr = new HttpRequest("localhost", 10081, requestTarget);

        hr.execute ();
    }

    public void insertTimeslots() throws IOException, SQLException {

        Scanner reader = new Scanner(System.in);

        String time = reader.nextLine ();

        String requestTarget = "/echo?add=timeslots.timeslots_time (" + time + ")";

        hr = new HttpRequest("localhost", 10081, requestTarget);

        hr.execute ();
    }

    public String insertTracks() throws IOException, SQLException {

        Scanner reader = new Scanner(System.in);

        String tracks_tracks = reader.nextLine ();
        String talks_id = reader.nextLine ();
        String days_id = reader.nextLine ();
        String timeslots_id = reader.nextLine ();
        String rooms_id = reader.nextLine ();

        String requestTarget = "/echo?add=tracks.tracks_tracks, talks_id, days_id, timeslots_id, rooms_id ("
                                                    + tracks_tracks + ", " + talks_id + ", " + days_id + ", "
                                                    + timeslots_id + ", " + rooms_id + ")";

        hr = new HttpRequest("localhost", 10081, requestTarget);

        hr.execute ();

        System.out.println (requestTarget);
        return requestTarget;
    }

}
