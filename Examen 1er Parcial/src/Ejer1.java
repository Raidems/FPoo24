import java.util.Scanner;

public class Ejer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero entre 200 y 400: ");
        int num = sc.nextInt();

        if (num >= 200 && num <= 400) {
            for (int i = num; i <= 400; i++) {
                if (i % 2 == 0) {
                    System.out.print(i+ " ");
                }
            }
        }

    }
}