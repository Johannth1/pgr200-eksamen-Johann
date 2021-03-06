package no.kristiania.prg200.Server;


import no.kristiania.prg200.Client.SendRequest;
import no.kristiania.prg200.database.core.DBConnection;
import no.kristiania.prg200.database.core.TalksDao;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class HttpEchoServer {

    static DataSource dataSource;
    private ServerSocket serverSocket;

    public HttpEchoServer(DataSource dataSource, int port) throws IOException{
        serverSocket = new ServerSocket (port);
        this.dataSource = dataSource;
        new Thread(this::runServerThread).start();

    }

    public static void main(String[] args) throws IOException{
        new HttpEchoServer(DBConnection.createDataSource (  ), 10081);
    }

//    private Connection conn =  null;
//    public Statement sqlConnect(){
//        try {
//            Class.forName ( "com.mysql.jdbc.Driver" ).newInstance ();
//            conn =
//                    DriverManager.getConnection ( "jdbc:postgresql://localhost:5433/postgres",
//                            "postgres", "root");
//        } catch (Exception e){
//            System.out.println ("Error: " + e.getMessage ());
//        }
//        return null;
//    }
    private void runServerThread(){
        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
                //sqlConnect ();
            } catch (RuntimeException e) {
                if (clientSocket != null) {
                    try {
                        clientSocket.close();
                    } catch (IOException ioEx) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    private void handleRequest(Socket clientSocket) throws IOException{
        String statusCode = null;
        String body = null;
        String add;


        HttpQuery query = null;
        HttpHeader responseHeader = new HttpHeader();

        try {
            String requestLine = HttpIO.readLine(clientSocket.getInputStream());
            String requestTarget = requestLine.split(" ")[1];
            HttpPath path = new HttpPath(requestTarget);

            HttpHeader headers = new HttpHeader();
            headers.readHeader(clientSocket.getInputStream());

            if (requestLine.split(" ")[0].equals("POST")) {
                query = new HttpQuery(HttpIO.readBody(clientSocket.getInputStream(), headers.getContentLength()));
            } /*if (requestLine.split(" ")[0].equals("GET")) {
                query = new HttpQuery(HttpIO.readBody(clientSocket.getInputStream(), headers.getContentLength()));
            }*/ else {
                query = path.query();
            }



            TalksDao dao = new TalksDao (dataSource);

            statusCode = query.get("status").orElse("200");
            //body = dao.listAll().toString();

            body = query.get("body").orElse("None");
            add = query.get("add").orElse("");
            System.out.println (add);


        } catch (RuntimeException e) {
            e.printStackTrace();
            writeResponseLine(clientSocket, "500");
            responseHeader.writeTo(clientSocket.getOutputStream());
            return;
//        } catch (SQLException e) {
//            e.printStackTrace ();
        }

        writeResponseLine(clientSocket, statusCode);
        responseHeader
                .put("Content-Type", "text/plain; charset=utf-8")
                .setContentLength(body.length());
        query.get("Location").ifPresent(value -> {
            responseHeader.put("Location", value);
        });

        responseHeader.writeTo(clientSocket.getOutputStream());

        clientSocket.getOutputStream().write(body.getBytes());
    }

    public void writeResponseLine(Socket clientSocket, String statusCode) throws IOException {
        String statusMessage = getStatusMessages (statusCode);
        HttpIO.writeLine(clientSocket.getOutputStream(), "HTTP/1.1 " + statusCode + " " + statusMessage);
    }

    private String getStatusMessages(String statusCode) {
        return statusMessages.get(statusCode);
    }

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    private static Map<String, String> statusMessages = new HashMap<> ();
    static {
        statusMessages.put("200", "OK");
        statusMessages.put("202", "Accepted");
        statusMessages.put("404", "Not Found");
        statusMessages.put("500", "Internal Server Error");
    }

    //TODO: lag en metode som håndterer "add", gjør om til INSERT INTO + finne ut hvor de forskjellige metodene skal ligge og hva som funker for vårt program

    public String insertRoomQuery(String s) throws IOException, SQLException {
        SendRequest sr = new SendRequest();
        sr.insertRoom ();

        String table = s.substring(0, s.indexOf("."));
        String column = s.substring(s.indexOf(".") + 1, s.indexOf("("));
        String value = s.substring(s.indexOf("(") + 1, s.indexOf(")"));

        String sqlInsertRoom = "INSERT INTO " + table + "." + column + "(" + value + ")";

        return sqlInsertRoom;

    }
}
