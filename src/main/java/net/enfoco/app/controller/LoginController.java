package net.enfoco.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String bienvenido (Authentication autentication, Model model) {
		
		/*Para rendirizar en la vista el o los roles que tiene el usuario 
		 */
		listaRoles(autentication, model);
		
		
		return "bienvenido";
	}
	
	
	
	/*Para rendirizar en la vista el o los roles que tiene el usuario 
	 */
	public void listaRoles (Authentication autentication, Model model) {
		
		List<GrantedAuthority> listaAuthority = new ArrayList<GrantedAuthority>();
		
		for(GrantedAuthority rol: autentication.getAuthorities()) {
			listaAuthority.add(rol);
			
			System.out.println("Los roles del usuario son: " +  rol.getAuthority());
		}
		
			model.addAttribute("rolesUsuarios", listaAuthority);
			System.out.println("la variable GrantedAu " + listaAuthority);
			System.out.println("Tamaño del arreglo de perfiles del usuario "  + listaAuthority.size());	
		}
	}
