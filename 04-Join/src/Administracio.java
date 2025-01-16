import java.util.ArrayList;
import java.util.List;

public class Administracio {

    private int num_poblacio_activa = 50;
    private Treballador[]poblacio_activa;


    public Administracio() {
        poblacio_activa = new Treballador[num_poblacio_activa];
        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i] = new Treballador(i, 25000, 20, 65);
        }
    }

    public static void main(String[] args) {

        List<Thread> fils = new ArrayList<>();

        Administracio admin = new Administracio();
        

        for (Treballador treballador : admin.poblacio_activa) {
            Thread fil = new Thread(treballador);
            fils.add(fil);
            fil.start();
        }

        for (Thread fil : fils) {
            try {
                fil.join();
            } catch (InterruptedException e) {
                System.err.println("El fil ha estat interromput: " + e.getMessage());
            }
        }

        for (Treballador treballador : admin.poblacio_activa) {
            System.out.println("Ciutadà-" + treballador.gettrId() + " -> edat: " + treballador.getEdat() + " / total: " + treballador.getCobrat());
        }
    }
}
