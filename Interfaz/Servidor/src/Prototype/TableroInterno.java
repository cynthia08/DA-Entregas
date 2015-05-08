/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

/**
 *
 * @author Cyn
 */
public class TableroInterno extends TableroPrototype {  
    @Override
    public TableroInterno clone() {
        return (TableroInterno) super.clone();
    }
}
