package AD.C01;

import java.io.File;
import java.io.IOException;

public class CrearDir {
    public static void main(String[] args) {
        // Variables del directorio y los archivos a crear
        File d = new File("NUEVODIR");
        File f1 = new File(d, "FICHERO1.TXT");
        File f2 = new File(d, "FICHERO2.TXT");
        // Crear directorio
        d.mkdir();

        // Crear ficheros
        try {
            if (f1.createNewFile()) {
                System.out.println("FICHERO1 creado correctamente.");
            } else {
                System.out.println("No se ha podido crear FICHERO1");
            }
            if (f2.createNewFile()) {
                System.out.println("FICHERO2 creado correctamente.");
            } else {
                System.out.println("No se ha podido crear FICHERO2");
            }
        } catch (IOException e) {
            System.err.println("Error al crear FICHERO1: " + e.getMessage());
        }

        // Renombrar fichero
        f1.renameTo(new File(d, "FICHERO1NUEVO"));

        // Crear carpeta y fichero a la vez
        try {
            File f3 = new File("NUEVODIR/FICHERO3.TXT");
            f3.createNewFile();
        } catch (IOException e) {
            System.err.println("Error al crear FICHERO1: " + e.getMessage());
        }

        if (f2.delete())
            System.out.println("Fichero borrado");
        else
            System.out.println("No se ha podido borrar el fichero");
    }
}