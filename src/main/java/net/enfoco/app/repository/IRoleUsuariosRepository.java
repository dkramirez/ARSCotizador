package net.enfoco.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.enfoco.app.model.RoleUsuario;

@Repository
public interface IRoleUsuariosRepository extends JpaRepository<RoleUsuario, Integer> {
	
	/*
	 * 
	 * Este query me trae el rol de usuario segun el id del usuario
	 * */
	
		/*@Query(nativeQuery = true, value = "SELECT r.idrole, r.role FROM usuarios as u INNER JOIN userRoles AS ur ON u.id = ur.idcuenta INNER JOIN roles as r on r.idrole = ur.idrole where u.id = :id")
		public List<RoleUsuario> buscarRolPorIdUsuario(@Param ("id")int id);*/
		
		/*@Transactional
		//@Modifying
		@Query(nativeQuery = true, value = "select id, idCuenta, idRole from userRoles where idCuenta = :idCuenta")
		public List <RoleUsuario> buscarPorIdCuenta (@Param ("idCuenta")int id); // no se ha implementado*/
		
		/*@Transactional
		List <RoleUsuario> findByIdCuenta(int idCuenta);*/
		
		//@Transactional
		@Query(nativeQuery = true, value = "select id, idCuenta, idRole from userRoles where idCuenta =:idCuenta")
		public List<RoleUsuario>  buscarListPorIdCuenta (@Param ("idCuenta")int id); // se modifico el query, ahora trae una lista de roles
		
		
		@Query(nativeQuery = true, value = "select ur.idRole from userRoles as ur natural join roles as r where idCuenta =:idCuenta")
		public List<Integer>  buscarListIDRole (@Param ("idCuenta")int id);
		
		@Query(nativeQuery = true, value = "delete from userRoles where idCuenta =:idCuenta and idRole=:idRole")
		public void eliminarPorIdCuentaAndIdRole(@Param("idCuenta") int idCuenta, @Param( "idRole") int idRole);
		
		@Transactional
		@Modifying
		@Query(nativeQuery = true, value = "DELETE from userRoles where idCuenta =:idCuenta")
		public void eliminarPorCuentaId(@Param ("idCuenta") int id);

}
