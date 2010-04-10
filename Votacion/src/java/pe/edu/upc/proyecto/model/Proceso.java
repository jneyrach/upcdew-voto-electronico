/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JESUS
 */
public class Proceso {

    private String idProceso;
    private String nombre;
    private int estadoJornada; //0 = no iniciado, 1 = iniciado, 2 = cerrado
    private Date fecha;
    List<Persona> candidatos;
    List<Voto> votos;

    public Proceso() {
        this.candidatos = new ArrayList<Persona>();
        this.votos = new ArrayList<Voto>();
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }



    public List<Persona> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Persona> candidatos) {
        this.candidatos = candidatos;
    }

    public int getEstadoJornada() {
        return estadoJornada;
    }

    public void setEstadoJornada(int estadoJornada) {
        this.estadoJornada = estadoJornada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}
