import java.util.Scanner;

public class Ejer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");
        int num = sc.nextInt();

        int par, impar, rs;

        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                par = i;
            }
            else {
                impar = i;
            }
        }

        if (num % 2 == 0) {
            par = num / 2;
            System.out.println(par);
        } else if (num % 3 == 0) {
            impar = (num * 3) + 1;
            System.out.println(impar);
        }
    }
}
