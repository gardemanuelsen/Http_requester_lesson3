package no.kristiania.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HttpClient {

    public HttpClient(String host, int port, String requestTarget) {

    }

    public static void main(String[] args) throws IOException {


        Socket socket = new Socket("httpbin.org", 80);
        String request = "";
        socket.getOutputStream().write(request.getBytes());

        //noinspection TextBlockMigration
        socket.getOutputStream().write(
                ("GET /html HTTP/1.1\r\n" +
                        "Host: httbin.org\r\n" +
                        "\r\n").getBytes()
        );

        InputStream in = socket.getInputStream();

        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static int getStatusCode() {
        return 0;

    }
}

