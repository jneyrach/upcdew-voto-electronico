<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Time Manager</title>
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
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
        </div>


        <div id="bodybottomPan">&nbsp;</div>

        <div style="margin-bottom:10px;">
        <table width="100%" border="0">
                <tr>
                    <td>
                        <c:if test="${candidato!=null}">
                                        <div id="toplinkPan">
                            <div id="toplinkfastPan">
                                <p>
                                    Candidato seleccinado
                                    <br/><br/><br/>
                                    ${candidato.nombreCompleto}
                                </p>
                                <a href="#">&nbsp;</a>
                            </div>

                                <div id="toplinksecondPan" class="tpl">
                                    <a href="" id="${candidato.idPersona}"></a>
                                    <img src="fotos/${candidato.idPersona}.jpg" width="119" height="140" border="0" />
                                </div>
                        </div>
                </c:if>
                <c:if test="${candidato==null}">
                                         <div id="toplinkPan">
                            <div id="toplinkfastPan">
                                <p>
                                    Candidato seleccinado
                                    <br/><br/><br/>
                                    VOTO EN BLANCO
                                </p>
                                <a href="#">&nbsp;</a>
                            </div>

                                <div id="toplinksecondPan" class="tpl">
                                    <a href="" id="${candidato.idPersona}"></a>
                                    <img src="images/blanco.jpg" width="119" height="140" border="0" />
                                </div>
                        </div>
                </c:if>
   
                    </td>
                </tr>
        </table>
       </div>

          <div id="bodyPan">
            <div style="height:68px;padding-top:20px">
                <table width="100%" border="0">
                <tr>
                    <td align="center"><p class="morenext"><a href="javascript: enviar()">Aceptar</a></p>&nbsp;</td>
                    <td align="center"><p class="morenext"><a href="cedula_votacion.htm?accion=cedulaVotacion">Cambiar</a></p>&nbsp;</td>
                </tr>
            </table>
            </div>
        </div>
        <div id="bodybottomPan">&nbsp;</div>

        <!--BodyPan Close-->
        <!--FooterPan-->

         <form name="confirmacionForm" action="confirmacion.htm">
            <input type="hidden" name="accion" value="confirmar"/>
            <input type="hidden" name="idCandidato" value="${candidato.idPersona}"/>
            <input type="hidden" name="accion" value="confirmar"/>
        </form>

    </body>
</html>
