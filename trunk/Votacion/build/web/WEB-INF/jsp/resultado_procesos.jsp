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
            <h1>Voto Electr&oacute;nico</h1>
        </div>
        <form id ="procesoForm" action="resultados.htm" method="post">
            <input type="hidden" name="idProceso" value=""/>
            <input type="hidden" name="accion" value=""/>
            <!--TopPan Close-->
            <!--BodyPan-->
           <div id="topPan1" style="height:30px;padding-left:15px;">
	<ul>
		<li class="menupadding"><a href="proceso.htm?accion=elegirProceso">Votacion</a></li>
		<li class="home">Resultados</li>
	</ul>
           </div>
            <div id="bodyPan">
                <h1><span>Resultados Electorales</span></h1>
                <p class="bigtext">Elija el proceso electoral.</p>
                <ul>
                    <c:forEach var="proceso" items="${procesos}">
                            <!--<li><a href="VotacionServlet?accion=loginVotacion&idProceso=${proceso.idProceso}">${proceso.nombre}</a></li>-->
                        <li><a href="javascript:this.enviar('${proceso.idProceso}', '${proceso.estadoJornada}');">${proceso.nombre}</a></li>

                    </c:forEach>
                </ul>
            </div>
            <div id="bodybottomPan">&nbsp;</div>
            <!--BodyPan Close-->
            <!--FooterPan-->
        </form>
    </body>
</html>

<script type="text/javascript">
    function enviar(idProceso, estadoJornada){
        if(parseInt(estadoJornada) == 0){
            alert('El proceso electoral aun no esta iniciado');
        }else if(parseInt(estadoJornada) == 2){
            var form = document.getElementById('procesoForm');
            form.idProceso.value = idProceso;
            form.accion.value = 'listaResultado';
            form.submit();
        }else{
            alert('El proceso electoral esta cerrado');
        }

    }
</script>
