package net.enfoco.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin")
public class LoginController { 
	
	
		@GetMapping("/") // funcionando 
		public String mostrarIndex(Authentication autentication) {
			System.out.println("llamo a bienvenido");
			
			return "bienvenido";//modificaste
		}
	
	
	
	@GetMapping("/logout")
	public String logout (HttpServletRequest request) {
			SecurityContextLogoutHandler logout = new SecurityContextLogoutHandler();
			logout.logout(request, null, null);
			
			System.out.println("llamo a saliste");
			
			return "redirect:/formLogin";	
	}
	
	@GetMapping("/welcome")
	public String bienvenido () {
		
		return "bienvenido";
	}
	
}
