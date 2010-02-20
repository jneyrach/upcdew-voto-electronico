/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.model;

/**
 *
 * @author JESUS
 */
public class Voto {

    private Persona elector;
    private Proceso proceso;
    private int estadoVoto; // 0=no voto, 1=voto, 2=voto blanco
    private Persona candidato;

    public Persona getCandidato() {
        return candidato;
    }

    public void setCandidato(Persona candidato) {
        this.candidato = candidato;
    }

    public Persona getElector() {
        return elector;
    }

    public void setElector(Persona elector) {
        this.elector = elector;
    }

    public int getEstadoVoto() {
        return estadoVoto;
    }

    public void setEstadoVoto(int estadoVoto) {
        this.estadoVoto = estadoVoto;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

}
