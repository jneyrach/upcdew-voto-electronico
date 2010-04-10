<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Time Manager</title>
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
        
        <script type="text/javascript">
            function marcar(id){
                document.cedulaForm.idCandidato.value=id;
            }

            $(document).ready(function(){
               $(".tpl a").click(function(){
                    if ($(this).attr("class")=="sinmarca"){
                        $(".tpl a").attr("class","sinmarca");
                        $(this).attr("class","marca");
                        document.cedulaForm.idCandidato.value=$(this).attr("id");
                    } else {
                        $(this).attr("class","sinmarca");
                        document.cedulaForm.idCandidato.value="";
                    }
               });
               
            });

        function enviar(){
            document.cedulaForm.submit();
        }

        </script>

    </head>

    <body>
        <!--TopPan-->
        <div id="topPan">
            <h1>Resultado de la ${procesoTitulo}</h1>
        </div>
        <!--TopPan Close-->
        <!--BodyPan-->
        <div style="margin-bottom:10px;">
        <table width="100%" border="0">
                <tr>
                    <td>
                        <div id="toplinkPan">
                            <div id="toplinkfastPan">
                                <p>
                                    Candidato ganador con ${ganador.cantidadVotos} votos
                                    <br/><br/><br/>
                                    ${ganador.candidato.nombreCompleto}
                                </p>
                                <a href="#">&nbsp;</a>
                            </div>
                            
                                <div id="toplinksecondPan" class="tpl">
                                    <a href="" id="${ganador.candidato.idPersona}"></a>
                                    <img src="fotos/${ganador.candidato.idPersona}.jpg" width="119" height="140" border="0" />
                                </div>
                        </div>
                    </td>
                </tr>
        </table>
                                </div>
            <div id="bodyPan">
                 <h1><span>Resultado General</span></h1>
                


                <table summary="Employee Pay Sheet" id="hor-minimalist-b">
                    <thead>
                        <tr>
                            <th scope="col">Codigo</th>
                            <th scope="col" >Nombre</th>
                            <th scope="col">Foto</th>
                            <th scope="col">Votos</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="resultado" items="${candidatos}">
                    <tr>
                        <td>${resultado.candidato.idPersona}</td>
                        <td>${resultado.candidato.nombreCompleto}</td>
                        <td><img src="fotos/${resultado.candidato.idPersona}.jpg" width="60" height="80" border="0" /></td>
                        <td>${resultado.cantidadVotos}</td>
                    </tr>
                    </c:forEach>
                     </tbody>
                </table>

            </div>
            <div id="bodybottomPan">&nbsp;</div>

        <div id="bodyPan">
            <div style="height:68px">
                <p class="morenext" style="padding-top:33px"><a href="proceso.htm?accion=elegirProceso">Salir</a></p>
            </div>
        </div>

        <div id="bodybottomPan">&nbsp;</div>
        <!--BodyPan Close-->
        <!--FooterPan-->

        <form name="cedulaForm" action="cedula_votacion.htm">
            <input type="hidden" name="accion" value="votar"/>
            <input type="hidden" name="idCandidato" value=""/>
        </form>

    </body>
</html>
