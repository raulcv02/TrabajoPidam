import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("######MENU######");
        System.out.println("1 Crear Archivo");
        System.out.println("2 Ejemplo");

        System.out.print("\nOpcion: ");
        int opt = sc.nextInt();

        switch (opt) {

            case 1: {

                crearArchivo();
            }
        }
    }

    static void crearArchivo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del archivo: ");
        File file = new File(sc.nextLine());
        try {

            if (file.createNewFile()) {

                System.out.println("Archivo creado correctamente");
            }
            else {

                System.out.println("Error al crear el archivo, el archivo ya existia");
            }
        }
        catch (IOException e) {

            System.out.println("Error al crear el archivo");
            throw new RuntimeException(e);
        }
    }
}