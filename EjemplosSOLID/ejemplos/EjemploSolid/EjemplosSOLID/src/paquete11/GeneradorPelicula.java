/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;

public class GeneradorPelicula {

    private APIMovie llave;
    private String url;
    private String user;
    // agregar un user (tipo String)
    
    public void establecerUser (String u){
        user = u;
    }

    public void establecerLlave(APIMovie l) { // APINetflix, APIAmazon
        llave = l;       
    }

    public void establecerUrl(String l) {
        url = String.format("%s%s", l, obtenerLlave().obtenerApiKey());
        
    }

    public APIMovie obtenerLlave() {
        return llave;
    }

    public String obtenerUrl() {
        return url;
    }

    public String obtenerUser() {
        return user;
    }
    
    

    @Override
    public String toString() {
        String reporte = String.format("User: %s\n"
                + "Key: %s\n"
                + "URL: %s\n\n",
                user,
                llave.obtenerApiKey(),
                obtenerUrl());
        return reporte;
    }

}
