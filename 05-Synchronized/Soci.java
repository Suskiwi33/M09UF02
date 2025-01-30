import java.util.Random;

public class Soci extends Thread{
    private Compte compte = Compte.getInstance();
    private float aportacio = 10f;
    private int esperaMax = 100;
    private Random random = new Random();
    private int maxAnys = 10;

    public Soci(){}

    public Compte getCompte(){return this.compte;}

    private void agregaSaldo(){
        compte.setSaldo(compte.getSaldo()+aportacio);
    }
    private void treuSaldo(){
        compte.setSaldo(compte.getSaldo()-aportacio);
    }

    @Override
    public void run() {
        
        for(int i = 0; i<maxAnys; i++){

            for(int y = 1; y<=12;y++){
                if(y%2==0){
                    compte.agregar(aportacio);;
                }else{
                    compte.treure(aportacio);
                }
                
                try {
                    Thread.sleep(random.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
