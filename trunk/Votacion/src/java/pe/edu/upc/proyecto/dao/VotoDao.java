/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.proyecto.dao;

import pe.edu.upc.proyecto.model.Proceso;
import pe.edu.upc.proyecto.model.Voto;

/**
 *
 * @author Administrador
 */
public class VotoDao {


    public VotoDao(){

    }

    public Voto getVotoPorUsuario(Proceso proceso, String usuario){
        for (Voto voto : proceso.getVotos()) {
            if(voto.getElector().getUsuario().getUsuario().equals(usuario)){
                return voto;
            }
        }
        return null;
    }

    public Voto getVotoPorProcesoElector(Proceso proceso, String idElector){
        for (Voto voto : proceso.getVotos()) {
            if(voto.getElector().getIdPersona().equals(idElector)){
                return voto;
            }
        }
        return null;
    }

}
