import no.kristiania.http.HttpClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientTest {

    @Test
    void dummyTest() {
        assertEquals(42, 6*7);
    }

    @Test
    void shouldGetFailureResponseCode() {
        HttpClient client = new HttpClient("httpbin.org", 80, "/status/403");
        assertEquals(200, HttpClient.getStatusCode());
    }

}
