 public class Main {
    public static void main(String[] args) {
        
        spartanII jefeMaestro = new spartanII("Jonh", 100, "Rifle de asalto", 0);
        spartanIII jefe = new spartanIII("David", 100, "Chicharra paralizadora", 80);
        spartanIV gosth = new spartanIV("Erik", 100, "Machete", 0 );

        System.out.println("------------------------------------------------------\n");

        jefeMaestro.mostrarInfo();
        jefeMaestro.usarmanejoAvanzado();
        jefeMaestro.atacar("pozol");
        jefeMaestro.recibirDano(50);
        jefeMaestro.recargarEscudo();

        System.out.println("\n------------------------------------------------------\n");

        jefe.mostrarInfo();
        jefe.camuflajeActivo();
        jefe.atacar("pozol");
        jefe.recibirDano(78);
        jefe.recargarEscudo();

        System.out.println("\n------------------------------------------------------\n");
        gosth.mostrarInfo();
        gosth.usarPropulsores();
        gosth.atacar("pozol");
        gosth.recibirDano(2);
        gosth.recargarEscudo();




    }
}