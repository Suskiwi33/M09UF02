import java.util.Random;

public class Barber extends Thread{
    private String nom;
    private Barberia barberia = Barberia.barberia;
    private Object condBarber = barberia.condBarber;
    private Random rnd;

    public Barber (String nom){
        this.nom = nom;
        this.rnd = new Random();
    }

    @Override
    public void run (){
        while(true){
            
            Client client = barberia.seguentClient();

            if (client!=null) {
                System.out.println("Li toca al client: " + client.getNom());

                long extra = rnd.nextInt(100);
                try {
                    Thread.sleep(900 + extra);
                } catch (InterruptedException e) {}

                client.tallarseElCabell();
            } else {
                System.out.println("Ningú en espera");
                System.out.println("Barber " + this.nom + " dormint.");

                synchronized(condBarber) {
                    try { condBarber.wait(); }
                    catch (InterruptedException e) {}
                }
            }
        }
    }
}
