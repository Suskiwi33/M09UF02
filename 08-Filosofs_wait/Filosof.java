import java.util.Random;

public class Filosof extends Thread {
    private Forquilla dreta;
    private Forquilla esquerra;
    private int numComencal;
    private int gana;
    private String nom;
    private Random rnd;

    public Filosof(String nom, Forquilla esquerra2, Forquilla dreta2, int numComencal) {
        this.nom = nom;
        this.esquerra = esquerra2;
        this.dreta = dreta2;
        this.numComencal = numComencal;
        this.rnd = new Random(); 
    }

    public boolean agafarForquilles() throws InterruptedException {
        synchronized(this){
            while(!agafaForquillaEsquerra()){
                wait();
            }
        }
        if(agafarForquillaDreta()){
            return true;
        }

        System.out.println(nom + " deixa forquilla esquerra("+ esquerra.getNum() + ") i espera (dreta ocupada)");
        esquerra.setForquillaLliure();
        return false;

    }

    public boolean agafaForquillaEsquerra(){
        synchronized(esquerra){
            if(esquerra.getNumPropietari()==-1){
                esquerra.setNumPropietari(numComencal);
                System.out.println(nom + " agafa forquilla esquerra " + esquerra.getNum());
                return true;
            }
        }
        return false;
    }
    public boolean agafarForquillaDreta(){
        synchronized(dreta){
            if(dreta.getNumPropietari()==-1){
                dreta.setNumPropietari(numComencal);
                System.out.println(nom + " agafa forquilla dreta " + dreta.getNum());
                return true;
            }
        }
        return false;
    }

    public void deixarForquilles() {
        
        synchronized(esquerra){
            esquerra.setForquillaLliure();
        }
        synchronized(dreta){
            dreta.setForquillaLliure();
        }
        System.out.println(nom + " deixa les forquilles.");
    }

    public void menjar() throws InterruptedException {
        while (true) {
            if(agafarForquilles()){
            
                System.out.println(nom + " menja.");
                Thread.sleep(rnd.nextInt(2000 - 1000));
                gana = 0;
                deixarForquilles();
                System.out.println(nom + " ha acabat de menjar.");
                break;
                
            }else{
                deixarForquilles();
                gana ++;
                System.out.println(nom + " Gana: " + gana);

            }
            
            
        }
    }

    public void pensar() throws InterruptedException {
        int temps = 1000 + rnd.nextInt(1000);
        Thread.sleep(temps);
        System.out.println(nom + " pensa.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                menjar();
                pensar();
            } catch (InterruptedException e) {
                System.out.println(nom + " ha sigut interrumput.");
            } 
        }
    }
}

