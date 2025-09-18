import java.io.File;
import java.util.Scanner;

public class Main {
    private static System system;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("######MENU######");
        System.out.println("1 Ejemplo");
        System.out.println("2 Ejemplo");

        System.out.print("\nOpcion: ");
        int opt = sc.nextInt();

        switch (opt) {

            case 1: {
                //listar directorio
                system.out.println("Introduce la ruta del directorio: ");
                String rutaDirectorio = sc.nextLine();

                File directorio = new File(rutaDirectorio);

                if (directorio.exists() && directorio.isDirectory()) {
                    String [] archivos = directorio.list();

                    system.out.println("\nContenido del directorio: ");
                    for (String archivo : archivos){
                        system.out.println(archivo);
                    }
                } else {
                    system.out.println("La ruta no es un directorio válido");
                }
                break;
            }

            case 2:{
                system.out.println("Has seleccionado el caso 2.");
                break;

            }
            default: {
                system.out.println("Opción no valida.");
            }


        }
    }
}