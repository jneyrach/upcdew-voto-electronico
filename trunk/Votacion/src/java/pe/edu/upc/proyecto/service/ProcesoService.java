/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.proyecto.service;

import java.util.List;
import pe.edu.upc.proyecto.dao.ProcesoDao;
import pe.edu.upc.proyecto.model.Persona;
import pe.edu.upc.proyecto.model.Proceso;

/**
 *
 * @author Administrador
 */
public class ProcesoService {
    ProcesoDao procesoDao;

    public ProcesoService() {
        this.procesoDao = new ProcesoDao();
    }

    public List<Proceso> getProcesosActivos(){
        return procesoDao.getProcesosActivos();
    }

    public Proceso getProcesoPorId(String idProceso){
        return procesoDao.getProcesoPorId(idProceso);
    }

    public Persona getCandidatoDeProceso(String idProceso, String idCandidato){
        Proceso proceso;
        proceso = procesoDao.getProcesoPorId(idProceso);
        return procesoDao.getCandidatoDeProceso(proceso, idCandidato);
    }


}
