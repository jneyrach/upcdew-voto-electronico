/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.service;

import java.util.HashMap;
import java.util.List;
import pe.edu.upc.proyecto.dao.ProcesoDao;
import pe.edu.upc.proyecto.model.Estadistica;
import pe.edu.upc.proyecto.model.Persona;
import pe.edu.upc.proyecto.model.Proceso;

/**
 *
 * @author jcruzm
 */
public class ProcesoServiceImpl implements ProcesoService {

    ProcesoDao procesoDao;

    public void setProcesoDao(ProcesoDao procesoDao) {
        this.procesoDao = procesoDao;
    }

    public List<Proceso> getProcesos(int estadoJornada) {
        return procesoDao.getProcesos(estadoJornada);
    }

    public List<Proceso> getProcesos() {
        return procesoDao.getProcesos();
    }

    public Proceso getProcesoPorId(String idProceso) {
        return procesoDao.getProcesoPorId(idProceso);
    }

    public Persona getCandidatoDeProceso(String idProceso, String idCandidato) {
        return procesoDao.getCandidatoDeProceso(idProceso, idCandidato);
    }

    public List<Persona> getCandidatosProceso(String procesoId){
        return procesoDao.getCandidatosProceso(procesoId);
    }

    public void actualizarProceso(String idProceso, int estado) {
        procesoDao.actualizarProceso(idProceso,estado);
    }

    public Estadistica getEstadisticas(String idProceso){
        return procesoDao.getEstadisticas(idProceso);
    }
}
