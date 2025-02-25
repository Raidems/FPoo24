import java.util.Random;

public class password {

    //Creación del constructor
    public password() {
        this.logitud = 8;
        this.mayuscula = false;
        this.especial = false;
    }

    private int logitud = 8;
    private boolean mayuscula;
    private boolean especial;

    public String generarPassword() {
        String letras = "abcdefghijklmnopqrstuvwxyz";
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Especiales = "!@#$%^&*()-_=+<>?";
        String numeros = "0123456789";

        String charPool = letras + numeros;
        if (mayuscula) charPool += mayusculas;
        if (especial) charPool += Especiales;

        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < logitud; i++) {
            password.append(charPool.charAt(rand.nextInt(charPool.length())));
        }
        return password.toString();
    }

    public String comprobarFuerza(String password) {
        boolean hasmayusculas = password.matches(".*[A-Z].*");
        boolean hasespeciales = password.matches(".*[!@#$%^&*()\\-_=+<>?].*");
        boolean hasnumeros = password.matches(".*[0-9].*");

        if (password.length() >= 12 && hasmayusculas && hasespeciales && hasnumeros) {
            return "Fuerte";
        } else if (password.length() >= 8 && ((hasmayusculas && hasnumeros) || (hasespeciales && hasnumeros))) {
            return "Media";
        } else {
            return "Débil";
        }
    }


    //ZONA DE LOS GET Y SET
    public int getLogitud() {
        return logitud;
    }

    public void setLogitud(int logitud) {
        this.logitud = logitud;
    }

    public boolean isMayuscula() {
        return mayuscula;
    }

    public void setMayuscula(boolean mayuscula) {
        this.mayuscula = mayuscula;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

}// clase
