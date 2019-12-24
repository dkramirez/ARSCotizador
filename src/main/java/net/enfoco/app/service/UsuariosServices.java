package net.enfoco.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.enfoco.app.model.Usuario;
import net.enfoco.app.repository.IUsuariosRepository;

@Service
@Transactional
public class UsuariosServices implements IUsuarioService{
	
	@Autowired
	private IUsuariosRepository repoUsuario;

	@Override
	public List<Usuario> mostrarUsuarios() {
		
		return repoUsuario.findAll();
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		repoUsuario.save(usuario);
		
	}

	@Override
	public void eliminarUsuario(int idUsuario) {
		//repoUsuario.deleteById(idUsuario);
		repoUsuario.eliminarPorCuentaId(idUsuario);
		
		
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		
		Optional<Usuario> optional = repoUsuario.findById(idUsuario);
		
		if(optional.isPresent()) {
			
			return optional.get();
		}
		return null;
	}

	@Override
	public void upDate(int idUsuario) {
		
		Usuario usuarioTemp = new Usuario();
		
		 repoUsuario.actualizarUsuario(usuarioTemp.getNombre(), usuarioTemp.getApellido(),
				usuarioTemp.getCuenta(), usuarioTemp.getPwd(), usuarioTemp.getEstatus(), usuarioTemp.getEmail()
				, usuarioTemp.getTelefono(), idUsuario);
	
		//return usuario;
	}

	@Override
	public String buscarPorCuenta(String cuenta) {
		
		return repoUsuario.buscarPorCuenta(cuenta);
	}

	@Override
	public Page<Usuario> mostrarUsuarios(Pageable page) {
		
		return repoUsuario.findAll(page);
	}

	
	/* Metodo que me va a permitir busca por
	 * nombre de usuario, cuenta
	 * y por el id del usuario. 
	 * */
/*	@Override
	public List<Usuario> buscar(String text) {
		List<Usuario> listBuscador = repoUsuario.bucador(text);
		
		return listBuscador;
	}*/

	@Override
	public Page<Usuario> buscar(String texto, Pageable page) {
	//return	repoUsuario.bucador(page);
	
	return repoUsuario.bucador(texto, page);
		
	}



}
