package net.enfoco.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {


	
	@GetMapping("/")
	public String mostrarPrincipal() {
		
		return "index";
	}

	
	@GetMapping("/formLogin") // funcionando 
	public String mostrarIndex(Authentication autentication) {
		//System.out.println("llamo a bienvenido");
		
		return "formLogin";
	}
	
	
	/*@GetMapping("/test")
	public String test() {
		
		
		return "usuario/formUsuario";
	}*/
}
