import java.util.Random;

public class Motor extends Thread{
    private String nom;
    private int potencia = 0;

    private String accio = "";
    private int objectiu;
    private int actual = 0;

    public Motor(String nom, int p){
        this.nom = nom;
        this.potencia = p;
    }

    public void setPotencia(int p){
        this.potencia = p;
    }
    public void setObjectiu(int o){
        this.objectiu = o;
    }
    public void setAccio(String a){
        this.accio = a;
    }

    public String getNom(){return this.nom;}
    public String getAccio(){return this.accio;}
    public int getObjectiu(){return this.objectiu;}
    public int getActual(){return this.actual;}

    @Override
    public void run() {
        Random random = new Random();
        

        while(objectiu!=0 && actual!=0){

            int sleepTime = random.nextInt(1000-2000);
            if(objectiu<actual){
                setAccio("Decre.");
            }
            if(objectiu>actual){
                setAccio("Incre.");
            }

            System.out.printf("%s: %s Objectiu: %d Actual: %d\n", getNom(), getAccio(), getObjectiu(), getActual());

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.err.printf("%s error.\n", getNom());
            }
        }


    }
}
