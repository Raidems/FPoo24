import java.util.Scanner;

public class Act5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double numero1 = sc.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double numero2 = sc.nextDouble();

        System.out.print("Introduce el operador (+, -, *, /): ");
        char operador = sc.next().charAt(0);

        switch (operador) {
            case '+':
                System.out.println("El resultado es: " + (numero1 + numero2));
                break;
            case '-':
                System.out.println("El resultado es: " + (numero1 - numero2));
                break;
            case '*':
                System.out.println("El resultado es: " + (numero1 * numero2));
                break;
            case '/':
                if (numero2 != 0) {
                    System.out.println("El resultado es: " + (numero1 / numero2));
                } else {
                    System.out.println("Error: División entre cero.");
                }
                break;
            default:
                System.out.println("Operador no válido.");
        }
    }
}