import java.util.ArrayList;
import java.util.List;

public class Associacio {
    
    private int numSocis = 1000;
    private Soci[] socis = new Soci[numSocis];
    private List<Thread> fils = new ArrayList<>();

    public Associacio() {
        for (int i = 0; i < socis.length; i++) {
            socis[i] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis(){
        for (Soci soci : socis) {
            Thread fil = new Thread(soci);
            fils.add(fil);
            fil.start();
        }
    }

    public void esperaPeriodeSocis(){
        for (Thread fil : fils) {
            try {
                fil.join();
            } catch (InterruptedException e) {
                System.err.println("El fil ha estat interromput: " + e.getMessage());
            }
        }
    }

    public void mostraBalancComptes(){
        for(Soci soci : socis){
            System.out.println("Saldo: " + soci.getCompte().getSaldo());
            break;
        }
    }

    public static void main(String[] args) {
        Associacio aso = new Associacio();
        aso.iniciaCompteTempsSocis();
        aso.esperaPeriodeSocis();
        aso.mostraBalancComptes();

    }

}
