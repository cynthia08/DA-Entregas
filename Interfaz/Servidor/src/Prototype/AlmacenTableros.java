/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

import java.util.*;
/**
 *
 * @author Cyn
 */
public class AlmacenTableros {
    private static HashMap<String, TableroPrototype> tableros = new HashMap<String, TableroPrototype>();
    private TableroGeneral tableroGeneral;
    
    public static TableroPrototype getInstancia(final String id) throws CloneNotSupportedException {
        return ((TableroPrototype) tableros.get(id)).clone();
    }
    
    public AlmacenTableros() {
        for (int i = 0; i < 9; i++) {
            tableros.put(""+i, new TableroInterno());
        }
        
        tableroGeneral = new TableroGeneral();
    }
    
    public HashMap<String, TableroPrototype> getTableros() {
        return tableros;
    }
    
    public TableroGeneral getTableroGeneral() {
        return tableroGeneral;
    }
}
