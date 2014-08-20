package i2p.blind;

public class Blind extends Thread{
    
    public static void main(String[] args){
       Initializer.initialize();
       Thread sl = new Thread(new StarterListener());
       Thread si = new Thread(new StarterInterface());
       sl.start();
       si.start();
       Speaker.main(args);
        
        
        

    }
    

private static class StarterListener implements Runnable{
        public void run() {
        Listener listener = new Listener();
        listener.initialize();     
        }
    
}
private static class StarterInterface implements Runnable{
        public void run() {
            UserInterface blindinterface = new UserInterface();
            blindinterface.basicInformation();
            blindinterface.sendMessage();
        }
    
}
}