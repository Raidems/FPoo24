import javax.swing.*;

public class Main {
    public static void main(String[] args){

        vehiculo vehiculo = new vehiculo("ABCDE", "RAM", 100);
        conductores conductores = new conductores();

        //Menú de opciones
        while (true){
            String opcion = JOptionPane.showInputDialog(null, "Seleccione una opción:\n " +
                    "1.- Registrar Vehiculo\n"+
                    "2.- Registrar Conductor\n"+
                    "3.- Registrar envio\n"+
                    "4.- Registrar entrega\n"+
                    "5.- Mostrar Información\n"+
                    "6.- Salir");

            switch (opcion){
                case "1":
                    String Vehiculo = JOptionPane.showInputDialog(null, "Ingrese la placa: ");
                    vehiculo.setPlaca(Vehiculo);
                    String modelo = JOptionPane.showInputDialog(null, "Ingrese la modelo: ");
                    vehiculo.setModelo(modelo);
                    String carga = JOptionPane.showInputDialog(null, "Ingrese la carga (kg): ");
                    vehiculo.setCapacidadCarga(Integer.parseInt(carga));
                    break;

                case "2":
                    String conductor = JOptionPane.showInputDialog(null, "Ingrese el Nombre Completo: ");
                    conductores.setNombre(conductor);
                    String identificador = JOptionPane.showInputDialog(null, "Ingrese alguna identificación: ");
                    conductores.setIdentificación(identificador);
                    String licencia = JOptionPane.showInputDialog(null, "Ingrese una licencia: ");
                    conductores.setLicencia(licencia);

                    break;

                case "3":
                    break;

                case "4":
                    break;

                case "5":
                    JOptionPane.showMessageDialog(null,"Vehiculo registrado:\n"
                            + "Placa: "+vehiculo.getPlaca()
                            + "\nModelo: " + vehiculo.getModelo()
                            + "\nCapacidad de Carga: " + vehiculo.getCapacidadCarga()

                            + "------ CONDUCTOR REGISTRADO -------\n");
                            ++ "Conductor: "+conductores.getNombre()
                            + "\nIdentificación: "+ conductores.getIdentificación()
                            + "\nLicencia: "+ conductores.getLicencia();

                    break;

                case "6"://Salir
                    JOptionPane.showMessageDialog(null, "Gracias por usar el Sistema... ");
                    System.exit(0);
                    break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida. Por favor intente de nuevo ");

            }

        }

    }
}