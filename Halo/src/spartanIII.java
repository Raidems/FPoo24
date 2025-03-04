public class spartanIII extends spartan {

    public spartanIII(String nombre, int salud, String arma, int escudo) {
        super(nombre, salud, arma, 80);
    }
    public void camuflajeActivo(){
        System.out.println("El Spartan: " + nombre+ "cuenta con camuflaje para invisibilidad. ");
    }
}
