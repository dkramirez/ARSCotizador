<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Error</title>  
    
  <spring:url value="/" var="urlPublic"></spring:url>
	
	<link href= "${urlPublic}resources/CSS/estilos.css" rel="stylesheet"/>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>

  </head>

  <body>

    <!-- Fixed navbar -->
  	<jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <div class="panel panel-danger">
        <div class="panel-heading">
          <h3 class="panel-title">Error 400.</h3>
        </div>
        <div class="panel-body">
         <!-- <img src="${urlPublic}/images/error.png" width="48" height="48" class="center"> --> 
          <h4>El requerimiento enviado por el cliente es sintacticamente incorrecto!</h4>						
          <br>
          <button class="btn btn-success" onclick="goBack()">REGRESAR</button>
        </div>
      </div>

      <!-- FOOTER -->
   

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="bootstrap/js/bootstrap.min.js"></script> 

    <script>
      function goBack() {
         window.history.back();
      }
    </script>
  </body>
</html>
