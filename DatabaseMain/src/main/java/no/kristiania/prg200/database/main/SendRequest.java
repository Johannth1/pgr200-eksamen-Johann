package no.kristiania.prg200.database.main;


import no.kristiania.prg200.Client.HttpRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class SendRequest {

    private HttpRequest hr;

    public void insertRoom() throws IOException, SQLException {

        Scanner reader = new Scanner(System.in);

        String room = reader.nextLine ();

        String requestTarget = "/echo?add=rooms.rooms_room(" + room + ")";

        hr = new HttpRequest("localhost", 10081, requestTarget);

        hr.execute ();
    }

}
