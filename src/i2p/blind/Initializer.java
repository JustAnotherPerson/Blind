package i2p.blind;

import net.i2p.client.I2PSession;
import net.i2p.client.streaming.I2PServerSocket;
import net.i2p.client.streaming.I2PSocketManager;
import net.i2p.client.streaming.I2PSocketManagerFactory;

public class Initializer {
    public static String myDestination;
    public static I2PSocketManager manager;
    public static void initialize(){
         Initializer.manager = I2PSocketManagerFactory.createManager();
        I2PSession session = Initializer.manager.getSession();
        Initializer.myDestination = session.getMyDestination().toBase64();
    }
}
