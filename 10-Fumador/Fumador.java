import java.util.Random;

public class Fumador extends Thread{
    public Estanc estanc;
    public int id;
    public Tabac tabac;
    public Llumi llumi;
    public Paper paper;
    public int numFumades;
    public Random rnd;

    public Fumador (Estanc e, int i){
        this.estanc = e;
        this.id = i;
        this.rnd = new Random();
    }

    public void fuma(){
        if(tabac != null && paper != null && llumi != null){
            tabac = null;
            paper = null;
            llumi = null;
            System.out.println("Fuma");
            int temps = 500 + rnd.nextInt(1000);
            try {
                Thread.sleep(rnd.nextInt(temps));
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }
    }

    public void compraTabac(){estanc.venTabac();}
    public void compraPaper(){estanc.venPaper();}
    public void compraLlumi(){estanc.venLlumi();}

    @Override
    public void run(){

    }

}
