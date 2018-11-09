package no.kristiania.prg200;

import no.kristiania.prg200.database.core.TracksDao;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Todo: test og se om du kan instansiere TracksDao i serveren.
 */

public class HttpResponse {
    private HttpHeader responseHeader = new HttpHeader();
    private int statusCode;
    private String statusText;
    private String body;
    //private TracksDao tracksDao;

    public HttpResponse(Socket socket) throws IOException, SQLException {
        parseStatusLine(HttpIO.readLine(socket.getInputStream()));
        responseHeader.readHeader(socket.getInputStream());
        body = HttpIO.readBody(socket.getInputStream(), responseHeader.getContentLength());
        //body = tracksDao.listAll ().toString ();
    }

    public void parseStatusLine(String statusLine){
        int firstSpacePos = statusLine.indexOf(' ');
        int secondSpacePos = statusLine.indexOf(' ', firstSpacePos+1);
        this.statusCode = Integer.parseInt(statusLine.substring(firstSpacePos+1, secondSpacePos));
        this.statusText = statusLine.substring(secondSpacePos+1);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusText() {
        return statusText;
    }

    public String getHeader(String key) {
        return responseHeader.get(key);
    }

    public String getBody() {
        return body;
    }
}
