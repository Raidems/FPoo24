import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero entero positivo: ");
        int num = sc.nextInt();

        boolean primero = true;
        for (int i = 1; i <= num; i +=2) {
            if (!primero){
                System.out.print(", ");
            }
            System.out.print(i);
            primero = false;
        }
        System.out.println();
    }
}