package i2p.blind;

import static i2p.blind.Blind.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.i2p.I2PException;
import net.i2p.client.streaming.I2PSocket;
import net.i2p.data.DataFormatException;
import net.i2p.data.Destination;
import net.i2p.util.I2PThread;

public class Speaker {
    
    private static BufferedReader br;
    private static BufferedWriter bw;

    public void create(){
        
        I2PThread t = new I2PThread(new Tongue(), "tongue1", false);
        t.start();
    }
    private static class Tongue implements Runnable{
        @Override
        public void run(){
            
        }
    }
    
    private void connect(){
        
        
        
        
    }
    
    private Destination catchDestination(){
        System.out.println("Enter a destination of your recipient: ");
        try {
            try {
                destination = new Destination(br.readLine());
            } catch (DataFormatException ex) {
                Logger.getLogger(Speaker.class.getName()).log(Level.SEVERE, "Error. Isn't a destination!", ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Speaker.class.getName()).log(Level.SEVERE, "Error. There isn't a input from keyboard.", ex);
        }
        return destination;
    }
    
    
    public static void main(String[] args) {
        //System.out.println("Please enter a Destination:");
       // br = new BufferedReader(new InputStreamReader(System.in));
        
            
        I2PSocket socket;
        try {
            socket = Initializer.manager.connect(destination);
        } catch (I2PException ex) {
            System.out.println("General I2P exception occurred!");
            return;
        } catch (ConnectException ex) {
            System.out.println("Failed to connect!");
            return;
        } catch (NoRouteToHostException ex) {
            System.out.println("Couldn't find host!");
            return;
        } catch (InterruptedIOException ex) {
            System.out.println("Sending/receiving was interrupted!");
            return;
        }
        try {
            //Write to server
            //bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //bw.write("Hello I2P!\n");
            //Flush to make sure everything got sent
            //bw.flush();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error occurred while sending/receiving!");
        }
    }

}

