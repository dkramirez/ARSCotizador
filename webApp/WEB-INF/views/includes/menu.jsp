 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- <nav class="navbar fixed-top navbar-light " style="background-color: #00aae4 "> -->

	<spring:url value="/" var="urlRoot"></spring:url>
		<sec:authorize access="hasAnyAuthority('Administrador')">
	
		
		<nav class="navbar dropdownmenu fixed-top ">
  <ul class="navbar">
  	<a class="navbar-brand text-white">ARS Cotizador</a>
    <li><a href="${urlRoot}">Inicio</a></li>
    <li><a href="${urlRoot}usuarios/indexPaginate?page=0">Usuarios</a></li>
    <li><a href="${urlRoot}roles/index">Roles</a></li>
    <li><a href="#">Cuenta</a>
      <ul id="submenu">
        <li><a>Usuario: <sec:authentication property="principal.username"/> </a></li>
        
        <li>
	         	<a>Perfil: </a>
       			  <c:forEach items="${rolesUsuarios}"  var="rUsuario">
	         	<a>${rUsuario}</a>
       			 </c:forEach>
        </li>
        
      <!-- <li><a>Perfil: Administrador</a></li> -->  
        <li><a href="${urlRoot}admin/logout">Cerrar Sesión</a></li>
      </ul>
    </li>
  </ul>
</nav>
		</sec:authorize>
		
			<sec:authorize access="hasAnyAuthority('Cliente')">
	
		
		<nav class="navbar dropdownmenu fixed-top">
  <ul class="navbar">
  	<a class="navbar-brand text-white">ARS Cotizador</a>
    <li><a href="${urlRoot}">Inicio</a></li>
    <li><a href="#">Cuenta</a>
      <ul id="submenu">
        <li><a>Usuario: <sec:authentication property="principal.username"/> </a></li>
        
        
	         <li>
	         	<a>Perfil: </a>
       			 <c:forEach items="${rolesUsuarios}"  var="rUsuario">
	         	<a>${rUsuario}</a>
       			 </c:forEach>
        </li>
        
        <!--  <li><a>Perfil: Cliente </a></li>-->
        <li><a href="${urlRoot}admin/logout">Cerrar Sesión</a></li>
      </ul>
    </li>
  </ul>
</nav>
		</sec:authorize>
		
				<sec:authorize access="isAnonymous()">
	
	
		<nav class="navbar dropdownmenu fixed-top">
  <ul class="navbar">
  	<a class="navbar-brand text-white">ARS Cotizador</a>
    <li><a href="${urlRoot}">Inicio</a></li>
    <li><a href="#">Contactos</a></li>
    <li><a href="${urlRoot}admin/welcome">Iniciar Sesión</a></li>
    
  </ul>
</nav>
		</sec:authorize>
		
		