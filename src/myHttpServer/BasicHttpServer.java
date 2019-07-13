package myHttpServer;

import ImplementHandlers.EchoGetHandler;
import ImplementHandlers.EchoHeaderHandler;
import ImplementHandlers.EchoPostHandler;
import ImplementHandlers.RootHandler;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class BasicHttpServer {

    public static void main(String[] main) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/echoHeader", new EchoHeaderHandler());
        server.createContext("/echoGet", new EchoGetHandler());
        server.createContext("/echoPost", new EchoPostHandler());
        server.start();
    }

}