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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("######MENU######");
        System.out.println("1 Eliiminar");
        System.out.println("2 Ejemplo");

        System.out.print("\nOpcion: ");
        int opt = sc.nextInt();


        switch (opt) {

            case 1: {}

            case 2: {}

            case 3:  {}
        }
    }
}