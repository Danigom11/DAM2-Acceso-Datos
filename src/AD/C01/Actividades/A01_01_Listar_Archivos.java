package AD.C01.Actividades;

import java.io.*;
import java.util.Scanner;

public class A01_01_Listar_Archivos {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("""
                    ==============================================
                    Listar Archivos de una carpeta
                    1. Del directorio que tu me digas
                    2. Del directorio actual
                    0. Salir
                    ==============================================""");

            int eleccion = pedirNumeroEntero("Elige: ", 0, 2);
            if (eleccion == 0) {
                System.out.println("Hasta otra.");
                break;
            }
            switch (eleccion) {
                case 1 -> {
                    System.out.print("Directorio: ");
                    String directorio = sc.nextLine();
                    String[] listaArchivos = arrayFicheros(directorio);
                    if (listaArchivos != null){
                        mostrarLista(listaArchivos, directorio);
                    } else {
                        System.out.println("Esa carpeta no existe.");
                    }
                }
                case 2 -> {
                    System.out.println("Archivos en el directorio actual: ");
                    String directorioActual = ".";
                    String[] listaArchivos = arrayFicheros(directorioActual);
                    mostrarLista(listaArchivos, directorioActual);
                }
            }
        }
    }

    public static String[] arrayFicheros(String carpeta) {
        File f = new File(carpeta);
        return f.list();
    }

    public static void mostrarLista(String[] lista, String carpeta){
        for (String archivo : lista){
            File f = new File(carpeta, archivo);
            if (f.isFile()) {
                System.out.println(archivo);
            }
        }
    }

    public static int pedirNumeroEntero(String mensaje, int minimo, int maximo) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                sc.nextLine();
                if (numero >= minimo && numero <= maximo) {
                    return numero;
                } else {
                    System.out.println("El número debe estar entre " + minimo + " y " + maximo + ".");
                }
            } else {
                System.out.print("Introduce un número válido. ");
                sc.nextLine();
            }
        }
    }

}