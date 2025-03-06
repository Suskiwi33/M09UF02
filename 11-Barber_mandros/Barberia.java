import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Barberia extends Thread{
    
    private Queue cua;
    private int maxCadires;
    private int numCua;
    private Random rnd;
    private final Object lock1 = new Object();


    public Barberia(int numCad){
        this.maxCadires = numCad;
        this.cua = new LinkedList<Client>();
        this.numCua=1;
        this.rnd = new Random();
        for(int i = 1; i<21;i++){
            cua.add(new Client(i));
        }
    }

    public Client seguentClient(){
        if(numCua !=21){
            System.out.println("Li toca al client " + ((LinkedList<Client>) this.cua).get(numCua).getNom());
            return ((LinkedList<Client>) this.cua).get(numCua);

        }else{

            return null;
        }

    }

    public void entrarClient(Client client){
        if(maxCadires != 0){
            System.out.println("Client " + client.getNom() + " en espera.");
            maxCadires -=1;
        }else{
            System.out.println("No queden cadires, client " + client.getNom() + " se'n va.");
        }
    }

    @Override
    public void run() {
        
        for(int i = 0; i<10;i++){
            entrarClient(seguentClient());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            numCua++;
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        
        for(int y = 0; y<10;y++){
            entrarClient(seguentClient());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            numCua++;
        }

    }

    public static void main(String[] args) {

        Barberia bar = new Barberia(3);
        Barber barber = new Barber("XD");

        barber.start();
        bar.start();

    }

}
