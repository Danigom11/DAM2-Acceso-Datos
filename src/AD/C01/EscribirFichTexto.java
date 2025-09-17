package AD.C01;

import java.io.*;

public class EscribirFichTexto {
    public static void main(String[] args) {
        // Declarar el fichero
        File fichero = new File("C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01\\FichTexto.txt");

        // Crear el flujo de salida
        try {
            // IMPORTANTE: true para que no borre todo o nada para que se sobreescriba todo
            FileWriter fw = new FileWriter(fichero, true);
            String cadena = "Texto de prueba con FileWriter";
            // Convertir la cadena en un array de caracteres para ir 1 a 1
            char[] cad = cadena.toCharArray();
            for (char c : cad) {
                fw.write(c);
            }
            for (int i = 0; i < 10; i++)
                fw.append('*');
            fw.append('\n');
            // Opción B: Meter el array entero en vez de ir carácter a carácter
            String[] provincias = {
                    "Albacete", "Ávila", "Badajoz", "Cáceres", "Huelva", "Jaén", "Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"
            };
            for (String provincia : provincias) {
                fw.write((provincia + ", "));
            }
            fw.append('\n');

            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}