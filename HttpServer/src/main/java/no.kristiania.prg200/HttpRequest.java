package no.kristiania.prg200;

import org.postgresql.shaded.com.ongres.scram.common.ScramAttributeValue;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

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

    public static void main(String[] args) throws IOException {
        new HttpRequest("localhost", 10080, "/echo").execute();
    }

    public HttpResponse execute() throws IOException{
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

    private void writeRequestLine(Socket socket) throws IOException {
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
