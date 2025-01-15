import java.util.Scanner;

public class Coet {
    private final Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        if (p >= 0 && p <= 10) {
            System.out.println("Passant a potència " + p);
            for (Motor motor : motors) {
                motor.setPotencia(p);
            }
        } else {
            System.out.println("Error, potència no vàlida.");
        }
    }

    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public static void main(String[] args) {
        System.out.println("Potencia inicial?");
        Scanner scanner = new Scanner(System.in);

        int potenciaInicial;
        try {
            potenciaInicial = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada no vàlida. Introdueix un número enter.");
            scanner.close();
            return;
        }

        Coet coet = new Coet();
        coet.passaAPotencia(potenciaInicial);
        coet.arranca();
       

        while (true) {
            
            int pot;
            try {
                pot = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no vàlida. Introdueix un número enter.");
                scanner.next();
                continue;
            }
            coet.passaAPotencia(pot);
            if(pot==0){break;}
        }

        
        scanner.close();
    }
}

