
//Haciendo pruebas con js.

function seleccionar (){
	alert("Oh yeah!");
	//var select = document.getById("perfil2");
	//console.log(select);
}

$("#btnDelete").click(function() {
	var empId = $("#SelectedidEmpleado : selected").text();
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
	
	/*alert('estoy ready');
	console.log("estoy ready");
	$(this).css({"color":"red"});
	*/
});