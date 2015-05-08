/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

/**
 *
 * @author Cyn
 */
public class Ganador implements Estado{
    private String ganador;
    
    public Ganador(String gan) {
        ganador = gan;
    }

    @Override
    public String getGanador() {
        return ganador;
    }
}
