import java.util.Scanner;

public class Act3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa un numero para mostrar la tabla de mutiplicar: ");
        int num = sc.nextInt();

        for (int i = num; i <= num; i++) {
            System.out.println("Tabla del " + i);
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
            System.out.println();
        }
    }
}