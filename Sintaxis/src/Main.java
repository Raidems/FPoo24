
//IMPORTACION.
/*import java.util.random.*;*/
/*import java.util.Scanner;*/

//Clase principal.
public class Main {

    //Metodo Main.
    public static void main(String[] args) {

        // 2 cadenas con java
        /*System.out.println("Hello, Erik!");
        String cadenas = "Erik"+"Narciso"+"Bernardino";

        System.out.println(cadenas);
        System.out.println(cadenas.substring(2,5));
        System.out.println(cadenas.substring(2));
        System.out.println(cadenas.substring(0,5));*/


        //3. Variables
        /*int x=5, x2;
        double y=1.25, y2;
        String z= "03", z1;

        //
        x2=Integer.parseInt(z);

        x2 = Integer.parseInt(z);
        z1 = String.valueOf(y);
        double asd= Double.valueOf(x);


        //Converción implicita

        int num=12;
        double numD = num;
        System.out.println("Convercion implicita"+numD);

        System.out.println(x2);
        System.out.println(z1);
        System.out.println(asd);

        // Creamos un objeto rnd de clase Random
        Random rnd = new Random();

        //Generamos numeros y los guardamos
        int numAleatorio= rnd.nextInt();
        double numDouble= rnd.nextDouble();

        System.out.println("Random number: "+numAleatorio);
        System.out.println("Random number: "+numDouble);*/

        /*4.
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce cualquier dato");
        String dato = sc.nextLine();

        System.out.println("Introduce un dato entero");
        int datoEntero = sc.nextInt();

        System.out.println("Introduce dato con decimales");
        double datoDecimales = sc.nextDouble();

        System.out.println("Cualquier dato"+dato);
        sc.nextLine();
        System.out.println("Dato Entero"+datoEntero);
        sc.nextLine();
        System.out.println("Dato Decimal"+datoDecimales);
*/


        // 5. Boolean, Operadore logicos y de comparación

        System.out.println(10 > 9); //True
        System.out.println(10 == 9); // False
        System.out.println(10 < 9); // False
        System.out.println(10 >= 9); // True
        System.out.println(10 <= 9); // False
        System.out.println(10 != 9); // True

        int x =3;
        System.out.println(x<5 && x>10); //Comparacion logica con and........ false
        System.out.println(x<5 || x>10); // comparacion logica con or....... true
        System.out.println(!(x<5 && x>10)); // comparacion logica con not........ true


    }
}
