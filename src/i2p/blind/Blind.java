package i2p.blind;

import net.i2p.client.I2PSession;
import net.i2p.client.streaming.I2PServerSocket;
import net.i2p.client.streaming.I2PSocketManager;
import net.i2p.client.streaming.I2PSocketManagerFactory;
import net.i2p.data.Destination;

public class Blind {
    
public static String myDestination;
public static String recipientDestination;
public static Destination destination;


public static I2PSocketManager socketManager1;
public static I2PSocketManager socketManager2;

public static I2PServerSocket serverSocket;

public static I2PSession session;



  public static void main(String[] args) {
    
    Blind blind = new Blind();
    blind.initialize();

  }  

    
  void initialize(){

    socketManager1 = I2PSocketManagerFactory.createManager();
    socketManager2 = I2PSocketManagerFactory.createManager();
    session = socketManager1.getSession();
    serverSocket = socketManager2.getServerSocket();

    myDestination = session.getMyDestination().toBase64();
    
    
  }





}