import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //crear el objeto o instanciarlo es lo mismo.
        Spartan jefeMaestro = new Spartan();
        Spartan reach = new Spartan();

        // Asignamos los atributos a los objetos.
        jefeMaestro.nombre = "John 117 ";
        jefeMaestro.salud = 100;
        jefeMaestro.escudo = 90;
        jefeMaestro.armaPrincipal = "Rifle de asalto ";

        // usar los Métodos

        jefeMaestro.mostrarInfo();
        jefeMaestro.atacar("Elite ");
        jefeMaestro.RecargarArma(65);
        jefeMaestro.correr(true);

        //Nueva declaración
        reach.nombre = "Jorge ";
        reach.salud = 0;
        reach.escudo = 0;
        reach.armaPrincipal = "Espada ";

        reach.mostrarInfo();
        reach.atacar("Ataco a Chavo ");
        reach.RecargarArma(2);
        reach.correr(false);

    }
}// llave de la clase
