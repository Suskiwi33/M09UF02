import java.util.Random;

public class Filosof extends Thread {
    private Forquilla dreta;
    private Forquilla esquerra;
    private int numComencal;
    private int gana;
    private String nom;
    private Random rnd;

    public Filosof(String nom, Forquilla esquerra2, Forquilla dreta2, int numComencal){
        this.nom = nom;
        this.esquerra = esquerra2;
        this.dreta = dreta2;
        this.numComencal = numComencal;
    }

    public void agafarForquilles() throws InterruptedException{
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    public void agafarForquillaEsquerra() throws InterruptedException {
        if(esquerra.getNumPropietari() == -1){
            esquerra.setNumPropietari(numComencal);
            System.out.println(nom + " agafa forquilla esquerra "+ esquerra.getNum());
        }else{
            esquerra.wait();
        }
    }

    public void agafarForquillaDreta() throws InterruptedException{

        if(esquerra.getNumPropietari()== numComencal){

            if(dreta.getNumPropietari() == -1){
                dreta.setNumPropietari(numComencal);
                System.out.println(nom + " agafa forquilla dreta "+ dreta.getNum());
            }else{
                deixarForquilles();
                System.out.println(nom + " deixa forquilla esquerra("+ esquerra.getNum() + ") i espera (dreta ocupada).");
                gana ++;
                System.out.println(nom + " Gana: " + gana);
                dreta.wait();
            }
        }else{
            dreta.wait();
        }

        
    }

    

    public void deixarForquilles(){
        dreta.setForquillaLliure();
        esquerra.setForquillaLliure();
        dreta.notifyAll();
        esquerra.notifyAll();
    }


    public void menjar() throws InterruptedException{
        while(true){

            agafarForquilles();
            if(dreta.getNumPropietari() != -1 && esquerra.getNumPropietari() != -1){
                System.out.println(nom + " menja.");
                Thread.sleep(rnd.nextInt(2000-1000));
                gana = 0;
                deixarForquilles();
                System.out.println(nom + " Ha acabat de menjar.");
                break;
            }else{
                gana++;
                System.out.println(nom + " Gana: " + gana);
            }
            Thread.sleep(rnd.nextInt(1000-500));

        }
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

        rnd = new Random();
        while(true){

            try{

                menjar();
                pensar();


            } catch (InterruptedException e) {
                System.out.println(nom + " ha sigut interrumput.");
                break;
            }
        }
    }
}
