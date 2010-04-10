/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.proyecto.model;

/**
 *
 * @author Administrador
 */
public class Estadistica {

    String votaron;
    String noVotaron;
    String estanVotando;
    String total;

    public String getEstanVotando() {
        return estanVotando;
    }

    public void setEstanVotando(String estanVotando) {
        this.estanVotando = estanVotando;
    }

    public String getNoVotaron() {
        return noVotaron;
    }

    public void setNoVotaron(String noVotaron) {
        this.noVotaron = noVotaron;
    }

    public String getVotaron() {
        return votaron;
    }

    public void setVotaron(String votaron) {
        this.votaron = votaron;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }



}
