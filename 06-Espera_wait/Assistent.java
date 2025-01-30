import java.util.Random;

public class Assistent extends Thread {
    private Esdeveniment esdeveniment;
    private String nom;
    private Random rnd = new Random();

    public Assistent(Esdeveniment e, String nom) {
        super(nom);
        this.esdeveniment = e;
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int accio = rnd.nextInt(2);

                synchronized (esdeveniment) {
                    if (accio == 0) {
                        if(esdeveniment.ferReserva(this)){
                            esdeveniment.notifyAll();
                        }else{
                            esdeveniment.wait();
                        }
                         
                    } else {
                        if(esdeveniment.cancelaReserva(this)){
                            esdeveniment.notifyAll();
                        }else{
                            esdeveniment.wait();
                        }
                         
                    }
                }

                Thread.sleep(rnd.nextInt(1000));

            } catch (InterruptedException e) {
                System.out.println(nom + " ha sigut interrumput.");
                break;
            }
        }
    }
}


