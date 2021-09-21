package no.kristiania.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;



public class HttpClient {

    private final int statusCode;
    private final HashMap<String, String> headerFields = new HashMap<>();

    public HttpClient(String host, int port, String requestTarget) throws IOException {
        Socket socket = new Socket(host, port);

        String request = "GET " + requestTarget + " HTTP/1.1\r\n"+
                "Host: " + host +  "\r\n"+
                "Connection: close\r\n"+
                "\r\n";
                socket.getOutputStream().write(request.getBytes());


        String statusLine = readLine(socket);
        this.statusCode = Integer.parseInt(statusLine.split(" ")[1]);

        String headerField;

        while(!(headerField = readLine(socket)).isBlank()){
            int colonPos = headerField.indexOf(':');
            headerFields.put(headerField.substring(0,colonPos), headerField.substring(colonPos+1).trim());
        }

    }

    private String readLine(Socket socket) throws IOException {
        StringBuilder buffer = new StringBuilder();
        InputStream in = socket.getInputStream();

        int c;
        while((c = in.read()) != -1 && c != '\r') {
            buffer.append((char) c);
        }
            int expectedNewLine = socket.getInputStream().read();
            assert expectedNewLine == '\n';
            return buffer.toString();
    }



    public int getStatusCode () {
        return statusCode;
    }

    public String getHeader(String headerName){
        return headerFields.get(headerName);
    }

    public int getContentLength() {
        return Integer.parseInt(getHeader("Content-Length"));
    }
}

