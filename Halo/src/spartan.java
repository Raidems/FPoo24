public class spartan extends soldado {

    private int escudo;

    public spartan(String nombre, int salud, String arma, int escudo) {
        super(nombre, salud, arma);
        this.escudo = escudo;
    }

    public void recargarEscudo() {
        escudo = 100;
        System.out.println("El Spartan " + nombre + " recargo su escudo al maximo ");
    }

    @Override
    public void recibirDano(int dano) {
        if (salud > 0) {
            escudo -= dano;
            if (escudo < 0) {
                salud += escudo;
                escudo = 0;
            }
            System.out.println("El Spartan " + nombre + " Recibio daño, Escudo " + escudo + " Salud " + salud);

        }else{
            super.recibirDano(dano);
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Escudo: " + escudo);
    }

}// llave de la clase
