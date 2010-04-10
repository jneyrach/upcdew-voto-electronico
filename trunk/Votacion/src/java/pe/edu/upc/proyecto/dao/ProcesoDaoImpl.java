/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.proyecto.model.Estadistica;
import pe.edu.upc.proyecto.model.ModeloDominio;
import pe.edu.upc.proyecto.model.Persona;
import pe.edu.upc.proyecto.model.Proceso;
import pe.edu.upc.proyecto.util.ConecctionUtil;

/**
 * Clase que interactua con la base de datos
 * @author Jesus Cruz
 */
public class ProcesoDaoImpl implements ProcesoDao {

    ModeloDominio modelo;
    List<Proceso> procesos;

    public ProcesoDaoImpl() {
        modelo = new ModeloDominio();
        procesos = modelo.getProcesos();
    }

    public List<Proceso> getProcesosActivos() {
        return procesos;
    }

    /**
     * Metodo que realiza la busqueda de un Proceso de acuerdo a la variable de entrada
     * @parameter idProceso codigo del proceso
     * @return Proceso Objeto a retornar
     */
    public Proceso getProcesoPorId(String idProceso) {
        Proceso proceso = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("select * from tb_proceso p where p.cod_proceso=" + idProceso);
            while (rs.next()) {
                proceso = new Proceso();
                proceso.setIdProceso(rs.getString("cod_proceso"));
                proceso.setNombre(rs.getString("nombre"));
                proceso.setEstadoJornada(rs.getInt("estado_jornada"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeResultSet(rs);
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
        return proceso;

    }

    /**
     * Metodo que realiza la busqueda de un Candidato de acuerdo a los parametros de entrada
     * @parameter idProceso codigo del proceso
     * @parameter idCandidato codigo del candidato
     * @return Persona Objeto a retornar
     */
    public Persona getCandidatoDeProceso(String idProceso, String idCandidato) {
        Persona persona = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT p.* FROM tb_candidato c, tb_persona p WHERE c.cod_persona=p.cod_persona AND c.cod_proceso=" + idProceso + " AND c.cod_persona='" + idCandidato + "'");
            while (rs.next()) {
                persona = new Persona();
                persona.setIdPersona(rs.getString("cod_persona"));
                persona.setApellidoPaterno(rs.getString("ape_paterno"));
                persona.setApellidoMaterno(rs.getString("ape_materno"));
                persona.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeResultSet(rs);
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
        return persona;
    }

    /**
     * Metodo que realiza la busqueda de los procesos de acuerdo al estado
     * @parameter estadoJornada estado del proceso electoral
     * @return Lista_Proceso lista de procesos
     */
    public List<Proceso> getProcesos(int estadoJornada) {
        List<Proceso> procesos = null;
        Proceso proceso = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("select * from tb_proceso p where p.estado_jornada=" + estadoJornada);
            procesos = new ArrayList<Proceso>();
            while (rs.next()) {
                proceso = new Proceso();
                proceso.setIdProceso(rs.getString("cod_proceso"));
                proceso.setNombre(rs.getString("nombre"));
                proceso.setEstadoJornada(rs.getInt("estado_jornada"));
                procesos.add(proceso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeResultSet(rs);
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
        return procesos;
    }

    public List<Persona> getCandidatosProceso(String procesoId) {
        List<Persona> candidatos = null;
        Persona candidato = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("select p.* from tb_candidato c, tb_persona p where c.cod_persona=p.cod_persona and c.cod_proceso=" + procesoId);
            candidatos = new ArrayList<Persona>();
            while (rs.next()) {
                candidato = new Persona();
                candidato.setIdPersona(rs.getString("cod_persona"));
                candidato.setApellidoPaterno(rs.getString("ape_paterno"));
                candidato.setApellidoMaterno(rs.getString("ape_materno"));
                candidato.setNombre(rs.getString("nombre"));
                candidatos.add(candidato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeResultSet(rs);
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
        return candidatos;
    }

    public List<Proceso> getProcesos() {
        List<Proceso> procesos = null;
        Proceso proceso = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("select * from tb_proceso p");
            procesos = new ArrayList<Proceso>();
            while (rs.next()) {
                proceso = new Proceso();
                proceso.setIdProceso(rs.getString("cod_proceso"));
                proceso.setNombre(rs.getString("nombre"));
                proceso.setEstadoJornada(rs.getInt("estado_jornada"));
                procesos.add(proceso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeResultSet(rs);
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
        return procesos;
    }

    public void actualizarProceso(String idProceso, int estado) {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            st.executeUpdate("update tb_proceso set estado_jornada =" + estado + " where cod_proceso =" + idProceso);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeResultSet(rs);
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
    }

    public Estadistica getEstadisticas(String idProceso) {
        Estadistica estadisticas = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT  CASE WHEN 1 THEN (SELECT COUNT(estado_voto) FROM tb_voto WHERE cod_proceso=1) END 'TOTAL', CASE WHEN 2 THEN (SELECT COUNT(estado_voto) FROM tb_voto WHERE cod_proceso=1 AND estado_voto='0') ELSE 0 END 'NOVOTARON', CASE WHEN 3 THEN (SELECT COUNT(estado_voto) FROM tb_voto WHERE cod_proceso=1 AND estado_voto='1') ELSE 0 END 'VOTARON', CASE WHEN 4 THEN (SELECT COUNT(estado_voto) FROM tb_voto WHERE cod_proceso=1 AND estado_voto='2') ELSE 0 END 'VOTANDO';");
            procesos = new ArrayList<Proceso>();
            while (rs.next()) {
                estadisticas = new Estadistica();
                estadisticas.setVotaron(rs.getString("VOTARON"));
                estadisticas.setNoVotaron(rs.getString("NOVOTARON"));
                estadisticas.setEstanVotando(rs.getString("VOTANDO"));
                estadisticas.setTotal(rs.getString("TOTAL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeResultSet(rs);
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
        return estadisticas;
    }
}
