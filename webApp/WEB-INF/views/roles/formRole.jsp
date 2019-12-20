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
		<meta name="author" content="">
		<title>Creacion de Perfiles</title>
		
		<spring:url value="/roles/save" var="urlSave"></spring:url>
		<br><br>
		
	
		
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
	</head>

	<body>
			<jsp:include page="../includes/menu.jsp"></jsp:include>

		<div class="container theme-showcase" role="main"  >
		 
			<h3 class="blog-title"><span class="badge badge-info" >Datos del Perfil</span></h3>  
			
			 

			<form:form action="${urlSave}" method="POST" modelAttribute="role">
			
			
			
			<!-- para evitar el error 403 cuando activo la seguridad en spring hay que agregar esta linea  -->
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<form:hidden path="id"/>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="role">Role</label>             
							<form:input type="text" class="form-control" path="role" id="role" required="required"/>
						</div>  
					</div>
					<br>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="role">Role</label>             
							<form:textarea  class="form-control" path="detalles" id="detalles" required="required"/>
						</div>  
					</div>
					<br>

				<button type="submit" class="btn btn-primary" >Guardar</button>
			</form:form> 

			<hr class="featurette-divider">

			

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="bootstrap/js/bootstrap.min.js"></script>    
	</body>
</html>
