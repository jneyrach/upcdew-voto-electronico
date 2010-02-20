<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Time Manager</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <!--TopPan-->
        <div id="topPan">
            <h1>${procesoTitulo}</h1>
        </div>
        <!--TopPan Close-->
        <!--BodyPan-->
        <div id="bodyPan">
            <h1><span>Gracias... </span></h1>
            <p class="bigtext">Lea con atenci&oacute;n.</p>
            <br/>
            <p>Ha realizado su voto de manera satisfactoria. Los resultados podran ser vistos por este mismo medio. </p>
            <br/>
            <p class="morenext"><a href="" onclick="cerrar();">Salir</a>
        </div>
        <div id="bodybottomPan">&nbsp;</div>



        <!--BodyPan Close-->
        <!--FooterPan-->
    </body>
</html>
<script>
    function cerrar(){
        close()
    }
</script>

