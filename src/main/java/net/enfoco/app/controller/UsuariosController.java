package net.enfoco.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.enfoco.app.model.Role;
import net.enfoco.app.model.RoleUsuario;
import net.enfoco.app.model.Usuario;
import net.enfoco.app.service.RolesService;
import net.enfoco.app.service.RolesUsuarioService;
import net.enfoco.app.service.UsuariosServices;
import net.enfoco.app.controller.LoginController;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuariosServices serviciosUsuario;
	
	@Autowired
	private RolesService serviciosRoles;
	
	@Autowired
	private RolesUsuarioService serviciosRoleUsuarios;
	
	@Autowired
	private BCryptPasswordEncoder encriptar;
	
	@GetMapping("/create")
	public String mostrarFormulario (@ModelAttribute Usuario usuario, Model model, Authentication autentication) {
		 
		/*Para rendirizar en la vista el o los roles que tiene el usuario 
		 */
			LoginController l = new LoginController();
			l.listaRoles(autentication, model);
			
			List<Role> listRoles = serviciosRoles.mostrarRole();
			model.addAttribute("listRoles", listRoles);
			return "usuarios/formUsuario";
		}
	
	
	@PostMapping("/save/{id}")
	public String guardarUsuario (@PathVariable("id") int id, @ModelAttribute Usuario usuario, @RequestParam ("perfil") List<Integer> perfil
			, Model model, BindingResult result, RedirectAttributes redirect) {
		
					
				//Validando que la cuenta no exista en la base de datos 
				if(id==0 && usuario.getCuenta().equals(serviciosUsuario.buscarPorCuenta(usuario.getCuenta()))) {
					
					List<Role> listRoles = serviciosRoles.mostrarRole();
					model.addAttribute("listRoles", listRoles);
					String cuentaInvalidad = "La cuenta ya existe, intente con otro nombre para la cuenta";
					model.addAttribute("errorCuenta", cuentaInvalidad);
					return "usuarios/formUsuario"; // hay un error aqui, hay que seguir verificando.

				}else if (id==0 && usuario.getPwd().length()<30 || id>0 && usuario.getPwd().length()<30){
					
					//Encriptacion de la password antes de ingresarla a la base de datos.
					String passWord = usuario.getPwd();
					String passEncriptado = encriptar.encode(passWord);
					usuario.setPwd(passEncriptado);
					serviciosUsuario.agregarUsuario(usuario);
				}
					
				
				else if(usuario.getPwd().length()>30){
					//String pwdTemp = usuario.getPwd();
					serviciosUsuario.agregarUsuario(usuario);
					
				}
				

					Role role = new Role();
					List<RoleUsuario> rUTemp =  new ArrayList<RoleUsuario>();
					
					//Proceso para agregar los roles al usuario
					for(int i =0; i< perfil.size(); i++) {
						
						
						int temp = perfil.get(i);
						System.out.println("Variable temp " + temp);
						role= serviciosRoles.buscarPorId(temp);
						
						RoleUsuario usRole = new RoleUsuario();
						usRole.setRole(role);
						usRole.setUsuarios(usuario);
						
						rUTemp.add(usRole);
						
						List <Integer> tempComp = serviciosRoleUsuarios.buscarListaDeIdRoles(usuario.getId());
						
						if( tempComp.contains(usRole.getRole().getIdRole())) {
							
							System.out.println("Ya tiene ese role");
						}
						
						else if  (id !=0) {
							
							serviciosRoleUsuarios.agregarRoleUsuario(usRole);
							return "redirect:/usuarios/edit/{id}";
							}
						
						else {
							serviciosRoleUsuarios.agregarRoleUsuario(usRole);
							//validar aqui, problema de logica al guardar, para editar esta bien.
							//para renderizar el mismo formulario al agregar los roles
							//
						}
						
					}
					
					
					if(result.hasErrors())
					{
						
						System.out.println("ha ocurrido un error");
					}
					
						for(ObjectError error: result.getAllErrors()) {
						System.out.println(error.getDefaultMessage());
					}
					
				redirect.addFlashAttribute("mensaje", "El usuario fue Guardado correctamente");
				return"redirect:/usuarios/indexPaginate";
		}
	
	
		@GetMapping("/index")
		public String mostrarUsuarios(Model model, Authentication autentication) {
			
			/*Para rendirizar en la vista el o los roles que tiene el usuario 
			 */
			LoginController l = new LoginController();
			l.listaRoles(autentication, model);
			
			List<Usuario> listUsuarios = serviciosUsuario.mostrarUsuarios();
			model.addAttribute("usuarios", listUsuarios);
			
			
			return "usuarios/listaUsuario";
		}
		
		@GetMapping("/edit/{id}")
		public String editarUsuario(@PathVariable ("id") int idUsuario, Model model) {
		
				Usuario usuario = serviciosUsuario.buscarPorId(idUsuario);
				
				//RoleUsuario rUsuario = serviciosRoleUsuarios.buscarPorCuentaId(idUsuario);
				
				//***List<Role> listRoles = serviciosRoles.mostrarRole();
				List<Role> listRoles = serviciosRoles.buscarPorIdCuenta(idUsuario);
				List<RoleUsuario> listUroles = serviciosRoleUsuarios.buscarPorCuentaId(idUsuario);
				
				
				model.addAttribute("usRoles", listUroles);
				model.addAttribute("roles", listRoles);
				model.addAttribute("usuario", usuario);
				List<Role> listRolesN = serviciosRoles.mostrarRole();
				model.addAttribute("listRoles", listRolesN);

				return "usuarios/formUsuario";
		}
	
	
	@GetMapping("/delete/{id}")
	public String eliminarUsuario (@PathVariable("id") int idUsuario, RedirectAttributes redirect) {
		
			serviciosRoleUsuarios.eliminarPorIdCuenta(idUsuario); // ya esta funcionando pero no se porque razon tuve que hacerlo de forma manual
			serviciosUsuario.eliminarUsuario(idUsuario);
	
			redirect.addFlashAttribute("mensaje", "El usuario fue eliminado");
			return "redirect:/usuarios/indexPaginate";
		}
	
	@GetMapping("/deleteRole/{id}/**")
	public String eliminarRoleUsuario(@PathVariable("id") int idUsuario) {
		
	//	serviciosRoleUsuarios.eliminarPorIdCuentaYIdRole(idUsuario, idRole); 
			serviciosRoleUsuarios.eliminarPorIdCuenta(idUsuario);
			return "redirect:/usuarios/edit/{id}";
			
		}
	
	//comentario de prueba pra git
	@GetMapping("/indexPaginate")
	public String mostrarUsuariosPaginado(Model model, Pageable page, Authentication autentication) {
		
		/*Para rendirizar en la vista el o los roles que tiene el usuario 
		 */
		LoginController l = new LoginController();
		l.listaRoles(autentication, model);
		
		Page<Usuario> listUsuarios = serviciosUsuario.mostrarUsuarios(page);
		model.addAttribute("usuarios", listUsuarios);
		int numeroPaginas = listUsuarios.getTotalPages();
		numeroPaginas = numeroPaginas -1;
		
		model.addAttribute("numeroPaginas", numeroPaginas);
		
		/**
		 * Se manda el conteo de los usuario a la vista para validar
		 * si es necesario activar el boton siguiente de la paginacion.
		 */
		List<Usuario> listUsuario = serviciosUsuario.mostrarUsuarios();
		int conteoUsuarios = listUsuario.size();
		model.addAttribute("conteoUsuarios", conteoUsuarios);
		
		System.out.println("Paginacion  " + numeroPaginas);
		
		return "usuarios/listaUsuario";
		
		}
	
	/*Meoto que permite hacer una busqueda por nombre, id o cuenta
	 * Recibe un parametro de tipo String
	 * */
	
	/*@ResponseBody
	@GetMapping("/buscar")
	public String buscador( @RequestParam("txtBuscar") String txtBuscar, Model model, Pageable page, Authentication autentication) {
		
		LoginController l = new LoginController();
		l.listaRoles(autentication, model);
		
		Page<Usuario> listBuscador = serviciosUsuario.buscar(txtBuscar, page);
		model.addAttribute("usuarios", listBuscador);
		
		return "usuarios/listaUsuario";
	}*/
	
	
	
	// me esta imprimiendo el roleUsuario muchas veces repetidas
	//TODO se esta utilizando este metodo para hacer prueba con ajax del buscador
	@GetMapping("/buscar")
	@ResponseBody
	public Page<Usuario> buscador( @RequestParam("txtBuscar") String txtBuscar, Model model, Pageable page, Authentication autentication) {
		
		//ModelAndView mv = new ModelAndView("listaUsuario");
		
		LoginController l = new LoginController();
		l.listaRoles(autentication, model);
		
		Page<Usuario> listBuscador = serviciosUsuario.buscar(txtBuscar, page);
		//List<Usuario> test = listBuscador.getContent();
		
		//model.addAttribute("usuarios", listBuscador);
		//mv.addObject("usuario", listBuscador);
		System.out.println("Lo que se va a buscar " + txtBuscar );
		System.out.println("lo que contiene la lista " + listBuscador.getContent());
		System.out.println("lo que trae la busqueda " + listBuscador.getNumber());
		
		return listBuscador;
	}
	
	
	//TODO se esta utilizando para hacer pruebas para eliminar un registro usando ajax 
	// @ResponseBody
	@GetMapping("/ajaxdelete/{id}")
	public String deleteConAjx(@PathVariable("id") int empId) {
		System.out.println("dentro del borrado AJAX");
		String msg = "Ha ocurrido un error mientra se borraba el usuario " + empId;
		
		try {
			if(empId != 0) {
				
				 serviciosRoleUsuarios.eliminarPorIdCuenta(empId); 
				 serviciosUsuario.eliminarUsuario(empId);
				 msg="Borrando el usuario con el id: "+ empId;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return msg;
	}
	
		//para mostrar los usuarios que estan activos, aun haciendo pruebas.
		public String usuariosActivos () {
			
			return "listaUsuario";
		}
		
		
	
	}