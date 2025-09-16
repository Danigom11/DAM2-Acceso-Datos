package AD.C01.Actividades;

import java.io.File;

public class A01_01_Mostrar_Ficheros_Por_Parametro {

    public static void main(String[] args) {
        // Verificar que se ha pasado un parámetro
        if (args.length == 0) {
            System.out.println("No se ha proporcionado ningún parámetro");
            System.out.println("Cómo usar: java A01_01_Mostrar_Ficheros_Por_Parametro parámetro_o_carpeta");
            System.out.println("O darle a los tres puntos arriba en el IDE y añadirle el parámetro");
            return;
        }

        // Obtener el directorio del primer parámetro
        String nombreDirectorio = args[0];
        File directorio = new File(nombreDirectorio);

        // Verificar si el directorio existe
        if (!directorio.exists()) {
            System.out.println("La carpeta '" + nombreDirectorio + "' no existe.");
            return;
        }

        // Verificar si es realmente un directorio
        if (!directorio.isDirectory()) {
            System.out.println("'" + nombreDirectorio + "' no es la ruta de una carpeta.");
            return;
        }

        // Obtener la lista de archivos
        String[] listaArchivos = directorio.list();

        // Comprobar que no haya fallos al obtenerla
        if (listaArchivos == null || listaArchivos.length == 0) {
            System.out.println("El directorio '" + nombreDirectorio + "' está vacío.");
            return;
        }

        // Mostrar los archivos
        System.out.println("Contenido de la carpeta '" + nombreDirectorio + "':");
        System.out.println("===================================================");

        for (String archivo : listaArchivos) {
            File elemento = new File(directorio, archivo);

            if (elemento.isFile()) {
                System.out.println("[ARCHIVO]    " + archivo);
            } else {
                System.out.println("[DIRECTORIO] " + archivo);
            }
        }

        System.out.println("===================================================");
        System.out.println("Total: " + listaArchivos.length);
    }
}