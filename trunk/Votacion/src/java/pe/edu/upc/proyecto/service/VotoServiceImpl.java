/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.proyecto.service;

import java.util.List;
import pe.edu.upc.proyecto.dao.ProcesoDao;
import pe.edu.upc.proyecto.dao.VotoDao;
import pe.edu.upc.proyecto.model.Proceso;
import pe.edu.upc.proyecto.model.Resultado;
import pe.edu.upc.proyecto.model.Voto;
import pe.edu.upc.proyecto.util.Constantes;

/**
 *
 * @author Jesus Cruz
 */
public class VotoServiceImpl implements VotoService{

    VotoDao votoDao;
    ProcesoDao procesoDao;

    public void setProcesoDao(ProcesoDao procesoDao) {
        this.procesoDao = procesoDao;
    }

    public void setVotoDao(VotoDao votoDao) {
        this.votoDao = votoDao;
    }

    public Voto login(String idProceso, String usuario, String password) {
        Proceso proceso = procesoDao.getProcesoPorId(idProceso);
        if (proceso != null) {
            Voto voto = votoDao.getVotoPorUsuario(proceso, usuario);
            if (voto != null) {
                if (voto.getElector().getUsuario().getPassword().equals(password)) {
                    return voto;
                }
            }
        }
        return null;
    }

    public void saveVoto(String idProceso, String idElector, String idCandidato) {
        int estadoVoto;

        //Si es voto en blanco
        if (idCandidato.equals(""))
            idCandidato = null;

        estadoVoto = Constantes.ELECTOR_VOTO;

        votoDao.saveVoto(idProceso, idElector, idCandidato, estadoVoto);

    }

    public List<Resultado> getResultadosProceso(String idProceso){
        return votoDao.getResultadosProceso(idProceso);
    }

    public void actulizarEstadoVoto(String idProceso, String idElector, int estadoVoto){
        votoDao.actulizarEstadoVoto(idProceso, idElector, estadoVoto);
    }
}
