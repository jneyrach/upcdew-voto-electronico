package pe.edu.upc.proyecto.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import pe.edu.upc.proyecto.model.Estadistica;
import pe.edu.upc.proyecto.model.Proceso;
import pe.edu.upc.proyecto.service.ProcesoService;
import pe.edu.upc.proyecto.service.VotoService;
import pe.edu.upc.proyecto.util.Constantes;

/**
 * Clase controladora que se encargara de la administracion del proceso electoral
 * @user Rafael Leiva
*/
public class AdminController implements Controller {

    private ProcesoService procesoService;
    private VotoService votoService;

    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String accion = req.getParameter("accion");
        System.out.println("accion: " + accion);
        ModelAndView miModelAndView = new ModelAndView();
        if (accion.equals("elegirProceso")) {
            miModelAndView = elegirProceso(req, resp);
        } else if (accion.equals("logueoAdmin")) {
            miModelAndView = logueoAdmin(req, resp);
        }else if (accion.equals("resultadoProceso")) {
            miModelAndView = resultadoProceso(req, resp);
        } else if (accion.equals("listaResultado")) {
            miModelAndView = listaResultado(req, resp);
        } else if (accion.equals("irLogin")) {
            miModelAndView = irLogin(req, resp);
        } else if (accion.equals("procesoVotacion")) {
            miModelAndView = procesoVotacion(req, resp);
        } else if (accion.equals("actualizarProceso")) {
            miModelAndView = actualizarProceso(req, resp);
        } else if (accion.equals("consultarEstadisticas")) {
            consultarEstadisticas(req, resp);
            return null;
        }
        return miModelAndView;
    }

    /**
     * Metodo que realiza la redireccion a la pantalla en el cual se listan todos los procesos electorales a administrar
     * @return la lista de procesos todos los procesos electorales
    */
    public ModelAndView elegirProceso(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Proceso> procesos = procesoService.getProcesos();
        req.setAttribute("procesos", procesos);
        return new ModelAndView("procesos_admin", "procesos", procesos);
    }

    /**
     * Metodo que redirecciona a la interfaz de login
     * @return la interfaz login
    */
    public ModelAndView irLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return new ModelAndView("login_adm");
    }

    public ModelAndView logueoAdmin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String usuario, password;

        return elegirProceso(req, resp);
    }

    private ModelAndView resultadoProceso(HttpServletRequest req, HttpServletResponse resp) {
        List<Proceso> procesos = procesoService.getProcesos(Constantes.PROCESO_CERRADO);
        req.setAttribute("procesos", procesos);
        return new ModelAndView("resultado_procesos", "procesos", procesos);
    }

    private ModelAndView listaResultado(HttpServletRequest req, HttpServletResponse resp) {
        String idProceso = req.getParameter("idProceso");

        Proceso proceso = procesoService.getProcesoPorId(idProceso);
        req.getSession().setAttribute("procesoTitulo", proceso.getNombre());
        req.getSession().setAttribute("idProceso", proceso.getIdProceso());
        if (proceso != null) {
            return new ModelAndView("lista_ganadores", "candidatos", votoService.getResultadosProceso(idProceso));
        } else {
            return new ModelAndView("lista_ganadores", "candidatos", null);
        }
    }

    private ModelAndView procesoVotacion(HttpServletRequest req, HttpServletResponse resp) {
        String idProceso;
        Proceso proceso;
        

        idProceso = req.getParameter("idProceso");
        proceso = procesoService.getProcesoPorId(idProceso);

        req.getSession().setAttribute("procesoTitulo", proceso.getNombre());
        req.getSession().setAttribute("idProceso", proceso.getIdProceso());
      
        return new ModelAndView("primera_vuelta", "proceso", proceso);
    }

    public void consultarEstadisticas(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Estadistica estadisticas;
        String idProceso = req.getParameter("idProceso");
        estadisticas = procesoService.getEstadisticas(idProceso);
        resp.getWriter().write(estadisticas.getTotal()+","+estadisticas.getVotaron()+","+estadisticas.getNoVotaron()+","+estadisticas.getEstanVotando());
    }

    private ModelAndView actualizarProceso(HttpServletRequest req, HttpServletResponse resp) {
        String idProceso;
        String desEstado;
        Proceso proceso;
        int estado = -1;

        idProceso = req.getParameter("idProceso");
        desEstado = req.getParameter("estado");

        if (desEstado.equals("iniciar")) {
            estado = 1;
        } else if (desEstado.equals("cerrar")) {
            estado = 2;
        }
        System.out.println("idProceso: " + idProceso);
        System.out.println("estado: " + estado);
        procesoService.actualizarProceso(idProceso, estado);
        proceso = procesoService.getProcesoPorId(idProceso);
        req.getSession().setAttribute("procesoTitulo", proceso.getNombre());
        req.getSession().setAttribute("idProceso", proceso.getIdProceso());
        return new ModelAndView("primera_vuelta", "proceso", proceso);
    }

    public void setVotoService(VotoService votoService) {
        this.votoService = votoService;
    }

    public void setProcesoService(ProcesoService procesoService) {
        this.procesoService = procesoService;
    }
}
