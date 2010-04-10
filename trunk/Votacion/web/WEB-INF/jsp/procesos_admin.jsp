<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Time Manager</title>
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <!--TopPan-->
        <div id="topPan">
            <h1>Administracion<br><br>Voto Electr&oacute;nico</h1>
        </div>
        <form id ="procesoForm" action="admin.htm" method="post">
            <input type="hidden" name="idProceso" value=""/>
            <input type="hidden" name="accion" value=""/>
            <!--TopPan Close-->
            <!--BodyPan-->
            <div id="bodyPan">
                <h1><span>Bienvenido</span></h1>
                <p class="bigtext">Elija el proceso electoral.</p>
                <table>
                    <tr>
                        <td><p class="bigtext">Proceso</p></td>
                        <td><p class="bigtext">Estado</p></td>
                    </tr>
                    <c:forEach var="proceso" items="${procesos}">
                    <tr>
                        <td><a href="javascript:this.enviar('${proceso.idProceso}', '${proceso.estadoJornada}');">${proceso.nombre}</a></td>
                        <c:if test="${proceso.estadoJornada==0}">
                            <td><p class="smalltext">No Iniciado</p></td>
                        </c:if>
                        <c:if test="${proceso.estadoJornada==1}">
                            <td><p class="smalltext">Iniciado</p></td>
                        </c:if>
                        <c:if test="${proceso.estadoJornada==2}">
                            <td><p class="smalltext">Cerrado</p></td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="bodybottomPan">&nbsp;</div>
            <!--BodyPan Close-->
            <!--FooterPan-->
        </form>
    </body>
</html>

<script type="text/javascript">
    function enviar(idProceso){
        var form = document.getElementById('procesoForm');
        form.idProceso.value = idProceso;
        form.accion.value = 'procesoVotacion';
        form.submit();
    }
</script>
