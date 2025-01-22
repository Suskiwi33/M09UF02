import java.util.Random;

public class Treballador extends Thread{
    private int sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat = 0.0f;
    private Random rnd;
    private int trId;

    public Treballador(int id, int sou, int edat_inici, int edat_fi){
        this.trId = id;
        this.sou_anual_brut = sou;
        this. edat_inici_treball = edat_inici;
        this.edat_fi_treball = edat_fi;
        this.rnd = new Random();
    }

    public void cobra() {
        cobrat +=(sou_anual_brut / 12.0f);
    }

    public void pagaImpostos() {
        float impostos = (sou_anual_brut /12.0f) * 0.24f;
        cobrat -= impostos;
    }

    public int gettrId(){return this.trId;}
    public float getCobrat(){return this.cobrat;}
    public int getEdat(){return this.edat_actual;}

    @Override
    public void run(){
        
        edat_actual= edat_inici_treball;

        

            while(edat_actual < edat_fi_treball){
                try {
                    for(int i = 0; i<12; i++){
                        cobra();
                        Thread.sleep(rnd.nextInt(100));
                        pagaImpostos();
                        Thread.sleep(rnd.nextInt(100));
                        
                    }
                    edat_actual++;
                } catch (InterruptedException e) {
                    System.err.println("El fil ha sigut interrumput: " + e.getMessage());
                    break;
                }
            }
        

    }

}
