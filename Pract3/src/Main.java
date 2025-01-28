import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1.- SUELDO DE HORAS TRABAJADAS

        /*System.out.println("Cuántas horas trabajadas: ");
        double horas = sc.nextDouble();
        System.out.println("Costo de horas: ");
        double costoHoras = sc.nextDouble();

        double horasTrabajadas = horas * costoHoras;

        System.out.println("Tu salario es: "+ horasTrabajadas);*/

        //2.- NOMBRE COMPLETO DEL USUARIO IMPRESO 3 VECES

       /*System.out.println("Ingresa tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa tu apellido Paterno: ");
        String apellidoP = sc.nextLine();
        System.out.println("Ingresa tu apellido Materno: ");
        String apellidoM = sc.nextLine();

        System.out.println("Tu nombre completo es: " + nombre + " " + apellidoP + " " + apellidoM);*/

        //3.- SOLICITAR UN NÚMERO ENTERO

        /*System.out.println("Introduce un número Entero: ");
        int X = sc.nextInt();
        int suma =0;
        StringBuilder proceso = new StringBuilder();

        for (int i = 0; i <= X; i++) {
            suma+=i;
            if(i == 0){
                proceso.append(i);
            }else{
                proceso.append(" + ").append(i);
            }
        }
        proceso.append(" = ").append(suma);
        System.out.println(proceso);*/

        //4.- NOMBRE DE USUARIO CON n LETRAS

       /* System.out.println("Ingresa tu nombre: ");
        String N = sc.nextLine();

        int n = N.length();
        System.out.println("Tu nombre: "+ N + ", tiene: "+ n +" caracteres: ");*/

        //5.- JUGETERÍA

       /* final int PESO_PAYASO = 112;
        final int PESO_MUNECA = 75;

        System.out.println("Ingresa la cantidad de payasos vendidos: ");
        int cantidadPayasos = sc.nextInt();

        System.out.println("Ingresa la cantidad de muñecas vendidas: ");
        int cantidadMunecas = sc.nextInt();

        int pesoTotal = (cantidadPayasos * PESO_PAYASO) + (cantidadMunecas * PESO_MUNECA);

        System.out.println("El peso total del paquete es: " + pesoTotal + " gramos");*/

        //6.- FRASE INVERTIDA

        /*System.out.println("Introduce una frase: ");
        String frase = sc.nextLine();

        String fraseInvertida = new StringBuilder(frase).reverse().toString();

        System.out.println("La frase invertida es: " + fraseInvertida);*/


    }
}