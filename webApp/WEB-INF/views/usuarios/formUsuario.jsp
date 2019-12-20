<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="author" content="">
		<title>Creacion de Usuarios</title>
		 
        
      
		
		<spring:url value="/usuarios/save" var="urlSave"></spring:url>
		<spring:url value="/usuarios/deleteRole/" var="urlDeleteRole"></spring:url>
		
	
		
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
	</head>

	<body>
	 <jsp:include page="../includes/menu.jsp"></jsp:include>
  		<br><br>
  		
  		<c:if test="${errorCuenta!=null }">
       <div class="alert alert-danger" role="alert">${ errorCuenta}</div>
      
      </c:if>

		<div class="container theme-showcase" role="main"  >
		 
			<h3 class="blog-title"><span class="badge badge-info" >Datos del Usuario</span></h3>  

			<form:form action="${urlSave}/${usuario.id}" method="POST" modelAttribute="usuario">
			
			<!-- para evitar el error 403 cuando activo la seguridad en spring hay que agregar esta linea  -->
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
				
				<div class="row"> 	
					<div class="col-sm-3">
						<div class="form-group">
							<label for="nombre">Nombre</label>             
							<form:input type="text" class="form-control" path="nombre" id="nombre" required="required"/>
							<form:hidden path="id"/>
							
							
						</div>  
					</div>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="apellido">Apellido</label>             
							<form:input type="text" class="form-control" path="apellido" id="apellido" required="required"/>
						</div>  
					</div>
					<br>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="cuenta">Cuenta</label>    
							<c:if test="${usuario.id >0}"> 
							<form:input type="text" class="form-control" path="cuenta" id="cuenta" required="required" disabled="true"/>
							<form:hidden path="cuenta"/>
							</c:if>  
							<c:if test="${usuario.id==0}">      
							<form:input type="text" class="form-control" path="cuenta" id="cuenta" required="required"/>
							</c:if>
							
						</div>  
					</div>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="pwd">Password</label>             
							<form:input type="password" class="form-control" path="pwd" id="pwd" required="required"/>
						</div>  
					</div>
					
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="email">Email</label>
							<form:input type="text" class="form-control" path="email" id="email" placeholder="Correo electrónico" required="required"/>
						</div>  
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="telefono">Teléfono</label>
							<form:input type="text" class="form-control" path="telefono" id="telefono" required="required" />
						</div>  
					</div>
					
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="estatus" class="control-label">Estatus</label>              
							<form:select id="estatus" path="estatus" class="form-control">
								<form:option value="1">Activo</form:option>
								<form:option value="2">Inactivo</form:option>								
							</form:select>             
						</div> 
					</div>
					 
				</div>
				
				<div class="row">   
					<div class="col-sm-3">
					<div class="form-group">
							<label for="perfil" class="control-label">Perfil</label>              
							<select  id="perfil" name="perfil" class="form-control"  multiple="multiple">
							<c:forEach items="${roles}" var="role">
								<option value="${role.idRole}">${role.role }&nbsp;</option><!-- se agreggo &nbsp; para diferenciarlo del nombre -->
								</c:forEach>							
							</select>             
						</div>
						<c:if test="${fn:length(roles) gt 0}"> <!--esta es la clave para poder dejar el select de abaja selected -->
						<a href="${urlDeleteRole}${usuario.id}" onclick='return confirm("¿esta seguro que desea eliminar los roles?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="badge badge-danger">Eliminar Roles</span></a>
						</c:if>
						<hr class="featurette-divider">
						</div>
						 
						      
					<div class="col-sm-3">
						<div class="form-group">
							<label for="perfil" class="control-label">Lista de Perfiles Disponibles</label>              
							<select  id="perfil2" name="perfil" class="form-control" multiple="multiple" required="required">
							<c:forEach items="${listRoles}" var="role">
								<option value="${role.idRole}">${role.role }&nbsp;</option><!-- se agreggo &nbsp; para diferenciarlo del nombre -->
								</c:forEach>							
							</select>             
						</div>
					</div>
					
				</div>	
				

				<button type="submit" class="btn btn-primary" >Guardar</button>
			</form:form> 

			<hr class="featurette-divider">

			<!-- FOOTER
			<footer>        
				<p class="pull-right"><a href="#">Back to top</a></p>
				<p>&copy; 2017 My CineSite, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
			</footer>	
			 -->

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="bootstrap/js/bootstrap.min.js"></script>    
	</body>
</html>
