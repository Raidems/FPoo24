import java.util.Scanner;

public class Act4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la altura del triángulo: ");
        int altura = sc.nextInt();
        sc.close();

        int num = 1; // Primer número impar
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num += 2; // Siguiente número impar
            }
            System.out.println();
        }
    }
}
