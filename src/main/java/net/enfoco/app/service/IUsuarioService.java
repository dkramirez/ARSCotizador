package net.enfoco.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.enfoco.app.model.Usuario;


public interface IUsuarioService {
	
	List<Usuario> mostrarUsuarios();
	Page<Usuario> mostrarUsuarios(Pageable page);
	void agregarUsuario (Usuario usuario);
	void eliminarUsuario (int idUsuario);
	Usuario buscarPorId (int idUsuario);
	void upDate(int idUsuario); // Haciendo una prueba.
	String buscarPorCuenta (String cuenta);// Haciendo una prueba.

}
