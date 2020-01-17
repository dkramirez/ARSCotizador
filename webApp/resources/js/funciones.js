/*
$(".botonesEliminar").on("click", function() {
	alert("Estoy listo!");
	
});*/



//Haciendo pruebas con js.

/*
//function seleccionar (){
	
	var select = document.getElementById("DeleteBtn").value;
	//console.log(select);
	//select.style.background = "black";   
	alert("Oh yeah!" + select);
//}*/


/*
var borrar = document.getElementById("btnDelete");

function cargarContenidoAjax(){
    //Creando nuestro objeto XMLHttpRequest
	alert("estoy en la la funcion ajax");
    var xhr = new XMLHttpRequest();

    //Abriendo la conexion 
    xhr.open("GET", "./usuarios/ajaxdelete/138", true )
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log("Se cargo correctamente");

           // var contenido = document.getElementById('contenido');
            //contenido.innerHTML = xhr.responseText;

        }else{

            console.log("Hubo un error");
        }
    }
    xhr.send();
}
borrar.addEventListener('click', cargarContenidoAjax);
*/

// aqui 

/*
$(document).ready(function(){
	var id = $("#DeleteBtn").val();
	console.log(id);
	//alert("soy una prueba de que jquery funciona " + id);
	
});*/

//No se como traer el id del usuario que se va a eliminar
$(".botonesEliminar").click(function() {
	var testID = $();
	var empId = $("#SelectedidEmpleado : selected").text();
	//var empId = $("#idUsuario");
	console.log(empId);
	console.log("dentro de la primera funcion");
	
	$.ajax({
		url:"/usuarios/ajaxdelete",
		data:{empId:empId},
		type:"POST",
		success: function(data) {
			$("#msgDiv").text(data);
			$("#msgDiv").show();
			clearEmployeeData();
			$("#SelectedIdEmpleado option:contains("+empId+")").remove();
			
			}
		});
	});
	
/*

$(document).ready(function() {
	$("#btnBuscar").click(function() {
		var buscarTexto = $('#idBuscar').val();
		var saludo = 'hola';
		var txtBuscar = $('#txtBuscar').val();
		console.log(txtBuscar);
		//alert("presionaste el boton buscar " + txtBuscar);
		
		$.ajax({
			type:'GET',
			url:'buscar',
			data:{txtBuscar},
			success: function(resultado) {
				
				$("#resultado").html(resultado);
				
			}
		}).done (function() {
			
		}).fail (function() {
			console.log('Error al hacer la peticion ajax');
		});
		
	});
	
	alert('estoy ready');
	console.log("estoy ready");
	
	
});*/
