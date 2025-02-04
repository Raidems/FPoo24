import java.util.Scanner;

public class Ejer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa un Numero entero: ");
        int num = sc.nextInt();

        do{
            for (int i = 1; i <= num; i++){
                if (i % 2 == 0){
                    int par = i / 2;
                    System.out.println(par);
                } else if (i % 2 == 1) {
                    int impar = i / 2;
                    System.out.println(impar);
                }
            }
        }while(num != 1);
    }
}
