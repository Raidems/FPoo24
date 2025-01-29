import java.util.Scanner;

public class Act2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero entero: ");
        int num = sc.nextInt();
        sc.close();

        for (int i = num; i >=0; i--) {
            if(i<num)System.out.println(",");
            System.out.println(i);
        }
    }
}
