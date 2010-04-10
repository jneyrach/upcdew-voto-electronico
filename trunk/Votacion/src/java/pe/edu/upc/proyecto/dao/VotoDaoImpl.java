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
import pe.edu.upc.proyecto.model.Persona;
import pe.edu.upc.proyecto.model.Proceso;
import pe.edu.upc.proyecto.model.Resultado;
import pe.edu.upc.proyecto.model.Usuario;
import pe.edu.upc.proyecto.model.Voto;
import pe.edu.upc.proyecto.util.ConecctionUtil;

/**
 *
 * @author jcruzm
 */
public class VotoDaoImpl implements VotoDao{

    public Voto getVotoPorUsuario(Proceso proceso, String user){
        Voto voto = null;
        Persona elector = null;
        Usuario usuario = null;
        
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("select * from tb_voto v, tb_persona p, tb_usuario u where v.cod_elector=p.cod_persona and p.cod_persona=u.cod_persona and cod_proceso="+proceso.getIdProceso()+" and cod_elector='"+user+"'");
            while(rs.next()) {
                voto = new Voto();
                elector = new Persona();
                usuario = new Usuario();
                voto.setCandidato(null);
                
                voto.setEstadoVoto(rs.getInt("estado_voto"));
                voto.setProceso(proceso);
                elector.setApellidoPaterno(rs.getString("ape_paterno"));
                elector.setApellidoMaterno(rs.getString("ape_materno"));
                elector.setNombre(rs.getString("nombre"));
                elector.setIdPersona(rs.getString("cod_persona"));

                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("passwod"));
                elector.setUsuario(usuario);
                voto.setElector(elector);
             }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeResultSet(rs);
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
        return voto;
    }

    public void saveVoto(String idProceso, String idElector, String idCandidato, int estadoVoto){
        Connection connection = null;
        Statement st = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            System.out.println("UPDATE tb_voto SET cod_candidato="+ (idCandidato==null?idCandidato:"'"+idCandidato+"'") +" , estado_voto="+ estadoVoto +" WHERE cod_proceso="+ idProceso +" AND cod_elector='"+ idElector +"'");
            st.execute("UPDATE tb_voto SET cod_candidato="+ (idCandidato==null?idCandidato:"'"+idCandidato+"'") +" , estado_voto="+ estadoVoto +" WHERE cod_proceso="+ idProceso +" AND cod_elector='"+ idElector +"'");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
    }

    public List<Resultado> getResultadosProceso(String idProceso){
        List<Resultado> resultados = null;
        Resultado resultado = null;
        Persona candidato = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            //rs = st.executeQuery("select p.*, count(cod_candidato) cantidad_votos from tb_voto v, tb_persona p where v.cod_candidato=p.cod_persona and v.cod_proceso=" + idProceso + " group by cod_candidato");
            rs = st.executeQuery("SELECT p.*, COUNT(v.cod_candidato) cantidad_votos FROM tb_candidato c INNER JOIN tb_persona p ON c.cod_persona=p.cod_persona LEFT JOIN tb_voto v ON c.cod_persona=v.cod_candidato WHERE c.cod_proceso="+idProceso+" GROUP BY p.cod_persona ORDER BY cantidad_votos DESC");

            resultados = new ArrayList<Resultado>();
            while(rs.next()) {
                resultado = new Resultado();
                candidato = new Persona();
                candidato.setIdPersona(rs.getString("cod_persona"));
                candidato.setNombre(rs.getString("nombre"));
                candidato.setApellidoPaterno(rs.getString("ape_paterno"));
                candidato.setApellidoMaterno(rs.getString("ape_materno"));
                resultado.setCandidato(candidato);
                resultado.setCantidadVotos(rs.getInt("cantidad_votos"));
                resultados.add(resultado);
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeResultSet(rs);
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
        return resultados;
    }

    public void actulizarEstadoVoto(String idProceso, String idElector, int estadoVoto) {
        Connection connection = null;
        Statement st = null;
        try {
            connection = ConecctionUtil.getConnection();
            st = connection.createStatement();
            st.execute("UPDATE tb_voto SET estado_voto="+estadoVoto+" WHERE cod_proceso="+ idProceso +" AND cod_elector='"+ idElector +"'");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConecctionUtil.closeStatement(st);
            ConecctionUtil.closeConnection(connection);
        }
    }

}
