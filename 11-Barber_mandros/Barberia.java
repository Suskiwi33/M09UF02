import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Barberia extends Thread{

    public static Barberia barberia;
    
    private Queue<Client> cua;
    private int maxCadires;
    private int numCua;
    private Random rnd;
    public final Object condBarber = new Object();


    public Barberia(int numCad){
        this.maxCadires = numCad;
        this.cua = new LinkedList<Client>();
        this.numCua=1;
        this.rnd = new Random();
        
    }

    
    public Client seguentClient() {
        return cua.poll();
    }

    public void entrarClient(Client client) {
        if (cua.size() < maxCadires) { 
            cua.add(client);
            System.out.println("Client " + client.getNom() + " en espera");
    
            synchronized (condBarber) {
                condBarber.notifyAll(); 
            }
        } else {
            System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
        }
    }
    


    @Override
    public void run() {
        
        int id = 1;
        for(int j=0; j<2; j++) {
            for(int i=0; i<10; i++) {
                entrarClient(new Client(id));
                try { Thread.sleep(500); }
                catch (InterruptedException e) {}

                id++;
            }
            
            try { Thread.sleep(10000); }
            catch (InterruptedException e) {}
        }

    }

    public static void main(String[] args) {

        barberia = new Barberia(3);
        Barber barber = new Barber("XD");

        barber.start();
        barberia.start();

    }

}
