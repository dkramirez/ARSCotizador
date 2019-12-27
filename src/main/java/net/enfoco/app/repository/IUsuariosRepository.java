package net.enfoco.app.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.enfoco.app.model.Usuario;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuario, Integer> {
	
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "DELETE from usuarios where id =:idCuenta")
	public void eliminarPorCuentaId(@Param ("idCuenta") int id);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE usuarios SET nombre = :nombre, apellido = :apellido, cuenta = :cuenta,"
			+ " pwd = :pwd, estatus = :estatus, email = :email, telefono = :telefono WHERE id =:id ")
	public void actualizarUsuario(@Param("nombre") String nombre, @Param("apellido") String apellido,
			@Param("cuenta") String cuenta, @Param("pwd") String pwd, @Param("estatus") int estatus,
			@Param("email") String email, @Param("telefono") String telefono, @Param("id") int id);
	
	
	@Query(nativeQuery = true, value = "select cuenta from usuarios where cuenta =:cuenta")
	public String buscarPorCuenta(@Param ("cuenta") String cuenta);
	
	
	//Query pageable para hacer la busqueda por id, cuenta o nombre
	@Query(nativeQuery  = true, value = "select * from usuarios where nombre=:texto or cuenta=:texto or id=:texto ORDER BY ?#{#pageable}")
	public Page<Usuario> bucador(@Param("texto") String texto, Pageable page);

}
