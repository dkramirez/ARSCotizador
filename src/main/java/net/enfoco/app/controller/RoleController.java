package net.enfoco.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.enfoco.app.model.Role;
import net.enfoco.app.service.RolesService;

@Controller
@RequestMapping("/roles")
public class RoleController {

	
	@Autowired
	private RolesService serviceRole;
	
	@GetMapping("/index")
	public String AgregarRoles(Model model, Authentication autentication) {
		
		LoginController lc = new LoginController();
		lc.listaRoles(autentication, model);
		
		List<Role> listRole = serviceRole.mostrarRole();
		model.addAttribute("roles", listRole);
		
		return "roles/listRoles";
				
	}
	
	
	@GetMapping("/crear")
	public String crearPerfil(@ModelAttribute Role role, Authentication autentication, Model model) {
		
		LoginController lc = new LoginController();
		lc.listaRoles(autentication, model);
		
		
		return "roles/formRole";
	}
	
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Role role, RedirectAttributes attributes) {
		
		serviceRole.guardarRole(role);
		attributes.addFlashAttribute("mensaje", "El perfil se ha creado correctamente");
		return"redirect:/roles/index";
		
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarPerfil(@PathVariable("id") int id, RedirectAttributes attributes) {
		
		serviceRole.eliminarRole(id);
		attributes.addFlashAttribute("mensaje", "El perfil fue eliminado correctamente");
		
		return"redirect:/roles/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editarRole(@PathVariable("id") int idRole, Model model, Authentication autentication) {
		
		LoginController lc = new LoginController();
		lc.listaRoles(autentication, model);
		
		
		Role role = serviceRole.buscarPorId(idRole);
		model.addAttribute("role", role);
		System.out.println("los datos del role " + role);
		
		return"roles/formRole";
		
	}
	
	
}
