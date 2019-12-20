package net.enfoco.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.enfoco.app.model.Role;
import net.enfoco.app.repository.IRolesRepository;

@Service
public class RolesService implements IRoleService {

	@Autowired
	private IRolesRepository repoService;
	
	@Override
	public List<Role> mostrarRole() {
		
		
		return repoService.findAll();
	}


	@Override
	public Role buscarPorId(int idRole) {
		Optional<Role> optional = repoService.findById(idRole);
		
		if(optional.isPresent()) {
			
			return optional.get();
		}
		return null;
	}


	@Override
	public List<Role> buscarPorIdCuenta(int idUsuario) {
		List<Role> listRole = repoService.buscarRolPorIdUsuario(idUsuario);
		return listRole;
	}


	@Override
	public void guardarRole(Role role) {
		repoService.save(role);
	}


	@Override
	public void eliminarRole(int id) {
		repoService.deleteById(id);
		
	}

	

}
