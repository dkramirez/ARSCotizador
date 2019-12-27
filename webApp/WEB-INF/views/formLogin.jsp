<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Soy el login personalizado</title>
    
    <spring:url value="/login" var="urlRoot"></spring:url>
    
    
    
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
  </head>
  <body>
  
     <div class="container">
      <form class="form-control text-center container" style="width: 30%; height: 40%;" method="post" action="${urlRoot}">
      
      <c:if test="${param.error !=null}"> <!-- lo que estoy diciendo aqui es si existe en la url un parametro llamado error -->
				<img src="${urlPublic}/images/error.png" width="48" height="48" class="center">
				<h4 class="form-signin-heading" style="color:red">Acceso denegado</h4>
			</c:if>  
        <h2 class="form-signin-heading">ARSCotizador Login</h2>
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
         
      <!--
        <p>
          <label for="perfil" class="sr-only">Perfil</label>
          <select  id="perfil" name="perfil" class="selectpicker form-control">
          <c:forEach items="${listaRoles}" var="role">
          	<option value="${role.idRole}">${role.role }&nbsp;</option>
          	</c:forEach>
          </select>
        </p>-->
         

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
      
</div>
</body></html>