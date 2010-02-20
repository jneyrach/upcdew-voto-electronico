/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.proyecto.model;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.proyecto.util.Constantes;

/**
 *
 * @author Administrador
 */
public class ModeloDominio {

    Proceso proceso1, proceso2;
    List<Proceso> procesos;
    Persona elector1, elector2, elector3, elector4, elector5, elector6;
    Usuario usuario1, usuario2, usuario3, usuario4, usuario5, usuario6;
    List<Persona> electores;
    Persona candidato1, candidato2, candidato3, candidato4;
    Voto votoaux, voto1, voto2;
    List<Voto> votos;

    public ModeloDominio() {

        proceso1 = new Proceso();
        proceso1.setIdProceso("1");
        proceso1.setNombre("Elección del Delegado de Base de Datos");
        proceso1.setEstadoJornada(Constantes.PROCESO_INICIADO);


        proceso2 = new Proceso();
        proceso2.setIdProceso("2");
        proceso2.setNombre("Elección del Delegado de Calculo");
        proceso2.setEstadoJornada(Constantes.PROCESO_NO_INICIADO);

        procesos = new ArrayList();
        procesos.add(proceso1);
        procesos.add(proceso2);

        elector1 = new Persona();
        elector1.setIdPersona("u920962");
        elector1.setApellidoPaterno("LEIVA");
        elector1.setApellidoMaterno("GUERRA");
        elector1.setNombre("RAFAEL RICARDO");

        usuario1 = new Usuario();
        usuario1.setUsuario("u920962");
        usuario1.setPassword("u920962");

        elector1.setUsuario(usuario1);

        elector2 = new Persona();
        elector2.setIdPersona("u921123");
        elector2.setApellidoPaterno("VILLANES");
        elector2.setApellidoMaterno("CORRALES");
        elector2.setNombre("JOSE IVAN");

        usuario2 = new Usuario();
        usuario2.setUsuario("u921123");
        usuario2.setPassword("u921123");

        elector2.setUsuario(usuario2);

        elector3 = new Persona();
        elector3.setIdPersona("u921212");
        elector3.setApellidoPaterno("CRUZ");
        elector3.setApellidoMaterno("MONROY");
        elector3.setNombre("JESUS ROBINSON");

        usuario3 = new Usuario();
        usuario3.setUsuario("u921212");
        usuario3.setPassword("u921212");

        elector3.setUsuario(usuario3);

        elector4 = new Persona();
        elector4.setIdPersona("u920942");
        elector4.setApellidoPaterno("FLORES");
        elector4.setApellidoMaterno("ESPINOZA");
        elector4.setNombre("DENISSE JENNYFER");

        usuario4 = new Usuario();
        usuario4.setUsuario("u920942");
        usuario4.setPassword("u920942");

        elector4.setUsuario(usuario4);

        elector5 = new Persona();
        elector5.setIdPersona("u920900");
        elector5.setApellidoPaterno("MILLONES");
        elector5.setApellidoMaterno("QUIROZ");
        elector5.setNombre("ALVARO");

        usuario5 = new Usuario();
        usuario5.setUsuario("u920900");
        usuario5.setPassword("u920900");

        elector5.setUsuario(usuario5);

        elector6 = new Persona();
        elector6.setIdPersona("u921134");
        elector6.setApellidoPaterno("VILLAFUERTE");
        elector6.setApellidoMaterno("NUÑEZ");
        elector6.setNombre("MIGUEL ANGEL");

        usuario6 = new Usuario();
        usuario6.setUsuario("u921134");
        usuario6.setPassword("u921134");

        elector6.setUsuario(usuario6);

        electores = new ArrayList<Persona>();
        electores.add(elector1);
        electores.add(elector2);
        electores.add(elector3);
        electores.add(elector4);
        electores.add(elector5);
        electores.add(elector6);

        candidato1 = new Persona();
        candidato1.setIdPersona("u913694");
        candidato1.setApellidoPaterno("ZUÑIGA");
        candidato1.setApellidoMaterno("RODRIGUEZ");
        candidato1.setNombre("CARLOS MOISES");

        candidato2 = new Persona();
        candidato2.setIdPersona("u920858");
        candidato2.setApellidoPaterno("GAVILAN");
        candidato2.setApellidoMaterno("REYNOSO");
        candidato2.setNombre("JOEL FELIX");

        candidato3 = new Persona();
        candidato3.setIdPersona("u921134");
        candidato3.setApellidoPaterno("VILLAFUERTE");
        candidato3.setApellidoMaterno("NUÑEZ");
        candidato3.setNombre("MIGUEL ANGEL");

        candidato4 = new Persona();
        candidato4.setIdPersona("u920900");
        candidato4.setApellidoPaterno("MILLONES");
        candidato4.setApellidoMaterno("QUIROZ");
        candidato4.setNombre("ALVARO");

        proceso1.getCandidatos().add(candidato1);
        proceso1.getCandidatos().add(candidato2);
        proceso1.getCandidatos().add(candidato3);
        proceso1.getCandidatos().add(candidato4);

        /*voto1 = new Voto();
        voto1.setElector(elector1);
        voto1.setProceso(proceso1);
        voto1.setEstadoVoto(0);

        voto2 = new Voto();
        voto2.setElector(elector2);
        voto2.setProceso(proceso1);
        voto2.setEstadoVoto(0);
         */
        for (Persona elector : electores) {
            votoaux = new Voto();
            votoaux.setElector(elector);
            votoaux.setProceso(proceso1);
            votoaux.setEstadoVoto(0);

            proceso1.getVotos().add(votoaux);
        }
        /*
        proceso1.getVotos().add(voto1);
        proceso1.getVotos().add(voto2);
         */
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
}
