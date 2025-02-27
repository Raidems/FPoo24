import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        vehiculo vehiculo = null;
        conductores conductor = null;
        envios envio = null;
        entregas entrega = null;

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Menú:\n1. Crear vehículo\n2. Crear conductor\n3. Asignar conductor a vehículo\n4. Crear envío\n5. Crear entrega\n6. Ver datos del vehículo\n7. Ver datos del conductor\n8. Ver datos del envío\n9. Actualizar estado de entrega\n10. Salir"));
            switch (opcion) {
                case 1:
                    vehiculo = new vehiculo();
                    break;
                case 2:
                    conductor = new conductores();
                    break;
                case 3:
                    if (vehiculo != null && conductor != null) {
                        vehiculo.asignarConductor(conductor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe crear primero un vehículo y un conductor.");
                    }
                    break;
                case 4:
                    envio = envios.crearEnvio();
                    break;
                case 5:
                    if (envio != null) {
                        entrega = new entregas(JOptionPane.showInputDialog("Ingrese el número de guía de la entrega:"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe crear un envío primero.");
                    }
                    break;
                case 6:
                    if (vehiculo != null) {
                        JOptionPane.showMessageDialog(null, "Placa: " + vehiculo.getPlaca() + "\nModelo: " + vehiculo.getModelo() + "\nCapacidad de carga: " + vehiculo.getCapacidadCarga() + " kg");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay vehículo registrado.");
                    }
                    break;
                case 7:
                    if (conductor != null) {
                        JOptionPane.showMessageDialog(null, "Nombre: " + conductor.getNombre() + "\nIdentificación: " + conductor.getIdentificacion() + "\nLicencia: " + conductor.getLicencia());
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay conductor registrado.");
                    }
                    break;
                case 8:
                    if (envio != null) {
                        JOptionPane.showMessageDialog(null, "Código Envío: " + envio.getCodigoEnvio() + "\nDestino: " + envio.getDestino() + "\nPeso: " + envio.getPeso() + " kg");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay envío registrado.");
                    }
                    break;
                case 9:
                    if (entrega != null) {
                        entrega.actualizarEstado();
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay entrega registrada.");
                    }
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 10);
    }
}
