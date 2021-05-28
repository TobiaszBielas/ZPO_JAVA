import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Server extends WebSocketServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static ArrayList<WebSocket> connections = new ArrayList<WebSocket>();
    public Server(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket web_socket, ClientHandshake client_handshake) {
        LOGGER.info("Open");
        connections.add(web_socket);
    }
    @Override
    public void onClose(WebSocket web_socket, int i, String s, boolean b) {
        LOGGER.info("Close");
        connections.remove(web_socket);
    }
    @Override
    public void onMessage(WebSocket web_socket, String s) {
        LOGGER.debug("Message: {}", s);
        web_socket.send("Yes, How can I serve U?");
        connections.stream().filter(ws->!web_socket.equals(ws)).forEach(ws->{ws.send(s);});
    }
    @Override
    public void onError(WebSocket web_socket, Exception e) {
        LOGGER.info("Error");
    }
    @Override
    public void onStart() throws NullPointerException{
        LOGGER.info("Start");
    }
}
