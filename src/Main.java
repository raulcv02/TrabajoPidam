import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("######MENU######");
        System.out.println("1 Ejemplo");
        System.out.println("2 Ejemplo");


        System.out.print("\nOpcion: ");

        // Esto hace que si lo que han escrito en el scanner no es un numero que se quede atascado ahi
        while (!sc.hasNextInt()) {

            System.out.println("Introduce un numero no letras");
            sc.nextLine();

            System.out.print("\nOpcion: ");
        }

        int opt = sc.nextInt();

        switch (opt) {

            case 1: {}


        }
    }
}