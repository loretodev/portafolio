<%-- 
    Document   : listarPortafolio
    Created on : 08-06-2023, 20:53:58
    Author     : Loreto Galvez
--%>

<%@page import="cl.unab.portafolio.modelo.Portafolio"%>
<%@page import="cl.unab.portafolio.modelo.Experiencia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<%
List<Experiencia> lista = (List<Experiencia>)request.getSession().getAttribute("listaExperienciasPortafolio");
Portafolio portafolio = (Portafolio)request.getSession().getAttribute("portafolio");

%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Administración Portafolio</title>
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <script src="../../js/utils.js" type="text/javascript"></script>
        <script lang="Javascript">
            function listPortafolios() {
                document.getElementById("frm").action = "../../PortafolioAdmin?accion=list";
                document.getElementById("frm").submit();
            }
            
            function ingresar() {
                document.getElementById("frm").action = "../../ExperienciaAdmin?accion=ins";
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
    
    <h2 class="text-center my-5">Listado de experiencias</h2>
    <form action="ExperienciaAdmin" name="frm" method="post" id="frm">
        <input type="hidden" name="id" value="<%=portafolio.getId()%>">
        <div>
            <h5 class="text-center my-5">Portafolio: <%=portafolio.getNombre()%> <%=portafolio.getApellido()%> - <%=portafolio.getProfesion()%></h5>
        </div>
                    
		<table class="table">
		  <thead>
		    <tr>
		      <th>Titulo</th>
                      <th>Texto</th>
		      <th>Pagina</th>
                      <th>Acciones</th>
		    </tr>
		  </thead>	
		  <tbody>
                        <% if (lista != null && lista.size()>0 ) { %>
                        
                            <% for (Experiencia expe : lista) {%>
                                <tr>
                                    <td><%=expe.getTitulo()%></td>
                                    <td><%=expe.getTexto()%></td>
                                    <td><%=expe.getPagina()%></td>
                                    <td>
                                        <a href="../../ExperienciaAdmin?accion=edit&id=<%=portafolio.getId()%>&idExp=<%=expe.getIdExperiencia()%>" class="text-decoration-none" title="Modificar experiencia <%=expe.getTitulo()%>">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                              <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>
                                              <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>
                                            </svg>
                                        </a>&nbsp;&nbsp;
                                        <a href="../../ExperienciaAdmin?accion=del&id=<%=portafolio.getId()%>&idExp=<%=expe.getIdExperiencia()%>" class="text-decoration-none" title="Eliminar experiencia <%=expe.getTitulo()%>">
                                          <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                                            <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"></path>
                                          </svg>
                                        </a>
                                    </td>
                                </tr>
                            <%}%>
                        
                        <% } else { %>
                            <tr>
                                <td colspan="4">No existen experiencias</td>
                            </tr>
                        <% } %>
                        
		  </tbody>
		</table>    
			    
        <div class="form-group row my-3">
            <div class="col-sm-12 text-left">
                 <button type="button" class="btn btn-primary" onclick="ingresar()">Ingresar experiencia</button>
                <button type="button" class="btn btn-primary" onclick="listPortafolios()">Listar portafolios</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
