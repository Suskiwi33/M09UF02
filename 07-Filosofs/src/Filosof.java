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


    public void menjar() throws InterruptedException{
        while(true){

            if(!esquerra.getUs()){
                esquerra.setUs(true);
                System.out.println(nom + " agafa la forquilla esquerra "+ esquerra.getNum());
                if(!dreta.getUs()){
                    
                    dreta.setUs(true);
                    System.out.println(nom + " agafa forquilla dreta "+ dreta.getNum());
                    System.out.println(nom + " menja.");
                    Thread.sleep(rnd.nextInt(2000-1000));
                    gana = 0;
                    esquerra.setUs(false);
                    dreta.setUs(false);
                    System.out.println(nom + " Ha acabat de menjar.");
                    break;

                }else{
                    esquerra.setUs(false);
                    System.out.println(nom + " deixa forquilla esquerra("+ esquerra.getNum() + ") i espera (dreta ocupada).");
                    gana ++;
                    System.out.println(nom + " Gana: " + gana);
                }
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
