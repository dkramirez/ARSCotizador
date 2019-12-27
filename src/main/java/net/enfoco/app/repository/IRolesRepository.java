package net.enfoco.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.enfoco.app.model.Role;


@Repository
public interface IRolesRepository extends JpaRepository<Role, Integer> {
	
	//@Query(nativeQuery = true, value = "SELECT r.idrole, r.role FROM usuarios as u INNER JOIN userRoles AS ur ON u.id = ur.idcuenta INNER JOIN roles as r on r.idrole = ur.idrole where u.id = :id")
	//public List<Role> buscarRolPorIdUsuario(@Param ("id")int id);
	
	@Query(nativeQuery = true, value = "select ur.idRole, r.role, r.detalles from userRoles as ur natural join roles as r where idCuenta = :id")
	public List<Role> buscarRolPorIdUsuario(@Param ("id")int id);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "DELETE from userRoles where idRole =:idRole")
	public void eliminarPorRoleId(@Param ("idRole") int id);

}
