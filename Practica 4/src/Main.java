import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numero = 0;
        System.out.println("Introduce un número entero: ");
        numero = sc.nextInt();

        if (numero % 2 == 0) {
            System.out.println("El numero: " + numero + " es par");
        }else{
            System.out.println("El numero: " + numero + " es impar" );
        }
    }
}

