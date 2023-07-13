/*
 * 
 * D - Dependency inversion principle (Principio de inversión de dependencias)
 */
package paquete11;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        /*
        Usar el txt llamado usuarios.txt; por cada línea del archivo
        crer un API en función de su servicio; además el API ahora genera
        información estática (no cambia el API), se debe buscar la forma que el 
        API sea dinámico totalmente (usar alguna librería propia de JAVA, tipo 
        Random); la url final debe contener el tipo de servicio y el user
        Por cada objeto de tipo GeneradorPelicula presentar la información 
        a través de un toString
         */
        
        String nombreArchivo = "usuarios.txt";
        ArchivoLectura lectura = new ArchivoLectura(nombreArchivo);
        lectura.establecerLista();
        ArrayList<APIMovie> lista = lectura.obtenerLista();
        ArrayList <Auxiliar> listaAux = lectura.obtenerListaAuxiliar();
        ArrayList<GeneradorPelicula> gp = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            GeneradorPelicula g1 = new GeneradorPelicula();
            g1.establecerLlave(lista.get(i));
            g1.establecerUrl("http://api.movie?api=");
            g1.establecerUser(listaAux.get(i).user);
            gp.add(g1);
        }
        for (int i = 0; i < gp.size(); i++) {
            System.out.print(gp.get(i));

        }
        
        lectura.cerrarArchivo();

    }
}
