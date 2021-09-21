package no.kristiania.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HttpClient {

    public HttpClient(String host, int port, String requestTarget) {
    }

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("httpbin.org", 80);

        String request = "GET /html HTTP/1.1\r\n" +
                "Host: httbin.org\r\n" +
                "\r\n";

        socket.getOutputStream().write(request.getBytes());





    }


    private String readLine(Socket socket) throws IOException {
        StringBuilder result = new StringBuilder();
        InputStream in = socket.getInputStream();

        int c;
        while ((c = in.read()) != -1 && c != '\r') {
            result.append((char)c);
        }
        //noinspection ResultOfMethodCallIgnored
        in.read();
        return result.toString();
    }

    public int getStatusCode () {
        return 401;
    }

}

