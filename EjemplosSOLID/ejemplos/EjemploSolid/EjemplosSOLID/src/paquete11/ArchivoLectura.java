package paquete11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class ArchivoLectura {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<GeneradorPelicula> lista;

    public ArchivoLectura(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("datos/%s", nombreArchivo);
        // data/profesores.txt
        File f = new File(rutaArchivo); // data/profesores.txt

        if (f.exists()) {

            try {

                entrada = new Scanner(new File(rutaArchivo));
                // entrada = new Scanner(System.in);
                // entrada = new Scanner(f);
            } // fin de try
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("datos/%s.txt",
                obtenerNombreArchivo());
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    // establecer valores de cada línea
    // en la lista de tipo Profesor
    public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);

        if (f.exists()) {

            while (entrada.hasNext()) {
                String linea = entrada.nextLine(); // 1;usuario001;Netflix

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";"))); // 1 [usuario001] de netflix

                establecerProceso(linea_partes);

            } // fin de while
        }
    }

    public void establecerProceso(ArrayList<String> linea_partes) {
        for (int i = 0; i < linea_partes.size(); i++) {
            switch (linea_partes.get(i)) {
                case "Netflix": {
                    APINetflix netflix = new APINetflix();

                    String ak = String.format("%s/user?%s",
                            linea_partes.get(2),
                            linea_partes.get(1));
                    netflix.establecerApiKey(ak);

                    GeneradorPelicula g1 = new GeneradorPelicula();
                    g1.establecerLlave(netflix);
                    g1.establecerUrl("http://api.movie?api=");
                    g1.establecerUser(linea_partes.get(1));
                    lista.add(g1); // anadir el gen
                    break;
                }
                case "Amazon": {
                    APIAmazonMovie amazon = new APIAmazonMovie();
                    String ak = String.format("%s/user?%s",
                            linea_partes.get(2), linea_partes.get(1));
                    amazon.establecerApiKey(ak);

                    GeneradorPelicula g1 = new GeneradorPelicula();
                    g1.establecerLlave(amazon);
                    g1.establecerUrl("http://api.movie?api=");
                    g1.establecerUser(linea_partes.get(1));
                    lista.add(g1); // anadir el gen
                    break;
                }
                case "Disney": {
                    APIDisney disney = new APIDisney();
                    String ak = String.format("%s/user?%s",
                            linea_partes.get(2),
                            linea_partes.get(1));
                    disney.establecerApiKey(ak);

                    GeneradorPelicula g1 = new GeneradorPelicula();
                    g1.establecerLlave(disney);
                    g1.establecerUrl("http://api.movie?api=");
                    g1.establecerUser(linea_partes.get(1));
                    lista.add(g1); // anadir el gen
                    break;
                }
                case "Startplus": {
                    APIStartplus starplus = new APIStartplus();
                    String ak = String.format("%s/user?%s",
                            linea_partes.get(2),
                            linea_partes.get(1));
                    starplus.establecerApiKey(ak);
                    
                    GeneradorPelicula g1 = new GeneradorPelicula();                   
                    g1.establecerLlave(starplus);
                    g1.establecerUrl("http://api.movie?api=");
                    g1.establecerUser(linea_partes.get(1));
                    lista.add(g1); // anadir el gen
                    break;
                }
                default:
                    break;
            }
        }
    }

    

    public ArrayList<GeneradorPelicula> obtenerListaGeneradores() { // usernames
        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // cierra el archivo

    }

}
