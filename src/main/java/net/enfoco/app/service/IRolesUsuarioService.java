package net.enfoco.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.enfoco.app.model.RoleUsuario;



public interface IRolesUsuarioService {
	
	List<RoleUsuario> mostrarRolesUsuarios();
	Page<RoleUsuario> mostrarRolesUsuarios(Pageable page);
	void agregarRoleUsuario (RoleUsuario roleUsuario);
	void eliminarRoleUsuario (int idRoleUsuario);
	void eliminarPorIdCuenta(int idCuenta);
	List <RoleUsuario> buscarPorCuentaId(int idCuenta);
	RoleUsuario buscarPorId (int idRoleUsuario);
	List<RoleUsuario> buscarPorIdUsuario(int idUsuario);
	List<Integer> buscarListaDeIdRoles(int idUsuario);
	void eliminarPorIdCuentaYIdRole(int idCuenta, int idRole);

}
