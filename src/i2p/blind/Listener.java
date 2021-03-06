package i2p.blind;


import static i2p.blind.Blind.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import net.i2p.I2PException;
import net.i2p.client.I2PSession;
import net.i2p.client.streaming.I2PServerSocket;
import net.i2p.client.streaming.I2PSocket;
import net.i2p.client.streaming.I2PSocketManager;
import net.i2p.client.streaming.I2PSocketManagerFactory;
import net.i2p.util.I2PThread;

public class Listener {

    public void initialize(){
       I2PThread t = new I2PThread(new ClientHandler(serverSocket), "clienthandler1", false);
        t.start();

    }   
     private static class ClientHandler implements Runnable {
        I2PSocket sock;
        public ClientHandler(I2PServerSocket socket) {
            this.socket = socket;
            
        }

        @Override
        public void run() {
            while(true){
                try {
                    sock = this.socket.accept();
                    if(sock != null) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    UserInterface.recievedMessages(br.readLine()); 
                    sock.close();
                    }
                } catch (I2PException ex) {
                    System.out.println("General I2P exception!");
                } catch (ConnectException ex) {
                    System.out.println("Error connecting!");
                } catch (SocketTimeoutException ex) {
                    System.out.println("Timeout!");
                } catch (IOException ex) {
                    System.out.println("General read/write-exception!");
                }

            }
        }
    private I2PServerSocket socket;
     }
}

