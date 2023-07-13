/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;

/**
 *
 * @author reroes
 */
public interface APIMovie {
    
    public void establecerApiKey(String ak);
    
    public String obtenerApiKey();

    /**
     *
     * @author carlo
     */
    public static class APIDisneyMovie {
    }

    /**
     *
     * @author carlo
     */
    public static class APIStartplus {
    }
    
}
