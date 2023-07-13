/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;
 /**
     *
     * @author carlo
     */
public interface APIMovie {
    
    public void establecerApiKey(String ak);
    
    public String obtenerApiKey();

   
    public static class APIDisneyMovie {
    }
    
    public static class APIStartplus {
    }
    
}
