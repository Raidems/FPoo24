import java.util.Scanner;
public class Act4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una cadena: ");
        String cadena = sc.nextLine();

        String cadenaLimpia = cadena.replaceAll("\\s+", "").toLowerCase();
        String cadenaInvertida = new StringBuilder(cadenaLimpia).reverse().toString();

        if (cadenaLimpia.equals(cadenaInvertida)) {
            System.out.println("La cadena es un palíndromo.");
        } else {
            System.out.println("La cadena no es un palíndromo.");
        }
    }
}


