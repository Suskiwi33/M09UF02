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
        this.numFumades = 0;
        this.rnd = new Random();
    }

    public void fuma(){
        if(tabac != null && paper != null && llumi != null){
            tabac = null;
            paper = null;
            llumi = null;
            
            int temps = 500 + rnd.nextInt(1000);
            try {
                Thread.sleep(rnd.nextInt(temps));
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            numFumades ++;
            System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades.");
        }
    }

    public void compraTabac(){
        System.out.println("Fumador " + id + " comprant tabac.");
        Tabac tabac = null;
        synchronized (estanc) {
            while ((tabac = estanc.venTabac())==null) {
                try {
                    estanc.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                
            }
        }
        if (tabac!=null) this.tabac = tabac;
    }
    public void compraPaper(){
        System.out.println("Fumador " + id + " comprant paper.");
        Paper paper = null;
        synchronized (estanc) {
            while ((paper = estanc.venPaper())==null) {
                try {
                    estanc.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                
            }
        }
        if (paper!=null) this.paper = paper;
    }
    public void compraLlumi(){
        System.out.println("Fumador " + id + " comprant llumins.");
        Llumi llumi = null;
        synchronized (estanc) {
            while ((llumi = estanc.venLlumi())==null) {
                try {
                    estanc.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                
            }
        }
        if (llumi!=null) this.llumi = llumi;
    }

    @Override
    public void run(){
        while (numFumades<3) {
            compraTabac();
            compraPaper();
            compraLlumi();
            fuma();
        }
    }

}
