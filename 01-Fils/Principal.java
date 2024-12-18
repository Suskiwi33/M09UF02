public class Principal {
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("\n--- Comportament 1 ---");
        Fil juan1 = new Fil("Juan", 150);
        Fil pepe1 = new Fil("Pepe", 150);
        juan1.start();
        pepe1.start();
        juan1.join();
        pepe1.join();
        System.out.println("Acaba el fil " + pepe1.getNameThread());
        System.out.println("Acaba el fil " + juan1.getNameThread());

       
        System.out.println("\n--- Comportament 2 ---");
        Fil juan2 = new Fil("Juan", 100); 
        Fil pepe2 = new Fil("Pepe", 100); 
        pepe2.start();
        pepe2.join();
        juan2.start();
        juan2.join();
        System.out.println("Acaba el fil " + pepe2.getNameThread());
        System.out.println("Acaba el fil " + juan2.getNameThread());

        
        System.out.println("\n--- Comportament 3 ---");
        
        Object lock = new Object();
        Thread juan3 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 9; i++) {
                    System.out.println("Juan " + i);
                    lock.notify();
                    try {
                        if (i < 9) lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread pepe3 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 9; i++) {
                    System.out.println("Pepe " + i);
                    lock.notify();
                    try {
                        if (i < 9) lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        juan3.start();
        pepe3.start();
        juan3.join();
        pepe3.join();
        System.out.println("Acaba el fil Pepe");
        System.out.println("Acaba el fil Juan");

        System.out.println("Acaba thread main");
    }
}
