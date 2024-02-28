package jdk21;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpSimpleServerDemo {
    public static void main(String[] args) throws IOException {
        int port = 8080; // Replace with your desired port number
        String message = "Hello, world!";

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new MyHandler(message));
        server.start();
        System.out.println("Server started on port: " + port);
    }

    static class MyHandler implements HttpHandler {
        private final String message;

        public MyHandler(String message) {
            this.message = message;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "HTTP/1.1 200 OK\nContent-Type: text/plain\n\n" + message;
            exchange.getResponseHeaders().set("Content-Length", String.valueOf(response.length()));
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
