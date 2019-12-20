 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!-- <nav class="navbar fixed-top navbar-light " style="background-color: #00aae4 "> -->

	<spring:url value="/" var="urlRoot"></spring:url>
		<sec:authorize access="hasAnyAuthority('Administrador')">
	
		<!-- <nav class="nav nav-pills nav-fill fixed-top"> -->
		<!-- <nav class="navbar navbar-light fixed-top" style="background-color: #2270b3;"> -->
		<nav class="navbar navbar-dark bg-dark fixed-top " >
		  <a class="nav-item nav-link" href="${urlRoot}">ARS Cotizador|Administracion</a>
		  <a class="nav-item nav-link" href="${urlRoot}usuarios/indexPaginate?page=0">Usuarios</a>
		  <a class="nav-item nav-link" href="${urlRoot}roles/index">Roles</a>
		  <a class="nav-item nav-link" href="${urlRoot}admin/logout">Logout</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		  <span class="navbar-toggler-icon"></span>
		</nav>
		</sec:authorize>
		
		<sec:authorize access="hasAnyAuthority('Cliente')">
	
		<nav class="nav nav-pills nav-fill fixed-top">
		  <a class="nav-item nav-link" href="${urlRoot}">ARS Cotizador|Cliente</a>
		  <a class="nav-item nav-link" href="${urlRoot}admin/logout">Logout</a>
		</nav>
		</sec:authorize>
		
		<sec:authorize access="isAnonymous()">
	
		<nav class="nav nav-pills nav-fill fixed-top">
		  <a class="nav-item nav-link" href="${urlRoot}">ARS Cotizador</a>
		  <a class="nav-item nav-link" href="#">Contactos</a>
		</nav>
		</sec:authorize>