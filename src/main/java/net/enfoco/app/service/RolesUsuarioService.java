package net.enfoco.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.enfoco.app.model.RoleUsuario;
import net.enfoco.app.repository.IRoleUsuariosRepository;

@Service
public class RolesUsuarioService implements IRolesUsuarioService {
	
	@Autowired
	private IRoleUsuariosRepository repoUsuarioRoles;

	@Override
	public List<RoleUsuario> mostrarRolesUsuarios() {
		
		return repoUsuarioRoles.findAll();
	}

	@Override
	public void agregarRoleUsuario(RoleUsuario roleUsuario) {
		repoUsuarioRoles.save(roleUsuario); // problema con el metodo guardar.
		
	}

	@Override
	public void eliminarRoleUsuario(int idRoleUsuario) {
		repoUsuarioRoles.deleteById(idRoleUsuario);
		
	}

	@Override
	public RoleUsuario buscarPorId(int idRoleUsuario) {
		
		Optional<RoleUsuario> optional =repoUsuarioRoles.findById(idRoleUsuario);
		
		if(optional.isPresent()) {
			
			return optional.get();
		}
		
		return null;
	}

	@Override
	public List<RoleUsuario> buscarPorIdUsuario(int idUsuario) {
		
		//return repoUsuarioRoles.buscarRolPorIdUsuario(idUsuario);
		return null;
	}

	@Override
	public List<RoleUsuario> buscarPorCuentaId(int idCuenta) {
		
		return repoUsuarioRoles.buscarListPorIdCuenta(idCuenta);
		
		
	}

	@Override
	public void eliminarPorIdCuenta(int idCuenta) {
		repoUsuarioRoles.eliminarPorCuentaId(idCuenta);	
	}

	@Override
	public List<Integer> buscarListaDeIdRoles(int idUsuario) {
		return repoUsuarioRoles.buscarListIDRole(idUsuario);
	}

	@Override
	public void eliminarPorIdCuentaYIdRole(int idCuenta, int idRole) {
		repoUsuarioRoles.eliminarPorIdCuentaAndIdRole(idCuenta, idRole);
		
	}

	@Override
	public Page<RoleUsuario> mostrarRolesUsuarios(Pageable page) {
		
		return repoUsuarioRoles.findAll(page);
	}

}
