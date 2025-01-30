import java.util.Scanner;

public class Act7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de * en la base del árbol (debe ser impar): ");
        int base = sc.nextInt();
        sc.close();

        if (base % 2 == 0) {
            System.out.println("La base debe ser un número impar.");
            return;
        }

        int altura = (base + 1) / 2;
        int i = 1;

        while (i <= base) {
            int espacios = (base - i) / 2;
            int j = 0;

            while (j < espacios) {
                System.out.print(" ");
                j++;
            }

            j = 0;
            while (j < i) {
                System.out.print("*");
                j++;
            }

            System.out.println();
            i += 2;
        }

        int espaciosBase = (base - 1) / 2;
        for (int j = 0; j < espaciosBase; j++) {
            System.out.print(" ");
        }
        System.out.println("*");
    }
}