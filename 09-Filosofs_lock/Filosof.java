import java.util.Random;

public class Filosof extends Thread{
    private Long iniciGana;
    private Long fiGana;
    private int gana;
    private Forquilla dreta;
    private Forquilla esquerra;
    private int numComencal;
    private String nom;
    private Random rnd;

    public Filosof(String nom, Forquilla esquerra2, Forquilla dreta2, int numComencal) {
        this.nom = nom;
        this.esquerra = esquerra2;
        this.dreta = dreta2;
        this.numComencal = numComencal;
        this.rnd = new Random(); 
    }


    public void menjar() throws InterruptedException {
        agafarForquilles();
        fiGana = System.currentTimeMillis();
        
        System.out.println(nom + " menja amb gana " + calcularGana());
        int temps = 1000 + rnd.nextInt(1000);
        Thread.sleep(rnd.nextInt(temps));

        deixarForquilles();
        System.out.println(nom + " ha acabat de menjar ");

    }


    public void agafaForquillaEsquerra(){
        esquerra.agafar();
        
    }
    public void agafarForquillaDreta(){
        dreta.agafar();
        
    }


    public void pensar() throws InterruptedException {
        int temps = 1000 + rnd.nextInt(1000);
        Thread.sleep(temps);
        System.out.println(nom + " pensa.");
        resetGana();
    }

    public void deixarForquilles(){
        dreta.deixar();
        esquerra.deixar();
        System.out.println(nom + " deixa les forquilles.");
    }

    public void agafarForquilles(){
        agafaForquillaEsquerra();
        agafarForquillaDreta();
        System.out.println(nom + " agafa les forquilles.");
    }

    public int calcularGana(){
        this.gana = (int)(this.fiGana - this.iniciGana) / 1000;
        return this.gana;
    }

    public void resetGana(){
        this.iniciGana = System.currentTimeMillis();
        this.gana = 0;
    }

    @Override
    public void run() {
        resetGana();
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
