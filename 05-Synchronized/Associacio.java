public class Associacio {
    
    private int numSocis = 1000;
    private Soci[] socis = new Soci[numSocis];

    public Associacio() {
        for (int i = 0; i < socis.length; i++) {
            socis[i] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis(){
        for (Soci soci : socis) {
            soci.start();
        }
    }

    public void esperaPeriodeSocis(){
        for (Thread fil : socis) {
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
