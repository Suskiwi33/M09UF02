public class Fil extends Thread {
    private String name;
    private int delay;

    public Fil(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(name + " " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Fil " + name + " error.");
            }
        }
    }

    public String getNameThread() {
        return name;
    }
}