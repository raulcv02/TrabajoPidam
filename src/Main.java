import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("######MENU######");

        System.out.println("1 Crear Archivo");
        System.out.println("2 Listar Directorio");
        System.out.println("3 Eliminar");
        System.out.println("4 Comprobar archivo");
        System.out.println("5 Escribir archivo");
        System.out.println("6 Leer archivo");

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

                if (comprobarArchivo(file, true)) {eliminarArchivo(file);}
                break;
            }

            case 4: {

                System.out.print("Archivo: ");

                comprobarArchivo(new File(sc.nextLine()), false);
                break;
            }

            case 5: {

                System.out.print("Archivo: ");
                File file = new File(sc.nextLine());

                if (comprobarArchivo(file, true)) {escribirArchivo(file);}
                break;
            }

            case 6: {

                System.out.print("Archivo: ");
                File file = new File(sc.nextLine());

                if (comprobarArchivo(file, true)) {leerArchivo(file);}
                break;
            }

            default: {

                System.out.println("Opción no valida.");
                break;
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

    static void eliminarArchivo(File archivo) {

        if(archivo.isFile()) {

            archivo.delete();
        }
        else  if(archivo.isDirectory()) {

            for(File f : archivo.listFiles()) {
                eliminarArchivo(f);

            }
            archivo.delete();
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

    static boolean comprobarArchivo(File file, boolean metodo) {

        if (file.exists()) {

            if (metodo) {

                return true;
            }

            if (file.isFile()) {

                System.out.println("El archivo existe");
            }
            else if (file.isDirectory()) {

                System.out.println("El directorio existe");
            }
            return true;
        }
        else {
            System.out.println("El archivo no existe.");
        }
        return false;
    }

    static void escribirArchivo(File file) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Que quieres escribir en el documento: ");

        String texto = "";


        while (true) {

            String linea = sc.nextLine();
            if (linea.equals("")) {

                break;
            }
            texto += linea + "\n";

        }

        try {

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(texto);
            bw.newLine();

            bw.close();
            System.out.println("Escrito correctamente");
        }
        catch (IOException e) {

            System.out.println("Error de escribir:" + e.getMessage());
        }
    }

    static void leerArchivo(File file) throws FileNotFoundException {
        Scanner texto = new Scanner(file);

        while (texto.hasNextLine()) {

            System.out.println(texto.nextLine());
        }
        texto.close();
    }
}


