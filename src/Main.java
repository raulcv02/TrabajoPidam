import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("######MENU######");

        System.out.println("1 Crear Archivo");
        System.out.println("2 Listar Directorio");
        System.out.println("3 Eliminar");

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

                listar();
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

    static void listar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta del directorio: ");
        String rutaDirectorio = sc.nextLine();

        File directorio = new File(rutaDirectorio);

        if (directorio.isDirectory()) {

            File[] archivos = ordenar(directorio.listFiles());

            for (File file : archivos) {

                if (file.isDirectory()) {

                    System.out.println("[*] " + file.getName());
                }
                else {

                    System.out.println("[A] " + file.getName());
                }
            }
        }
        else {

            System.out.println("Ruta no valida");
        }
    }

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

    static File[] ordenar(File[] files) {

        Arrays.sort(files);
        File[] sorted = new File[files.length];
        int contador = 0;

        for (File file : files) {

            if (file.isDirectory()) {

                sorted[contador] = file;
                contador++;
            }
        }

        for (File file : files) {

            if (contador == files.length) {

                break;
            }
            if (file.isFile()) {

                sorted[contador] = file;
                contador++;
            }
        }

        return sorted;
    }
}


