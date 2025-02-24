public class Spartan {

    // Creación de constructor
    public Spartan(String nombre, int salud, int escudo, String armaPrincipal) {
        this.nombre = nombre;
        this.salud = salud;
        this.escudo = escudo;
        this.armaPrincipal = armaPrincipal;
    }

    //atributos
    private String nombre;
    private int salud;
    private int escudo;
    private String armaPrincipal;

    //métodos
    public void mostrarInfo(){
        System.out.println("------ Informacion del Spartan -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Salud: " + salud);
        System.out.println("Escudo: " + escudo);
        System.out.println("Arma Principal: " + armaPrincipal);
        System.out.println("-------------------------------");
    }

    public void atacar(String enemigo){
        System.out.println(nombre +"ataca a "+ enemigo +"con "+ armaPrincipal);
    }

    public void RecargarArma(int municiones){
        int restante = 10;
        int total = restante + municiones;
        System.out.println("El arma "+armaPrincipal+" tiene "+total+" balas");
    }

    public void correr(boolean status){
        if(status){
            System.out.println("El spartan "+nombre+" esta corriendo\n");
        }else{
            System.out.println("El spartan "+nombre+" se detuvo\n");
        }
    }

    private void consultaCostana(){
        System.out.println("Conversación Privada");
    }


    //Zona de Get & Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public String getArmaPrincipal() {
        return armaPrincipal;
    }

    public void setArmaPrincipal(String armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }


}// llave de la clase
