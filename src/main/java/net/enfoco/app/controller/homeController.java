package net.enfoco.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.enfoco.app.model.Role;
import net.enfoco.app.service.RolesService;

@Controller
public class homeController {

		@Autowired
		private RolesService serviciosRole;
	
	@GetMapping("/")
	public String mostrarPrincipal(Authentication autentication, Model model) {
		
		/*Para rendirizar en la vista el o los roles que tiene el usuario 
		 */
		if(autentication != null) {
			LoginController lc = new LoginController();
			lc.listaRoles(autentication, model);
			
		}
		
		
		return "index";
	}

	
	@GetMapping("/formLogin") // funcionando 
	public String mostrarIndex(Authentication autentication, Model model) {
		//System.out.println("llamo a bienvenido");
		
		List<Role> listRoles = serviciosRole.mostrarRole();
		model.addAttribute("listaRoles", listRoles);
		
		return "formLogin";
	}
	
	
	/*@GetMapping("/test")
	public String test() {
		
		
		return "usuario/formUsuario";
	}*/
}
