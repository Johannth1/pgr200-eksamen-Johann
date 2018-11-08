

import no.kristiania.prg200.HttpEchoServer;
import no.kristiania.prg200.HttpRequest;
import no.kristiania.prg200.HttpResponse;
import org.junit.Test;
import no.kristiania.*;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HttpServerTest {

    private static HttpEchoServer server;

    @Test
    public void shouldPerformeHttpRequest() throws IOException {
        HttpRequest httpRequest = new HttpRequest ("localhost", server.getPort(), "/echo");
        HttpResponse httpResponse = httpRequest.execute();
        assertThat(httpResponse.getStatusCode()).isEqualTo(200);
    }
}
