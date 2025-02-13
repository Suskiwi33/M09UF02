import java.util.ArrayList;
import java.util.List;

public class Taula {
    
    private List <Filosof> filosofs;
    private List <Forquilla> forquilles;

    public Taula(int numFilo){
        forquilles = new ArrayList<>();
        for (int i = 0; i < numFilo; i++) {
            forquilles.add(new Forquilla(i));
        }

        filosofs = new ArrayList<>();
        for (int i = 0; i < numFilo; i++) {
            Forquilla esquerra = forquilles.get(i);
            Forquilla dreta = forquilles.get((i + 1) % numFilo);
            filosofs.add(new Filosof("Filosof " + i, esquerra, dreta, i));
        }
    }

    public void showTaula() {
        for (Filosof filosof : filosofs) {
            System.out.println(filosof);
        }
    }

    public void cridaraTaula() {
        for (Filosof filosof : filosofs) {
            new Thread(filosof).start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridaraTaula();
    }
}
