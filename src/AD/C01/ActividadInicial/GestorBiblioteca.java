package AD.C01.ActividadInicial;

import java.io.*;
import java.util.ArrayList;

public class GestorBiblioteca {
    static String ruta = "C:\\Users\\danig\\Downloads\\DAM2\\DAM2\\src\\AD\\C01\\ActividadInicial\\libros.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(new Libro(111111, "El Quijote", "Cervantes", 1800));
        libros.add(new Libro(22222, "Código Da Vinci", "Dan Brown", 2015));
        libros.add(new Libro(33333, "El médico", "Noa Gordon", 2010));
        libros.add(new Libro(44444, "Parque Jurásico", "Michael Crichton", 2010));
        libros.add(new Libro(55555, "Los pilares de la tierra", "Ken Follet", 2008));
        // Paso 1.3
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
        System.out.println();

        // Pasos 2.1,2,3
        guardarLibrosEnArchivo(libros);
        ArrayList<Libro> librosNuevo = leerFicheroCrearLista();
        if (librosNuevo.isEmpty()) {
            System.out.println("\nLa lista de libros está vacía");
            return;
        }
        for (Libro libro : librosNuevo) {
            System.out.println(libro.toString());
        }
        System.out.println();

        // Pasos 3.2,3,4
        guardarConObjectOutputStream(libros);
        ArrayList<Libro> librosConObjectInputStream = leerYRecuperarLibrosOutputInputStream();
        System.out.println("MOSTRAR LIBROS CON OBJECTINPUTSTREAM");
        for (Libro libro : librosConObjectInputStream) {
            System.out.println(libro.toString());
        }
    }


    private static void guardarLibrosEnArchivo(ArrayList<Libro> libros) throws IOException {
        // Crear fichero
        File archivo = new File(ruta);
        try {
            if (!archivo.createNewFile()) {
                System.out.println("Archivo libros.txt creado correctamente.");
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        // Crear el stream que gestiona entradas y salidas al fichero
        try {
            FileWriter fw = new FileWriter(ruta);
            String separador = ";";
            // Grabar los libros en el fichero
            for (Libro libro : libros) {
                fw.write(libro.isbn + separador + libro.titulo + separador + libro.autor + separador + libro.anio + separador);
            }
            fw.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static ArrayList<Libro> leerFicheroCrearLista() {
        ArrayList<Libro> listaNueva = new ArrayList<>();
        try {
            FileReader fr = new FileReader(ruta);
            // Guardar en una variable cada parte del libro
            String isbn = "";
            String titulo = "";
            String autor = "";
            String anio = "";
            // Variable que almacenará cada carácter con su valor ASCII
            int i;
            // Cada libro tiene cuatro puntos y coma, máximo contador = 4
            int contador = 1;

            while ((i = fr.read()) != -1) {
                // Avanzar siempre que i no sea un punto y coma
                if (i != (int) ';') {
                    switch (contador) {
                        case 1 -> {
                            isbn += (char) i;
                        }
                        case 2 -> {
                            titulo += (char) i;
                        }
                        case 3 -> {
                            autor += (char) i;
                        }
                        case 4 -> {
                            anio += (char) i;
                        }
                    }
                } else {
                    contador++;
                    if (contador == 5) {
                        // Añadir libro a la nueva lista
                        listaNueva.add(new Libro(Integer.parseInt(isbn), titulo, autor, Integer.parseInt(anio)));
                        // Reiniciar contador y las variables del libro
                        contador = 1;
                        isbn = "";
                        titulo = "";
                        autor = "";
                        anio = "";
                    }
                }
            }

            // Cerrar, no olvidar
            fr.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        return listaNueva;
    }

    private static void guardarConObjectOutputStream(ArrayList<Libro> libros) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
        for (Libro libro : libros) {
            oos.writeObject(libro);
        }
        oos.close();
    }

    private static ArrayList<Libro> leerYRecuperarLibrosOutputInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));
        ArrayList<Libro> nuevaListaLibros = new ArrayList<>();
        Libro libro;
        try {
            while (true) {
                // Cuando no hay más libros que leer lanza EOFEException
                libro = (Libro) ois.readObject();
                nuevaListaLibros.add(libro);
            }
        } catch (EOFException e) {
            System.out.println("Fin de lectura del libro con ObjectInputStream");
        }
        ois.close();
        return nuevaListaLibros;
    }
}