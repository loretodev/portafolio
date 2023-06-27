<%-- 
    Document   : editarPortafolio
    Created on : 12-06-2023, 22:56:11
    Author     : Loreto Galvez
--%>

<%@page import="cl.unab.portafolio.modelo.Portafolio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
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
            function cancelar() {
                document.getElementById("frm").action = "../../PortafolioAdmin?accion=list";
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
    
    <h2 class="text-center my-5"><u>Editar Portafolio</u></h2>
    <form action="../../PortafolioAdmin?accion=editSub" method="post" name="frm" id="frm">
        <input type="hidden" name="id" value="<%=portafolio.getId()%>">
        
		<table class="table">
		  <tbody>
		    <tr>
		      <td>Nombre:</td>
                      <td><input type="text" class="form-control" id="nombre" name="nombre" value="<%=portafolio.getNombre()%>"></td>
		      <td>Apellido:</td>
		      <td><input type="text" class="form-control" id="apellido" name="apellido" value="<%=portafolio.getApellido()%>"></td>                      
		    </tr>
		    <tr>
		      <td>Dirección:</td>
		      <td><input type="text" class="form-control" id="direccion" name="direccion" value="<%=portafolio.getDireccion()%>"></td>
                      <td colspan="2"></td>
		    </tr>
                    <tr>
		      <td>Profesion:</td>
		      <td><input type="text" class="form-control" id="profesion" name="profesion" value="<%=portafolio.getProfesion()%>"></td>
                      <td colspan="2"></td>
		    </tr>
		    <tr>
		      <td>Texto "acerca de mi" izquierda:</td>
		      <td><textarea name="acercaDeMi01" rows="10" cols="20" class="form-control"><%=portafolio.getAcercaDeMi01()%></textarea></td>
                      <td>Texto "acerca de mi" derecha:</td>
		      <td>
                          <textarea name="acercaDeMi02" rows="10" cols="20" class="form-control"><%=portafolio.getAcercaDeMi02()%></textarea>
                      </td>
		    </tr>
		    
		    <tr>
		      <td>Estado:</td>
                      <td>
                          <select name="estado">
                              <option value="">Seleccione</option>
                              <option value="A">Activado</option>
                              <option value="D">Desactivado</option>
                          </select>
                      </td>
		      <td colspan="2"></td>
		    </tr>
		  </tbody>
		</table>        

        <div class="form-group row my-3">
            <div class="col-sm-12 text-left">
                <button type="submit" class="btn btn-primary">Modificar</button>
                <button type="button" class="btn btn-primary" onclick="cancelar();">Cancelar</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
