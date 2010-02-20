package pe.edu.upc.proyecto.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.proyecto.model.Persona;
import pe.edu.upc.proyecto.model.Proceso;
import pe.edu.upc.proyecto.service.ProcesoService;
import pe.edu.upc.proyecto.service.VotoService;

public class VotacionServlet extends HttpServlet {

    private ProcesoService procesoService;
    private VotoService votoService;

    public VotacionServlet() {
        this.procesoService = new ProcesoService();
        this.votoService = new VotoService();

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion.equals("elegirProceso")) {
            elegirProceso(req, resp);
        } else if (accion.equals("loginVotacion")) {
            loginVotacion(req, resp);
        } else if (accion.equals("logueoVotacion")) {
            logueoVotacion(req, resp);
        } else if (accion.equals("cedulaVotacion")) {
            cedulaVotacion(req, resp);
        } else if (accion.equals("votar")) {
            votar(req, resp);
        } else if (accion.equals("confirmar")) {
            confirmar(req, resp);
        }
    }

    public void elegirProceso(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Proceso> procesos = procesoService.getProcesosActivos();
        req.setAttribute("procesos", procesos);
        req.getRequestDispatcher("procesos.jsp").forward(req, resp);
    }

    public void loginVotacion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProceso;
        Proceso proceso;

        idProceso = req.getParameter("idProceso");
        proceso = procesoService.getProcesoPorId(idProceso);

        req.getSession().setAttribute("procesoTitulo", proceso.getNombre());
        req.getSession().setAttribute("idProceso", proceso.getIdProceso());

        //req.setAttribute("proceso", proceso);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    public void logueoVotacion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProceso, usuario, password;
        Persona elector;

        idProceso = req.getParameter("idProceso");
        usuario = req.getParameter("usuario");
        password = req.getParameter("password");

        elector = votoService.login(idProceso, usuario, password);
        if (elector != null) {
            req.getSession().setAttribute("idElector", elector.getIdPersona());
            req.getRequestDispatcher("condiciones_uso.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

    public void cedulaVotacion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProceso = (String) req.getSession().getAttribute("idProceso");

        Proceso proceso = procesoService.getProcesoPorId(idProceso);

        if (proceso != null) {
            req.setAttribute("candidatos", proceso.getCandidatos());
            req.getRequestDispatcher("cedula_votacion.jsp").forward(req, resp);
        } else {
        }
    }

    public void votar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProceso, idCandidato;

        idProceso = (String) req.getSession().getAttribute("idProceso");
        idCandidato = req.getParameter("idCandidato");

        Persona candidato = procesoService.getCandidatoDeProceso(idProceso, idCandidato);
        req.setAttribute("candidato", candidato);
        req.getRequestDispatcher("confirmacion.jsp").forward(req, resp);
    }

    public void confirmar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProceso, idElector, idCandidato;

        idProceso = (String) req.getSession().getAttribute("idProceso");
        idElector = (String) req.getSession().getAttribute("idElector");
        idCandidato = req.getParameter("idCandidato");

        votoService.saveVoto(idProceso, idElector, idCandidato);
        req.getRequestDispatcher("respuesta.jsp").forward(req, resp);
    }
}
