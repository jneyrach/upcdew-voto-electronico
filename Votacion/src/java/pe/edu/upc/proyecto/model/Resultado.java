/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.model;

/**
 *
 * @author JESUS
 */
public class Resultado {

    private Persona candidato;
    private int cantidadVotos;

    public Persona getCandidato() {
        return candidato;
    }

    public void setCandidato(Persona candidato) {
        this.candidato = candidato;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }
   
}
