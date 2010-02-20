<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Time Manager</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
            function enviar(){
                document.confirmacionForm.submit();
            }
        </script>
    </head>

    <body>
        <!--TopPan-->
        <div id="topPan">
            <h1>${procesoTitulo}</h1>
        </div>
        <!--TopPan Close-->
        <!--BodyPan-->
        <div id="bodyPan">
            <h1><span>Confirma tu voto</span></h1>
            <p class="bigtext">Para confirmar haga clic en Aceptar: Por el contrario, si desea seleccionar otro candidato haga clic en Cambiar.</p>
            <br/>
            <p>Candidato seleccionado:</p>
            <br/>
            <table width="100%" border="0">
                <c:if test="${candidato!=null}">
                    <tr>
                        <td width="65%"><p><br/></p>
                            <p>${candidato.idPersona}<br/><br/>${candidato.nombreCompleto}</p></td>
                        <td width="35%"><img src="fotos/${candidato.idPersona}.jpg" width="119" height="140" /></td>
                    </tr>
                </c:if>
                <c:if test="${candidato==null}">
                    <tr>
                        <td width="100%" align="center" ><b>Voto en Blanco</b></td>
                    </tr>
                </c:if>
            </table>
            <br/>
            <br/>
            <table width="100%" border="0">
                <tr>
                    <td align="center"><p class="morenext"><a href="javascript: enviar()">Aceptar</a></p>&nbsp;</td>
                    <td align="center"><p class="morenext"><a href="VotacionServlet?accion=cedulaVotacion">Cambiar</a></p>&nbsp;</td>
                </tr>
            </table>
        </div>

        <form name="confirmacionForm" action="VotacionServlet">
            <input type="hidden" name="accion" value="confirmar"/>
            <input type="hidden" name="idCandidato" value="${candidato.idPersona}"/>
        </form>

        <div id="bodybottomPan">&nbsp;</div>
        <!--BodyPan Close-->
        <!--FooterPan-->
    </body>
</html>
