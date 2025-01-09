import java.util.Random;

public class DormAleatori extends Thread {

    private final long tempsCreacio;

    public DormAleatori(String name) {
        super(name); 
        this.tempsCreacio = System.currentTimeMillis();
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int sleepTime = random.nextInt(1000);
            long Time = System.currentTimeMillis() - tempsCreacio;

            System.out.printf("%s(%d) a dormir %dms total %dms\n", getName(), i, sleepTime, Time);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.err.printf("%s error.\n", getName());
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        try {
            joan.join();
            pep.join();
        } catch (InterruptedException e) {
            System.err.println("El fil principal ha parat.");
        }

        System.out.println("-- Fi de main -----------");
    }
}