package no.kristiania.prg200.Client;

import no.kristiania.prg200.Server.HttpHeader;
import no.kristiania.prg200.Server.HttpIO;
import no.kristiania.prg200.Server.HttpQuery;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class HttpRequest {
    private String hostname;
    private int port;
    private String requestTarget;
    private String method = "GET";
    private String body;
    private HttpHeader httpHeader;

    public HttpRequest(String hostname, int port, String requestTarget) {
        this.hostname = hostname;
        this.port = port;
        this.requestTarget = requestTarget;
        this.httpHeader = new HttpHeader()
                .put("Connection", "close")
                .put("Host", hostname);
    }

    public static void main(String[] args) {
        try {
            new HttpRequest ( "localhost", 10081, "/echo" ).execute ();
            //System.out.println ("You are connected!");
        } catch (IOException e){
            System.err.println ("Error getting a http-connection: " + e.getMessage () + ", Cause of error: " + e.getCause ());
        } catch (SQLException e){
            System.out.println ("SQLException: " + e.getMessage ());
        }
    }

    public HttpResponse execute() throws IOException, SQLException {
        try (Socket socket = new Socket(hostname, port)) {
            writeRequestLine(socket);

            if (body != null) {
                httpHeader.setContentLength(body.getBytes().length);
            }
            httpHeader.writeTo(socket.getOutputStream());
            if (body != null) {
                socket.getOutputStream().write(body.getBytes());
            }
            return new HttpResponse(socket);
        }

    }

    public void writeRequestLine(Socket socket) throws IOException {
        HttpIO.writeLine(socket.getOutputStream(), method + " " + requestTarget + " HTTP/1.1");
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setFormBody(HttpQuery query) {
        this.body = query.toString();
        httpHeader.put("Content-type", "application/x-www-form-urlencoded");
    }
}
