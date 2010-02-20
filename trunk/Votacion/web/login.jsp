<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Time Manager</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/utilitario.js" ></script>

    </head>

    <body>
        <!--TopPan-->
        <div id="topPan">
            <h1>${procesoTitulo}</h1>
        </div>
        <!--TopPan Close-->
        <!--BodyPan-->
        <div id="bodyPan">
            <h1><span>Bienvenido</span></h1>
            <p class="bigtext">Ingrese su usuario y password para iniciar sesi&oacute;n.</p>

            <form action="VotacionServlet" method="post" id="loginForm">
                <input type="hidden" name="accion" value=""/>
                <h2>member login</h2>
                <input type="hidden" class="paddingtop" name="idProceso" value="${idProceso}" />
                <input type="text" class="paddingtop" name="usuario" value="" />
                <input type="password" name="password"  value="" />
                <!--<p class="morenext"><a href="javascript:document.loginForm.submit();">Aceptar</a></p>-->
                <p class="morenext"><a href="javascript:login();">Aceptar</a></p>
            </form>
        </div>
        <div id="bodybottomPan">&nbsp;</div>
        <!--BodyPan Close-->
        <!--FooterPan-->
    </body>
</html>
<script type="text/javascript">
    function login(){
        var form = document.getElementById('loginForm');
        if (trim(form.usuario.value) == ''){
            alert('Ingrese el usuario');
            form.usuario.value = '';
        }else if (trim(form.password.value) == ''){
            alert('Ingrese el password');
            form.password.value = '';
        }else{
            form.accion.value = 'logueoVotacion';
            form.submit();
        }
    }
</script>
