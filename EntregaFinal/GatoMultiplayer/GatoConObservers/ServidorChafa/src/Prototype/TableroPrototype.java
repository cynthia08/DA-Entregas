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
public abstract class TableroPrototype implements Cloneable {
    private String id;
    private Casillas casillas = new Casillas();

    public Casillas getCasillas() {
        return casillas;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public TableroPrototype clone() {
        return null;
    }
}
