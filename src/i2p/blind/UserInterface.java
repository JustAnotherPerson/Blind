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
    public static Destination askDestination(){
        System.out.println("Введите Destination собеседника:");
        Speaker.br = new BufferedReader(new InputStreamReader(System.in));
        String destinationString = null;
        try {
            destinationString = Speaker.br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        Destination destination = null;
        try {
            destination = new Destination(destinationString);
        } catch (DataFormatException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return destination;
    }
    public static void recievedMessages(String line){
        System.out.print("[Собеседник]: ");
        System.out.println(line);
    }
    public void sendMessage(){
        while(true){
            try {
                Speaker.br.readLine();
                //Speaker.bw.flush();
                if(Speaker.br != null){ 
                    System.out.print("[Вы]: " + Speaker.bw);
                   // Speaker.br.reset();
                }
            } catch (IOException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
