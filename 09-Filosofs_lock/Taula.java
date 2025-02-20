import java.util.ArrayList;
import java.util.List;

public class Taula {
    
    private Filosof[] comencals;
    private Forquilla[] forquilles;

    public Taula(int numFilo){
        forquilles = new Forquilla[numFilo];
        for (int i = 0; i < numFilo; i++) {
           forquilles[i] = new Forquilla(i);
        }

        comencals = new Filosof[numFilo];
        for (int i = 0; i < numFilo; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i+1)% numFilo];
            comencals[i]= new Filosof("Filosof " + i, esquerra, dreta, i);
            
        }
    }

    public void showTaula() {
        for (Filosof filosof : comencals) {
            System.out.println(filosof);
        }
    }

    public void cridarTaula() {
        for (Filosof filosof : comencals) {
            filosof.start();
        }
    }

    
    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarTaula();
    }
}
