import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        password password = new password();

        String inputLength = JOptionPane.showInputDialog("Ingrese la longitud de la contraseña (por default 8):");
        if (inputLength == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return;
        }

        int length;
        if (inputLength.isEmpty()) {
            length = 8;
        } else {
            try {
                length = Integer.parseInt(inputLength);
                if (length <= 0) {
                    JOptionPane.showMessageDialog(null, "La longitud debe ser mayor a 0. Se usará la longitud por defecto (8).");
                    length = 8;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Se usará la longitud por defecto (8).");
                length = 8;
            }
        }

        password.setLogitud(length);

        int includemayuscula = JOptionPane.showConfirmDialog(null, "¿Desea incluir mayúsculas?", "Opciones", JOptionPane.YES_NO_OPTION);
        password.setMayuscula(includemayuscula == JOptionPane.YES_OPTION);

        int includeEspeciales = JOptionPane.showConfirmDialog(null, "¿Desea incluir caracteres especiales?", "Opciones", JOptionPane.YES_NO_OPTION);
        password.setEspecial(includeEspeciales == JOptionPane.YES_OPTION);

        String generatedPassword = password.generarPassword();

        String strength = password.comprobarFuerza(generatedPassword);

        String message = "Contraseña generada: " + generatedPassword + "\nFortaleza: " + strength;
        JOptionPane.showMessageDialog(null, message);
    }
}
