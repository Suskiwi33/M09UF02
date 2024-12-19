public class Futbolista extends Thread {
    
    private int ngols; 
    private int ntirades;
    

    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    
    public Futbolista(String nom) {
        super(nom); 
        this.ngols = 0;
        this.ntirades = 0;
    }

    
    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++; 
            if (Math.random() < PROBABILITAT) {
                ngols++; 
            }
        }
    }

    
    public int getNgols() {
        return ngols;
    }

    public int getNTirades() {
        return ntirades;
    }
    public static void main(String[] args) {
        
        String[] nomJugadors = {"Piqué", "Vinicius","Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];

        
        System.out.println("Inici dels xuts --------------------");
        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(nomJugadors[i]);
            jugadors[i].start();
        }

        
        for (int i = 0; i < NUM_JUGADORS; i++) {
            try {
                jugadors[i].join();
            } catch (InterruptedException e) {
                System.err.println("Error esperant al fil: " + e.getMessage());
            }
        }
        System.out.println("Fi dels xuts -----------------------");

        
        System.out.println("--- Estadístiques ------");
        for (Futbolista jugador : jugadors) {
            System.out.printf("%s -> %d gols%n", jugador.getName(), jugador.getNgols());
        }
    }
}
