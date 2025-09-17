package AD.C01;
import java.io.*;

public class LeerFichTexto {
    public static void main(String[] args) throws IOException{
        // Declarar el fichero
        File fichero = new File("C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01\\LeerFichTexto.java");
        // Crear el flujo de entrada hacia el fichero
        FileReader fr = new FileReader(fichero);
        int i;
        while ((i = fr.read()) != -1) {
            System.out.println((char) i);
        }

        // Opción B: leer un número concreto de caracteres
        char[] b = new char[20];
        while ((i = fr.read(b)) != -1){
            System.out.println(i);
        }

        // Cerrar el fichero
        fr.close();

    }
}
