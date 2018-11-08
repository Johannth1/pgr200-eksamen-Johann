package no.kristiania.prg200;

public class HttpRequest {
    private String hostname;
    private int port;
    private String requestTarget;
    private String method = "GET";
    private HttpHeader httpHeaders;
    private String body;

    public HttpRequest(String hostname, int port, String requestTarget) {
        this.hostname = hostname;
        this.port = port;
        this.requestTarget = requestTarget;
        this.httpHeaders = new HttpHeader()
                .put("Connection", "close")
                .put("Host", hostname);
    }
}
