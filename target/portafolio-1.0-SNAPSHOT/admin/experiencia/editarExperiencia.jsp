<%-- 
    Document   : editarPortafolio
    Created on : 12-06-2023, 22:56:11
    Author     : Loreto Galvez
--%>

<%@page import="cl.unab.portafolio.modelo.Portafolio"%>
<%@page import="cl.unab.portafolio.modelo.Experiencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Experiencia experiencia = (Experiencia)request.getSession().getAttribute("experienciaVO");

Portafolio portafolio = (Portafolio)request.getSession().getAttribute("portafolioVO");

%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Administración Portafolio</title>
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <script src="../../js/utils.js" type="text/javascript"></script>
        <script lang="Javascript">
            function modificar(idPortafolio, idExperiencia) {
                document.getElementById("frm").action = "../../ExperienciaAdmin?accion=editSub&id=" + idPortafolio + "&idExp=" + idExperiencia;
                document.getElementById("frm").submit();
            }

            function cancelar(idPortafolio) {
                document.getElementById("frm").action = "../../ExperienciaAdmin?accion=list&id=" + idPortafolio;
                document.getElementById("frm").submit();
            }
        </script>

</head>
<body>
<div class="container">
    <table align="right">
        <tr>
            <td>Usuario: admin</td>
            <td>
                <a href="#" onclick="logout();" class="text-decoration-none" title="Cerrar Sesión">
                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-dash" viewBox="0 0 16 16">
                      <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7ZM11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1Zm0-7a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Z"></path>
                      <path d="M8.256 14a4.474 4.474 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10c.26 0 .507.009.74.025.226-.341.496-.65.804-.918C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4s1 1 1 1h5.256Z"></path>
                    </svg>
                </a>
            </td>
        </tr>
    </table>     
    
    <h2 class="text-center my-5"><u>Editar Experiencia</u></h2>
    <form action="../../ExperienciaAdmin?accion=editSub" method="post" name="frm" id="frm">
        <input type="hidden" name="id" value="<%=experiencia.getIdPortafolio()%>">
                <div>
                    <h5 class="text-center my-5">Portafolio: <%=portafolio.getNombre()%> <%=portafolio.getApellido()%> - <%=portafolio.getProfesion()%></h5>
                </div>
		<table class="table">
		  <tbody>                     
		    <tr>
		      <td>Titulo:</td>
		      <td><input type="text" class="form-control" id="titulo" name="titulo" value="<%=experiencia.getTitulo()%>"></td>
                      <td colspan="2"></td>
		    </tr>
                    <tr>
		      <td>Texto:</td>
		      <td><input type="text" class="form-control" id="texto" name="texto" value="<%=experiencia.getTexto()%>"></td>
                      <td colspan="2"></td>
		    </tr>
		    <tr>
		      <td>Página:</td>
		      <td><input type="text" class="form-control" id="pagina" name="pagina" value="<%=experiencia.getPagina()%>"></td>
                      <td colspan="2"></td>
		    </tr>
		  </tbody>
		</table>        

        <div class="form-group row my-3">
            <div class="col-sm-12 text-left">
                <button type="button" class="btn btn-primary" onclick="modificar(<%=portafolio.getId()%>, <%=experiencia.getIdExperiencia()%>);">Modificar</button>
                <button type="button" class="btn btn-primary" onclick="cancelar(<%=portafolio.getId()%>);">Cancelar</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
