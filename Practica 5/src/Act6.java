import java.util.Scanner;

public class Act6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int saldo = 0;

        while (true) {
            System.out.print("Ingrese operación (D 100 o R 50), o deje en blanco para finalizar: ");
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) break;

            char tipo = linea.charAt(0);
            int cantidad = Integer.parseInt(linea.substring(2));

            if (tipo == 'D') {
                saldo += cantidad;
            } else if (tipo == 'R') {
                saldo -= cantidad;
            }
        }

        sc.close();
        System.out.println("Saldo final: " + saldo + " pesos");
    }
}