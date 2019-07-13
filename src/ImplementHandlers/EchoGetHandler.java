package ImplementHandlers;

import Utils.ParseQuery;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class EchoGetHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        //Parse request
        Map<String, Object> parameters = new HashMap<String, Object>();
        URI requestedURI = httpExchange.getRequestURI();
        String query = requestedURI.getRawQuery();
        ParseQuery.parseQuery(query, parameters);

        //Send Response
        String response ="";
        for (String key : parameters.keySet())
            response += key + " = " + parameters.get(key) + "\n";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
