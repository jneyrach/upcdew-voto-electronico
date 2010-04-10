package pe.edu.upc.proyecto.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import pe.edu.upc.proyecto.model.Persona;
import pe.edu.upc.proyecto.model.Proceso;
import pe.edu.upc.proyecto.model.Resultado;
import pe.edu.upc.proyecto.model.Voto;
import pe.edu.upc.proyecto.service.ProcesoService;
import pe.edu.upc.proyecto.service.VotoService;
import pe.edu.upc.proyecto.util.Constantes;

public class VotoController implements Controller {

    private ProcesoService procesoService;
    private VotoService votoService;

    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String accion = req.getParameter("accion");
        System.out.println("accion: " + accion);
        ModelAndView miModelAndView = new ModelAndView();
        if (accion.equals("elegirProceso")) {
            miModelAndView = elegirProceso(req, resp);
        } else if (accion.equals("loginVotacion")) {
            miModelAndView = loginVotacion(req, resp);
        } else if (accion.equals("logueoVotacion")) {
            miModelAndView = logueoVotacion(req, resp);
        } else if (accion.equals("cedulaVotacion")) {
            miModelAndView = cedulaVotacion(req, resp);
        } else if (accion.equals("votar")) {
            miModelAndView = votar(req, resp);
        } else if (accion.equals("confirmar")) {
            miModelAndView = confirmar(req, resp);
        } else if (accion.equals("resultadoProceso")) {
            miModelAndView = resultadoProceso(req, resp);
        } else if (accion.equals("listaResultado")) {
            miModelAndView = listaResultado(req, resp);
        }
        return miModelAndView;
    }

    public ModelAndView elegirProceso(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Proceso> procesos = procesoService.getProcesos(Constantes.PROCESO_INICIADO);
        req.setAttribute("procesos", procesos);
        return new ModelAndView("procesos", "procesos", procesos);
    }

    public ModelAndView loginVotacion(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String idProceso;
        Proceso proceso;

        idProceso = req.getParameter("idProceso");
        proceso = procesoService.getProcesoPorId(idProceso);

        req.getSession().setAttribute("procesoTitulo", proceso.getNombre());
        req.getSession().setAttribute("idProceso", proceso.getIdProceso());

        //req.getRequestDispatcher("login.jsp").forward(req, resp);

        return new ModelAndView("login", "login", proceso);
    }

    public ModelAndView logueoVotacion(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String idProceso, usuario, password;
        Persona elector;
        Voto voto;

        idProceso = req.getParameter("idProceso");
        usuario = req.getParameter("usuario");
        password = req.getParameter("password");

        voto = votoService.login(idProceso, usuario, password);

        if (voto != null) {
            if (voto.getEstadoVoto() == Constantes.ELECTOR_NO_VOTO) {
                elector = voto.getElector();
                if (elector != null) {
                    votoService.actulizarEstadoVoto(idProceso, elector.getIdPersona(), Constantes.ELECTOR_VOTANDO);
                    req.getSession().setAttribute("idElector", elector.getIdPersona());
                    //req.getRequestDispatcher("condiciones_uso.jsp").forward(req, resp);
                    return new ModelAndView("condiciones_uso", "idElector", elector.getIdPersona());
                }
            } else {
                //req.setAttribute("msg", "El usuario: " + voto.getElector().getIdPersona() + " ya realizó su voto");
                //req.getRequestDispatcher("login.jsp").forward(req, resp);
                return new ModelAndView("login", "msg", "El usuario: " + voto.getElector().getIdPersona() + " ya realizó su voto");
            }
        } else {
            //req.setAttribute("msg", "El usuario o el password no coinciden");
            //req.getRequestDispatcher("login.jsp").forward(req, resp);
            return new ModelAndView("login", "msg", "El usuario o el password no coinciden");
        }
        return new ModelAndView("login", "clientes", null);

    }

    public ModelAndView cedulaVotacion(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String idProceso = (String) req.getSession().getAttribute("idProceso");

        Proceso proceso = procesoService.getProcesoPorId(idProceso);

        if (proceso != null) {
            //req.setAttribute("candidatos", proceso.getCandidatos());
            //req.getRequestDispatcher("cedula_votacion.jsp").forward(req, resp);
            return new ModelAndView("cedula_votacion", "candidatos", procesoService.getCandidatosProceso(idProceso));
        } else {
            return new ModelAndView("cedula_votacion", "candidatos", null);
        }
    }

    public ModelAndView votar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String idProceso, idCandidato, hora;

        idProceso = (String) req.getSession().getAttribute("idProceso");
        idCandidato = req.getParameter("idCandidato");
        hora = req.getParameter("hora");

        Persona candidato = procesoService.getCandidatoDeProceso(idProceso, idCandidato);
        return new ModelAndView("confirmacion", "candidato", candidato);
    }

    public ModelAndView confirmar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String idProceso, idElector, idCandidato;

        idProceso = (String) req.getSession().getAttribute("idProceso");
        idElector = (String) req.getSession().getAttribute("idElector");
        idCandidato = req.getParameter("idCandidato");

        votoService.saveVoto(idProceso, idElector, idCandidato);

        return new ModelAndView("respuesta", "msg", "Ha realizado su voto de manera satisfactoria. Los resultados podran ser vistos por este mismo medio.");
    }

    private ModelAndView resultadoProceso(HttpServletRequest req, HttpServletResponse resp) {
        List<Proceso> procesos = procesoService.getProcesos(Constantes.PROCESO_CERRADO);
        req.setAttribute("procesos", procesos);
        return new ModelAndView("resultado_procesos", "procesos", procesos);
    }

    private ModelAndView listaResultado(HttpServletRequest req, HttpServletResponse resp) {
        String idProceso = req.getParameter("idProceso");

        Proceso proceso = procesoService.getProcesoPorId(idProceso);
        List<Resultado> resultados = votoService.getResultadosProceso(idProceso);
        Resultado ganador = resultados.get(0);

        req.getSession().setAttribute("procesoTitulo", proceso.getNombre());
        req.getSession().setAttribute("idProceso", proceso.getIdProceso());
        if (proceso != null) {
            req.setAttribute("ganador", ganador);
            return new ModelAndView("lista_ganadores", "candidatos", resultados);
        } else {
            return new ModelAndView("lista_ganadores", "candidatos", null);
        }
    }

    public void setVotoService(VotoService votoService) {
        this.votoService = votoService;
    }

    public void setProcesoService(ProcesoService procesoService) {
        this.procesoService = procesoService;
    }
}
