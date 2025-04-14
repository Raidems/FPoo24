import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        num num = new num();

        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "Ingresa una opción:\n" +
                            "1.- Número a Romano\n" +
                            "2.- Romano a Número\n" +
                            "3.- Salir");

            switch (opcion) {
                case "1":
                    String entradaArabigo = JOptionPane.showInputDialog("Ingresa un número (1-50):");
                    num.convertirArabigoARomano(entradaArabigo);
                    break;

                case "2":
                    String entradaRomano = JOptionPane.showInputDialog("Ingresa un número romano (I - L):");
                    num.convertirRomanoAArabigo(entradaRomano);
                    break;

                case "3":
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
}
