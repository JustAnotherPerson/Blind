package i2p.blind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.i2p.data.DataFormatException;
import net.i2p.data.Destination;

public class UserInterface {
   // public static void main(String args[]){}
    public void basicInformation(){
        System.out.println("Ваш Destination (передайте его собеседнику):");
        System.out.println(Initializer.myDestination);
    }
    
    public static void recievedMessages(String line){
        System.out.print("[Собеседник]: ");
        System.out.println(line);
    }
    public void sendMessage() throws IOException{
        Speaker.br.readLine();
           if(Speaker.br != null){
                
            }
                
                //Speaker.bw.flush();
                if(Speaker.br != null){ 
                    System.out.print("[Вы]: " + Speaker.bw);
                   // Speaker.br.reset();
                
            
        }
    }
}
