import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Crear cuentas de ejemplo
        // Utilización del constructor.
        Cuenta cuenta1 = new Cuenta("12345", "Juan Perez", 30, 5000);
        Cuenta cuenta2 = new Cuenta("67890", "Maria Lopez", 25, 3000);

        // Menú de opciones
        while (true) {
            String opcion = JOptionPane.showInputDialog(null, "Seleccione una opción:\n" +
                    "1. Consultar saldo\n" +
                    "2. Ingresar efectivo\n" +
                    "3. Retirar efectivo\n" +
                    "4. Depositar a otra cuenta\n" +
                    "5. Salir");

            //SE LE AÑADIERON LOS GET Y LOS SET PORQUE SE PUSIERON EN PRIVADO Y HAY QUE CAMBIAR LOS ATRIBUTOS POR LOS GET Y SET 
            switch (opcion) {
                case "1": // Consultar saldo
                    String cuentaConsulta = JOptionPane.showInputDialog("Ingrese el número de cuenta para consultar saldo:");
                    if (cuentaConsulta.equals(cuenta1.getNoCuenta())) {
                        JOptionPane.showMessageDialog(null, cuenta1.consultarsaldo());
                    } else if (cuentaConsulta.equals(cuenta2.getNoCuenta())) {
                        JOptionPane.showMessageDialog(null, cuenta2.consultarsaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de cuenta no válido.");
                    }
                    break;

                case "2": // Ingresar efectivo
                    String cuentaDeposito = JOptionPane.showInputDialog("Ingrese el número de cuenta para depositar:");
                    if (cuentaDeposito.equals(cuenta1.getNoCuenta())) {
                        double montoIngreso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar:"));
                        cuenta1.ingresarEfectivo(montoIngreso);
                    } else if (cuentaDeposito.equals(cuenta2.getNoCuenta())) {
                        double montoIngreso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar:"));
                        cuenta2.ingresarEfectivo(montoIngreso);
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de cuenta no válido.");
                    }
                    break;

                case "3": // Retirar efectivo
                    String cuentaRetiro = JOptionPane.showInputDialog("Ingrese el número de cuenta para retirar:");
                    if (cuentaRetiro.equals(cuenta1.getNoCuenta())) {
                        double montoRetiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar:"));
                        cuenta1.retirarEfectivo(montoRetiro);
                    } else if (cuentaRetiro.equals(cuenta2.getNoCuenta())) {
                        double montoRetiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar:"));
                        cuenta2.retirarEfectivo(montoRetiro);
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de cuenta no válido.");
                    }
                    break;

                case "4": // Depositar a otra cuenta
                    String cuentaOrigen = JOptionPane.showInputDialog("Ingrese el número de cuenta origen:");
                    if (cuentaOrigen.equals(cuenta1.getNoCuenta())) {
                        double montoDeposito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar en otra cuenta:"));
                        cuenta1.depositar(cuenta2, montoDeposito);
                    } else if (cuentaOrigen.equals(cuenta2.getNoCuenta())) {
                        double montoDeposito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar en otra cuenta:"));
                        cuenta2.depositar(cuenta1, montoDeposito);
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de cuenta no válido.");
                    }
                    break;

                case "5": // Salir
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        }
    }
}
