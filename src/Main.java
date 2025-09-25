import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static void eliminarArchivo(File archivo) throws FileNotFoundException{
        if(!archivo.exists()){
            System.out.println("El archivo no existe");
            throw new IllegalArgumentException("El archivo no existe");
        } else  if(archivo.isFile()){
            archivo.delete();
            System.out.println("El archivo ha sido eliminado corréctamente");
        } else  if(archivo.isDirectory()){
            File[] archivos = archivo.listFiles();
            for(File f : archivo.listFiles()){
                eliminarArchivo(f);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("######MENU######");

        System.out.println("1 Crear Archivo");
        System.out.println("2 Ejemplo");

        System.out.println("3 Eliminar");
        System.out.println("4 Comprobar archivo");


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
                System.out.println("Introduce la ruta del directorio: ");
                String rutaDirectorio = sc.nextLine();

                File directorio = new File(rutaDirectorio);

                if (directorio.exists() && directorio.isDirectory()) {
                    String[] archivos = directorio.list();

                    System.out.println("\nContenido del directorio: ");
                    for (String archivo : archivos) {
                        System.out.println(archivo);
                    }
                } else {
                    System.out.println("La ruta no es un directorio válido");
                }
                break;
            }

            case 3: {
                System.out.print("Archivo: ");
                File file = new File(sc.nextLine());
                eliminarArchivo(file);
                break;
            }

            default: {
                System.out.println("Opción no valida.");
                break;
            }

            case 4:{
                System.out.println("Comprobar archivo");
                comprobarArchivo();
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

    public static void comprobarArchivo() {
        Scanner sc = new Scanner(System.in);

        // todo ok

        System.out.print("Introduce la ruta del archivo a comprobar: ");
        File archivo = new File(sc.nextLine());

        if (archivo.exists()) {
            if (archivo.isFile()) {
                System.out.println(" El archivo existe: " + archivo.getAbsolutePath());
            } else if (archivo.isDirectory()) {
                System.out.println(" Es un directorio: " + archivo.getAbsolutePath());
            }
        } else {
            System.out.println(" El archivo no existe.");
        }
    }


}