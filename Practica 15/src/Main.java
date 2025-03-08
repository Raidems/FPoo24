import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opcion;
        Empleado empleado = null;

        while (true) {
            // Menú gráfico con JOptionPane
            String menu = "1. Agregar Empleado\n2. Listar Empleados\n3. Salir";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    // Pedir información para agregar un empleado
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado:"));
                    double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado:"));
                    String tipoEmpleado = JOptionPane.showInputDialog("Ingrese el tipo de empleado (Conductor/Administrativo):");

                    if (tipoEmpleado.equalsIgnoreCase("Conductor")) {
                        // Pedir información adicional para el conductor
                        String licencia = JOptionPane.showInputDialog("Ingrese el tipo de licencia del conductor:");
                        empleado = new Conductor(nombre, id, salario, licencia);
                    } else if (tipoEmpleado.equalsIgnoreCase("Administrativo")) {
                        // Pedir información adicional para el administrativo
                        String departamento = JOptionPane.showInputDialog("Ingrese el departamento del administrativo:");
                        empleado = new Administrativo(nombre, id, salario, departamento);
                    } else {
                        empleado = new Empleado(nombre, id, salario);
                    }
                    break;
                case 2:
                    // Listar la información del empleado
                    if (empleado != null) {
                        empleado.mostrarInfo();
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay empleados para mostrar.");
                    }
                    break;
                case 3:
                    // Salir del programa
                    JOptionPane.showMessageDialog(null, "¡Adiós!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}
