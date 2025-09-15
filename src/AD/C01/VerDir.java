package AD.C01;

import java.io.*;

public class VerDir {
    public static void main(String[] args) {
        String dir = "."; // El . es para el directorio actual
        File f = new File(dir);

        // Opción 2 para ver un directorio concreto
        File fEspecificado = new File("C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01");

        // Opción 3 para ver el directorio pasado por parámetro al ejecutar el programa
        String dirParametro = args[0];
        System.out.println("Archivos del directorio " + dirParametro);
        File fParametro = new File(dirParametro);

        String[] archivos = fParametro.list();
        System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
        for (int i = 0; i < archivos.length; i++){
            File f2 = new File(fParametro, archivos[i]);
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i], f2.isFile(), f2.isDirectory());
        }
    }
}