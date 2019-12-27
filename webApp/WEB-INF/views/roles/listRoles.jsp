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
    <title>Listado de Roles</title>
    <spring:url value="/roles/crear" var="urlCrear"></spring:url>
    <spring:url value="/roles/delete" var="urlDelete"></spring:url>
    <spring:url value="/roles/edit" var="urlEdit"></spring:url>
    <spring:url value="/" var="urlPublic"></spring:url>
  
  
  	<link href= "${urlPublic}resources/CSS/estilos.css" rel="stylesheet"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
    
  </head>
  
  <body>
  <jsp:include page="../includes/menu.jsp"></jsp:include>
  <br><br>


    <div class="container theme-showcase" role="main">

      <h3>Lista de Perfiles</h3>
      
      <c:if test="${mensaje!=null }">
       <div class="alert alert-success" role="alert">${ mensaje}</div>
      
      </c:if>
      
      <a href="${urlCrear}" class="btn btn-primary" role="button" title="Nueva Peril" >Nuevo</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered"  >
            <tr>
                <th>ID</th>
                <th>Perfil</th>
                <th>Detalles</th>
                <th>Opciones</th>

            </tr>
            <c:forEach items="${roles}" var="role">
            <tr>
                <td>${role.idRole }</td>
                <td>${role.role}</td> 
                <td>${role.detalles}</td>           
                <td>
					<a href="${urlEdit}/${role.idRole}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="badge badge-success">Editar</span></a>
                    <a href="${urlDelete}/${role.idRole}" onclick='return confirm("Esta seguro ?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="badge badge-danger">Eliminar</span></a>
				</td>
            </tr>
            </c:forEach>
            <tr>
            
        </table>
      </div>
      <hr class="featurette-divider">

    

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="bootstrap/js/bootstrap.min.js"></script> 

  </body>
</html>
