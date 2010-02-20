/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.service;

import pe.edu.upc.proyecto.dao.ProcesoDao;
import pe.edu.upc.proyecto.dao.VotoDao;
import pe.edu.upc.proyecto.model.Persona;
import pe.edu.upc.proyecto.model.Proceso;
import pe.edu.upc.proyecto.model.Voto;

/**
 *
 * @author Administrador
 */
public class VotoService {

    VotoDao votoDao;
    ProcesoDao procesoDao;

    public VotoService() {
        this.votoDao = new VotoDao();
        this.procesoDao = new ProcesoDao();
    }

    public Persona login(String idProceso, String usuario, String password) {
        Proceso proceso = procesoDao.getProcesoPorId(idProceso);
        if (proceso != null) {
            Voto voto = votoDao.getVotoPorUsuario(proceso, usuario);
            if (voto != null) {
                if (voto.getElector().getUsuario().getPassword().equals(password)) {
                    return voto.getElector();
                }
            }
        }
        return null;
    }

    public void saveVoto(String idProceso, String idElector, String idCandidato) {
        Voto voto;
        Persona candidato;
        Proceso proceso;

        proceso = procesoDao.getProcesoPorId(idProceso);
        candidato = procesoDao.getCandidatoDeProceso(proceso, idCandidato);

        voto = votoDao.getVotoPorProcesoElector(proceso, idElector);
        voto.setCandidato(candidato);

        //Si es voto en blanco
        if (candidato == null) {
            voto.setEstadoVoto(2);
        } else {
            voto.setEstadoVoto(1);
        }

    }
}
