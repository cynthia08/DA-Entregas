/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

/**
 *
 * @author Cyn
 */
public interface Handler {
    public void siguiente(Handler siguienteHandler);
    public String getFigura();
    public String procesa(String fig);
}
