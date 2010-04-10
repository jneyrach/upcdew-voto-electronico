<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Time Manager</title>
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/thickbox.css" type="text/css" media="screen" />

        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/thickbox.js"></script>
        <script type="text/javascript">
            function consultarEstadisticas(idProceso){
                $.ajax({
                        type: "POST",
                        url: "admin.htm",
                        data: "accion=consultarEstadisticas&idProceso="+idProceso,
                        success: function(datos){
                            var dat = datos.split(",");
                            $("#tot").text(dat[0]);
                            $("#vot").text(dat[1]);
                            $("#novot").text(dat[2]);
                            $("#votn").text(dat[3]);
                            $("#cant").text(dat[3]);
                            if(dat[3]!=0){
                                $("#acierre").attr("href","#TB_inline?height=155&width=300&inlineId=nocerrar&modal=true");
                            }else{
                                $("#acierre").attr("href","#TB_inline?height=155&width=300&inlineId=cerrar&modal=true");
                            }
                        }
                });
                setTimeout("consultarEstadisticas("+ idProceso +")",2000);
            }

        </script>
    </head>

    <body>
        <!--TopPan-->
        <div id="topPan">
            <h1>Administracion<br/><br/>${procesoTitulo}</h1>
        </div>
        <!--TopPan Close-->
        <!--BodyPan-->

        <div id="bodyPan">
            <h1><span>
                    <c:if test="${proceso.estadoJornada==0}">
                        Estado : No Iniciado
                    </c:if>
                    <c:if test="${proceso.estadoJornada==1}">
                        Estado : Iniciado
                    </c:if>
                    <c:if test="${proceso.estadoJornada==2}">
                        Estado : Cerrado
                    </c:if>
                </span></h1>

            <p class="bigtext">Elija una opción.</p>

            <table summary="Employee Pay Sheet" id="hor-minimalist-b">
                    <thead>
                        <tr>
                            <td scope="col">Total Electores</td>
                            <th><span id="tot"></span></th>
                        </tr>
                        <tr>
                            <td scope="col" >Votaron</td>
                            <th><span id="vot"></span></th>
                        </tr>
                        <tr>
                            <td scope="col">Faltan</td>
                            <th><span id="novot"></span></th>
                        </tr>
                        <tr>
                            <td scope="col">Votando</td>
                            <th><span id="votn"></span></th>
                        </tr>
                    </thead>
                    
                </table>

           
            <br/>
            <c:if test="${proceso.estadoJornada==0}">
                <p class="morenext"><a href="#TB_inline?height=155&width=300&inlineId=iniciar&modal=true"  class="thickbox">INICIAR</a></p>
            </c:if>
            <c:if test="${proceso.estadoJornada==1}">
                <p class="morenext"><a id="acierre" href="" class="thickbox">CERRAR</a></p>
            </c:if>


            <div id="iniciar" style="display:none">
                <p style="text-align: center;margin-top:50px;">
                    <b>¿Est&aacute; seguro de iniciar la votaci&oacute;n?</b>
                </p>
                <p style="text-align: center;">
                    <input type="button" onclick="tb_remove(); enviar('${proceso.idProceso}','iniciar');" value="Si" id=""/>
                    <input type="button" onclick="tb_remove()" value="No" id=""/>
                </p>
            </div>

            <div id="cerrar" style="display:none">
                <p style="text-align: center;margin-top:50px;">
                    <b>¿Est&aacute; seguro de cerrar la votaci&oacute;n?</b>
                </p>
                <p style="text-align: center;">
                    <input type="button" onclick="tb_remove(); enviar('${proceso.idProceso}','cerrar');" value="Si" id=""/>
                    <input type="button" onclick="tb_remove()" value="No" id=""/>
                </p>
            </div>

            <div id="nocerrar" style="display:none">
                <p style="text-align: center;margin-top:50px;">
                    <b>No puede realizar el cierre de la votación porque hay <b><span id="cant"></span></b> usuario(s) realizando su voto.</b>
                </p>
                <p style="text-align: center;">
                    <input type="button" onclick="tb_remove()" value="Cancelar" id=""/>
                </p>
            </div>

        </div>
        <div id="bodybottomPan">&nbsp;</div>
        <form id ="primera_vueltaForm" action="admin.htm" method="post">
            <input type="hidden" name="accion" value=""/>
            <input type="hidden" name="idProceso" value=""/>
            <input type="hidden" name="estado" value=""/>
        </form>
    </body>
</html>
<script type="text/javascript">
    consultarEstadisticas(${proceso.idProceso});
    function enviar(idProceso,estado){
        var form = document.getElementById('primera_vueltaForm');
        form.idProceso.value = idProceso;
        form.accion.value = 'actualizarProceso';
        form.estado.value = estado;
        form.submit();
    }
</script>
