/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete11;

/**
 *
 * @author carlo
 */
public class APIDisney implements APIMovie{
     private String apiKey;

    @Override
    public void establecerApiKey(String ak) {
        int random = (int) (Math.random() * 472132);
        apiKey = ak + "DISNEY" + random;
    }

    @Override
    public String obtenerApiKey() {
        return apiKey;
    }

}
