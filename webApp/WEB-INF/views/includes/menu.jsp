 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!-- <nav class="navbar fixed-top navbar-light " style="background-color: #00aae4 "> -->

	<spring:url value="/" var="urlRoot"></spring:url>
		<sec:authorize access="hasAnyAuthority('Administrador')">
	
		<center>
		<nav class="navbar dropdownmenu fixed-top">
  <ul class="navbar">
  	<a class="navbar-brand text-white">ARS Cotizador</a>
    <li><a href="${urlRoot}">Inicio</a></li>
    <li><a href="${urlRoot}usuarios/indexPaginate?page=0">Usuarios</a></li>
    <li><a href="${urlRoot}roles/index">Roles</a></li>
    <li><a href="#">Cuenta</a>
      <ul id="submenu">
        <li><a href="">Usuario: <sec:authentication property="principal.username"/> </a></li>
        <li><a href="">Perfil: Administrador</a></li>
        <li><a href="${urlRoot}admin/logout">Cerrar Sesi�n</a></li>
      </ul>
    </li>
  </ul>
</nav></center>
		</sec:authorize>
		
			<sec:authorize access="hasAnyAuthority('Cliente')">
	
		<center>
		<nav class="navbar dropdownmenu fixed-top">
  <ul class="navbar">
  	<a class="navbar-brand text-white">ARS Cotizador</a>
    <li><a href="${urlRoot}">Inicio</a></li>
    <li><a href="#">Cuenta</a>
      <ul id="submenu">
        <li><a href="">Usuario: <sec:authentication property="principal.username"/> </a></li>
        <li><a href="">Perfil: Cliente </a></li>
        <li><a href="${urlRoot}admin/logout">Cerrar Sesi�n</a></li>
      </ul>
    </li>
  </ul>
</nav></center>
		</sec:authorize>
		
				<sec:authorize access="isAnonymous()">
	
		<center>
		<nav class="navbar dropdownmenu fixed-top">
  <ul class="navbar">
  	<a class="navbar-brand text-white">ARS Cotizador</a>
    <li><a href="${urlRoot}">Inicio</a></li>
    <li><a href="#">Contactos</a></li>
    <li><a href="${urlRoot}admin/welcome">Iniciar Sesi�n</a></li>
    </li>
  </ul>
</nav></center>
		</sec:authorize>
		
		