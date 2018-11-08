package no.kristiania.prg200;

import java.io.IOException;
import java.net.Socket;

public class HttpResponse {
    private HttpHeader responseHeader = new HttpHeader();
    private int statusCode;
    private String statusText;
    private String body;

    public HttpResponse(Socket socket) throws IOException {
        parseStatusLine(HttpIO.readLine(socket.getInputStream()));
        responseHeader.readHeader(socket.getInputStream());
        body = HttpIO.readBody(socket.getInputStream(), responseHeader.getContentLength());
    }

    private void parseStatusLine(String statusLine){
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
