import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static System system;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("######MENU######");
        System.out.println("1 Crear Archivo");
        System.out.println("2 Ejemplo");


        System.out.print("\nOpcion: ");

        // Esto hace que si lo que han escrito en el scanner no es un numero que se quede atascado ahi
        while (!sc.hasNextInt()) {

            System.out.println("Introduce un numero no letras");
            sc.nextLine();

            System.out.print("\nOpcion: ");
        }

        int opt = sc.nextInt();
        sc.nextLine();

        switch (opt) {

            case 1: {

                crearArchivo();
                break;
            }

            case 2: {
                //listar directorio
                system.out.println("Introduce la ruta del directorio: ");
                String rutaDirectorio = sc.nextLine();

                File directorio = new File(rutaDirectorio);

                if (directorio.exists() && directorio.isDirectory()) {
                    String[] archivos = directorio.list();

                    system.out.println("\nContenido del directorio: ");
                    for (String archivo : archivos) {
                        system.out.println(archivo);
                    }
                } else {
                    system.out.println("La ruta no es un directorio válido");
                }
                break;
            }
            default: {
                system.out.println("Opción no valida.");
                break;
            }
        }
    }


        public static void crearArchivo() {
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


