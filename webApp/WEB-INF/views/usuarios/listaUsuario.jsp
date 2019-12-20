<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Usuarios</title>
    
    <spring:url value="/usuarios/create" var="urlCreate"></spring:url>
    <spring:url value="/usuarios/edit" var="urlEdit"></spring:url>
    <spring:url value="/usuarios/delete" var="urlDelete"></spring:url>
    <spring:url value="/usuarios" var="urlUsuarios"></spring:url>
      
    
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
    
  </head>
  

  <body>
   <jsp:include page="../includes/menu.jsp"></jsp:include>
  <br><br>

    <div class="container theme-showcase" role="main">

      <h3>Listado de imagenes del Banner</h3>
      
      <c:if test="${mensaje!=null }">
      <br><br>
       <div class="alert alert-success" role="alert">${ mensaje}</div>
      </c:if>
      
      <a href="${urlCreate}" class="btn btn-primary" role="button" title="Nuevo Usuario" >Nuevo</a><br><br>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Nombre</th>                           
                <th>Apellido</th>              
                <th>Usuario</th>
                <th>E-mail</th> 
                <th>Telefono</th>  
                <th>Estatus</th> 
                <th>Opciones</th>
                         
            </tr>
            <c:forEach items="${usuarios.content}" var="usuario">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nombre }</td>
                <td>${usuario.apellido}</td>    
                <td>${usuario.cuenta }</td>  
                <td>${usuario.email}</td>
                <td>${usuario.telefono }</td> 
                
                <c:choose>
                		<c:when test="${usuario.estatus ==1}">
                		<td><span class="badge badge-success">Activo</span></td>
                		</c:when>
                		<c:otherwise>
                		<td><span class="badge badge-danger">Inactivo</span></td>
                		</c:otherwise>
                
                </c:choose>
                <td>
                    <a href="${urlEdit}/${usuario.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="badge badge-success">Editar</span></a>
                    <a href="${urlDelete}/${usuario.id}"onclick='return confirm("¿esta seguro de eliminar el usuario?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="badge badge-danger">Eliminar</span></a>
                </td>
            </tr>
            </c:forEach>
                 
        </table>
      </div>
      
       <c:if test="${conteoUsuarios >10}">
				<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			    <li class="page-item">
			      <a class="page-link" href="${urlUsuarios}/indexPaginate?page=${usuarios.number - 1 }">Anterior</a>
			    </li>
			   <li class="page-item">
		      <a class="page-link" href="${urlUsuarios}/indexPaginate?page=${usuarios.number + 1 }">Siguiente</a>
		    </li>
		  </ul>
			</nav>
	 </c:if> 
      <hr class="featurette-divider">


    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>
