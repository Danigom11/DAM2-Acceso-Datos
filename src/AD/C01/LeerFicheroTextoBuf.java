package AD.C01;
import java.io.*;

public class LeerFicheroTextoBuf {
    public static void main(String[] args) {
        try {
            BufferedReader fichero = new BufferedReader(new FileReader("C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01\\LeerFichTexto.java"));
            String linea;
            while ((linea = fichero.readLine()) != null){
                System.out.println(linea);
            }
            fichero.close();
        } catch (FileNotFoundException fn){
            System.out.println("No se encuentra el fichero");
        } catch (IOException io) {
            System.out.println("Error de entrada / salida");
        }
    }
}