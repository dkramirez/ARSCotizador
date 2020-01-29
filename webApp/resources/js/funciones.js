var formulario = document.querySelector("#formularioBusqueda");
var formularioPrincipal = document.querySelector("#tabla");

formulario.addEventListener('submit', function(e) {
	e.preventDefault();
	//console.log("estoy dentro de la funcion")

	var data = new FormData(formulario);
	console.log(data);
	
	//Obteniendo el valor introducido para hacer la busqueda
	var txtBuscar = data.get("txtBuscar");

	//Obteniendo los datos con fetch
	fetch("/ARSCotizador/usuarios/buscar?txtBuscar="+txtBuscar)
			.then(res=>res.json())
			.then(dato=>{
				//console.log(dato)
				tabla(dato)

				//solo me falta setear los datos a la tabla 
			})

			function tabla(dato) {

				//console.log(dato)
				//console.log(dato.content[0].nombre)
				
				formularioPrincipal.innerHTML=''

				var borrar = '/ARSCotizador/usuarios/delete'
				var editar = '/ARSCotizador/usuarios/edit'  

				for(let valor in dato){
				console.log(dato.content[0].nombre)

				
				if(dato.content[0].estatus ==1){
					var estatus = 'Activo'
					var	clase=  'badge badge-success'
					
				}else{
					estatus = 'Inactivo'
					clase = 'badge badge-danger' 
					
				}
				
					formularioPrincipal.innerHTML=`
					
					<tbody>
					<tr>
				<th scope="row">${dato.content[0].id}</th>
                <td>${dato.content[0].nombre}</td>
                <td>${dato.content[0].apellido}</td>    
                <td>${dato.content[0].cuenta}</td>  
                <td>${dato.content[0].email}</td>
                <td>${dato.content[0].telefono}</td> 
                <td><span class="${clase}">${estatus}</span></td>	
				<td>
                <a href="${editar}/${dato.content[0].id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="badge badge-success">Editar</span></a>
                <a href="${borrar}/${dato.content[0].id}"onclick='return confirm("¿esta seguro de eliminar el usuario?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="badge badge-danger">Eliminar</span></a>
                </td>
				
				</tr>
				</tbody>
					`	
				
				}
				
			}
			

		

		
			document.onreadystatechange = () => {
				if (document.readyState === 'complete') {
				  console.log('DOM is ready.')
				}
			  };
			

			fetch("/ARSCotizador/usuarios/indexPaginate?page=0")
						.then(res=>res.json())
						.then(data=>{

							console.log(data)
						})
			function usuarios() {
				
			}
})
