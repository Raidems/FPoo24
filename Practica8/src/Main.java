import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //crear el objeto o instanciarlo es lo mismo.
        Spartan jefeMaestro = new Spartan("John 117 ", 100, 90, "Rifle de asalto ");
        Spartan reach = new Spartan("Jorge ", 0, 0, "Espada ");

        // usar los Métodos
        jefeMaestro.mostrarInfo();
        jefeMaestro.atacar("Elite ");
        jefeMaestro.RecargarArma(65);
        jefeMaestro.correr(true);

        //Usar los métodos
        reach.mostrarInfo();
        reach.atacar("Chavo ");
        reach.RecargarArma(2);
        reach.correr(false);

        // ejemplo de get & set cpn el objeto JefeMaestro
        jefeMaestro.setNombre("JuantinoPro03");
        jefeMaestro.mostrarInfo();
        System.out.println(jefeMaestro.getNombre());

    }
}// llave de la clase
