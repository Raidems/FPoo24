import java.util.Scanner;

public class act1 {
    public static void main(String[] args) {
        String contrasenaGuardada = "Erik";
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu contraseña: ");
        String contrasenaUsuario = sc.nextLine();

        if (contrasenaGuardada.equalsIgnoreCase(contrasenaUsuario)) {
            System.out.println("La contraseña es correcta.");
        } else {
            System.out.println("La contraseña es incorrecta.");
        }
    }
}