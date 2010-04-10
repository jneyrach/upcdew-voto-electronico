<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h1>${procesoTitulo}</h1>
        </div>
        <!--TopPan Close-->
        <!--BodyPan-->
        <form id="condicionesForm" action="condiciones_uso.htm" method="post">
            <input type="hidden" name="accion" value=""/>
            <div id="bodyPan">
                <h1><span>Condiciones de votaci&oacute;n</span></h1>
                <p class="bigtext">Lea con atenci&oacute;n.</p>
                <p>El equipo de desarrolladores no se hace responsable de los efectos post votaci&oacute;n.....</p>
                <br/>
                <table width="100%" border="0">
                    <tr>
                        <td align="center"><input id="id_aceptar_condicion" type="checkbox"/> Acepto las condiciones de uso.</td>
                    </tr>
                </table>
                <br/>
                <!--<p class="morenext"><a href="VotacionServlet?accion=cedulaVotacion" >Ok</a></p>-->
                <p class="morenext"><a href="javascript:validaCondicion();" >Ok</a></p>

            </div>
            <div id="bodybottomPan">&nbsp;</div>
        </form>
        <!--BodyPan Close-->
        <!--FooterPan-->
    </body>
</html>
<script type="text/javascript">
    function validaCondicion(){
        var form = document.getElementById('condicionesForm');
        if(form.id_aceptar_condicion.checked){
            form.accion.value = 'cedulaVotacion';
            form.submit();
        }else{
            alert('Debe aceptar las condiciones de uso..')
        }
    }
</script>
