package AD.C01;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class U01_Ficheros {
    public static void main(String[] args) throws IOException {
        File fichero1 = new File("C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01\\ejemplo1.txt");

        String directorio = "C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01";
        File fichero2 = new File(directorio, "ejemplo2.txt");

        File direc = new File(directorio);
        File fichero3 = new File(direc, "ejemplo3.txt");

        System.out.println("============================");
        System.out.println("|    MÉTODOS DE FILE        |");
        System.out.println("============================");

        // String[] list() Para ver que hay dentro de una carpeta. Solo para carpetas, no usar con archivos
        System.out.println("String[] list(): "+ Arrays.asList(direc.list()));

        // File() listFiles() Devuelve un array de Files que haya en una carpeta
        File[] arrayDeFiles = direc.listFiles();
        System.out.println("Array de Files: " + Arrays.asList(arrayDeFiles));

        // String getName() Nombre de un fichero o directorio
        System.out.println("Nombre del fichero2: " + fichero2.getName());

        // String getPath() Ruta
        System.out.println("Ruta de fichero1: " + fichero1.getPath());

        // String getAbsolutePath() Ruta absoluta
        System.out.println("Ruta absoluta de fichero1: " + fichero1.getAbsolutePath());

        // boolean exists()
        System.out.println("¿Existe el fichero1? " + fichero1.exists());
        if (!fichero1.exists()) {
            fichero1.createNewFile();
        }
        System.out.println("¿Existe el fichero1? " + fichero1.exists());

        //boolean canWrite, boolan canRead
        System.out.println("Puedes escribir en fichero1: " + fichero1.canWrite());
        System.out.println("Puedes leer en fichero1: " + fichero1.canRead());

        // boolean isFile(), boolean isDirectory()
        System.out.println("Fichero1 es un archivo: " + fichero1.isFile());
        System.out.println("Fichero1 es una carpeta: " + fichero1.isDirectory());
        System.out.println("Direc es una carpeta: " + direc.isDirectory());

        // long length() tamaño del archivo en bytes
        System.out.println("Fichero1 tiene el siguiente tamaño: " + fichero1.length());

        // boolean mkdir() crear una carpeta siempre que no exista
        File carpetaPrueba = new File("C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01\\carpetaPrueba");
        carpetaPrueba.mkdir();

        // boolean renameTo(File nuevonombre) IMPORTANTE la variable sigue con el nombre antigüo, hay que actualizarla
        fichero1.renameTo(new File(directorio, "archivo1.txt"));
        System.out.println("Nombre cambiado");
        fichero1 = new File(directorio, "archivo1.txt");
        System.out.println("Fichero1 con el nombre ejemplo1 ahora se llama: " + fichero1.getName());

        // boolean delete() borrar
        if (carpetaPrueba.delete()){
            System.out.println("Carpeta borrada.");
        }

        // boolean createNewFile() Crear un nuevo archivo si no existe
        File archivoPrueba = new File(directorio, "archivoPrueba.txt");
        if (archivoPrueba.createNewFile()){
            System.out.println("Archivo creado");
        }

        // String getParent() nombre directorio padre o null si no existe
        if (fichero1.exists()) {
            System.out.println("Directorio padre de fichero1: " + fichero1.getParent());
        }

    }
}