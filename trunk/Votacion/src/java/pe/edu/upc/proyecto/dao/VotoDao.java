/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.dao;

import java.util.List;
import pe.edu.upc.proyecto.model.Proceso;
import pe.edu.upc.proyecto.model.Resultado;
import pe.edu.upc.proyecto.model.Voto;

/**
 *
 * @author Administrador
 */
public interface VotoDao {

    public Voto getVotoPorUsuario(Proceso proceso, String usuario);

    public void saveVoto(String idProceso, String idElector, String idCandidato, int estadoVoto);

    public List<Resultado> getResultadosProceso(String idProceso);

    public void actulizarEstadoVoto(String idProceso, String idElector, int estadoVoto);
}
