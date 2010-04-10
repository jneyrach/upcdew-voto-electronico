/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.dao;

import java.util.HashMap;
import java.util.List;
import pe.edu.upc.proyecto.model.Estadistica;
import pe.edu.upc.proyecto.model.Persona;
import pe.edu.upc.proyecto.model.Proceso;

/**
 *
 * @author Administrador
 */
public interface ProcesoDao {

    //public List<Proceso> getProcesosActivos();

    public Proceso getProcesoPorId(String idProceso);

    public Persona getCandidatoDeProceso(String idProceso, String idCandidato);

    public List<Persona> getCandidatosProceso(String procesoId);

    public List<Proceso> getProcesos(int estadoJornada);

    public List<Proceso> getProcesos();

    public void actualizarProceso(String idProceso, int estado);

    public Estadistica getEstadisticas(String idProceso);
}
