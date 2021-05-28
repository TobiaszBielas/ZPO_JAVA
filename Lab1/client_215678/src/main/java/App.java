import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
        public static void main(String[] input) {
            LOGGER.info("Start application");
            Server server = null;
            try {
                server = new Server(8887);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            server.start();
        }
    }