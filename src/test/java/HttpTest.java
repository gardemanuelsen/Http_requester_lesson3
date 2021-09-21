import no.kristiania.http.HttpClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpTest {

    @Test
    void shouldReturnStatusCode() throws IOException {
        assertEquals(200, new HttpClient("httpbin.org",80, "/html").getStatusCode());
    }

    @Test
    void shouldReturnStatusCode404() throws IOException {
        assertEquals(404, new HttpClient("httpbin.org",80, "/no-such-page").getStatusCode());
    }


    @Test
    void shouldReturnHeaders() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals("text/html; charset=utf-8",client.getHeader("Content-Type"));
    }

    @Test
    void shouldReadContentLength() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals(3741,client.getContentLength());
    }

}
