import java.util.Random;

public class Motor extends Thread{
    
    private int id;

    private String accio = "";
    private int objectiu;
    private int actual = 0;

    public Motor(int id){
        
        this.id = id;
    }

    public void setPotencia(int p){
        this.objectiu = p;
    }
    public void setObjectiu(int o){
        this.objectiu = o;
    }
    public void setAccio(String a){
        this.accio = a;
    }

    
    public String getAccio(){return this.accio;}
    public int getObjectiu(){return this.objectiu;}
    public int getActual(){return this.actual;}

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                
                while (actual == objectiu) {
                    if (objectiu == 0) {
                        System.out.println("Motor " + id + ": Apagat. Objectiu: 0");
                        return;
                    }
                    Thread.sleep(100);
                }
                

                
                if (actual < objectiu) {
                    actual++;
                    System.out.println("Motor " + id + ": Incre. Objectiu: " + objectiu + " Actual: " + actual);
                } else {
                    actual--;
                    System.out.println("Motor " + id + ": Decre. Objectiu: " + objectiu + " Actual: " + actual);
                }

                
                Thread.sleep(1000 + random.nextInt(1000));

                if(actual==0){break;}
            }
            
        } catch (InterruptedException e) {
            System.out.println("Motor " + id + ": Interromput.");
        }
    }
}
