package net.enfoco.app.service;

import java.util.List;

import net.enfoco.app.model.Role;


public interface IRoleService {
	
	List<Role> mostrarRole();
	Role buscarPorId(int idRole);
	List<Role> buscarPorIdCuenta(int idUsuario);
	void guardarRole(Role role);
	void eliminarRole(int id);
}
