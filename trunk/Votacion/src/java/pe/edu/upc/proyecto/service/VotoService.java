/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.service;

import java.util.List;
import pe.edu.upc.proyecto.model.Resultado;
import pe.edu.upc.proyecto.model.Voto;

/**
 *
 * @author Administrador
 */
public interface VotoService {

    public Voto login(String idProceso, String usuario, String password);

    public void saveVoto(String idProceso, String idElector, String idCandidato);

    public List<Resultado> getResultadosProceso(String idProceso);

    public void actulizarEstadoVoto(String idProceso, String idElector, int estadoVoto);
}
