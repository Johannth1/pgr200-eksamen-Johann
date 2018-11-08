

import no.kristiania.prg200.HttpEchoServer;
import no.kristiania.prg200.HttpRequest;
import org.junit.Test;
import no.kristiania.*;

public class HttpServerTest {

    private static HttpEchoServer server;

    @Test
    public void shouldPerformeHttpRequest(){
        HttpRequest httpRequest = new HttpRequest ("localhost", server.getPort(), "/echo");
    }
}
