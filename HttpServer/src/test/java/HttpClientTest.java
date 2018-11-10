import no.kristiania.prg200.Client.HttpRequest;
import no.kristiania.prg200.Client.HttpResponse;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class HttpClientTest {
    @Test
    public void shouldExecuteHttpRequest() throws IOException, SQLException {
        HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo");
        HttpResponse response = request.execute();
        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    public void shouldParseStatusLine() throws IOException, SQLException {
        HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?status=404");
        HttpResponse response = request.execute();
        assertThat(response.getStatusCode()).isEqualTo(404);
        assertThat(response.getStatusText()).isEqualTo("Not Found");
    }

    @Test
    public void shouldParseHeaders() throws IOException, SQLException {
        HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?Location=http%3A%2F%2Fwww.google.com");
        HttpResponse response = request.execute();
        assertThat(response.getHeader("location")).isEqualTo("http://www.google.com");
    }

    @Test
    public void shouldReadBody() throws IOException, SQLException {
        HttpRequest request = new HttpRequest("urlecho.appspot.com", 80,
                "/echo?body=hello+world");
        HttpResponse response = request.execute();
        assertThat(response.getBody()).isEqualTo("hello world");

    }
}
