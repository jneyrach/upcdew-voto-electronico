/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.proyecto.dao;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.proyecto.model.ModeloDominio;
import pe.edu.upc.proyecto.model.Persona;
import pe.edu.upc.proyecto.model.Proceso;

/**
 *
 * @author Administrador
 */
public class ProcesoDao {

    ModeloDominio modelo;
    List<Proceso> procesos;

    public ProcesoDao(){
        modelo = new ModeloDominio();
        procesos = modelo.getProcesos();
    }

    public List<Proceso> getProcesosActivos(){
        return procesos;
    }

    public Proceso getProcesoPorId(String idProceso){
         for (Proceso proceso : procesos) {
            if(proceso.getIdProceso().equals(idProceso)){
                return proceso;
            }
        }
        return null;
    }

    public Persona getCandidatoDeProceso(Proceso proceso, String idCandidato){
        for (Persona candidato : proceso.getCandidatos()) {
            if(candidato.getIdPersona().equals(idCandidato)){
                return candidato;
            }
        }
        return null;
    }

}
