package AD.C01;

import java.io.*;

public class EscribirFichTextoBuf {
    public static void main(String[] args) {
        try {
            BufferedWriter fichero = new BufferedWriter(new FileWriter("C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01\\FichTexto.txt"));
            for (int i = 1; i < 11; i++) {
                fichero.write("Fila número: " + i);
                fichero.newLine();
            }
            fichero.close();

            // OPCIÓN B: Con PrintWriter
            PrintWriter fichero2 = new PrintWriter(new FileWriter("C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01\\FicheroConPrintWriter.txt", true));
            for (int i = 1; i < 11; i++) {
                fichero2.println("Fila número: " + i);
            }
            fichero2.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException io) {
            System.out.println("Error de entrada / salida");
        }
    }

}