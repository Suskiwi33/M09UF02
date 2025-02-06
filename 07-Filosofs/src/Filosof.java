import java.util.Random;

public class Filosof extends Thread {
    private Forquilla dreta;
    private Forquilla esquerra;
    private int gana;
    private String nom;
    private Random rnd;

    public Filosof(String nom, Forquilla esquerra2, Forquilla dreta2){
        this.nom = nom;
        this.esquerra = esquerra2;
        this.dreta = dreta2;
    }


    public void menjar(){
        try {
            int temps = 1000 + rnd.nextInt(1000);
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        System.out.println(nom + " menja.");
    }


    public void pensar(){
        try {
            int temps = 1000 + rnd.nextInt(1000);
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        System.out.println(nom + " pensa.");
    }


    
    @Override
    public void run() {
        while(true){

            try{

                


            } catch (InterruptedException e) {
                System.out.println(nom + " ha sigut interrumput.");
                break;
            }
        }
    }
}
