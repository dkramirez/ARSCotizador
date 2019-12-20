package net.enfoco.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Role {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	private String role;
	
	//@Transient
	/*@ManyToOne(fetch = FetchType.LAZY) //relacion con usuario. un usuario tiene varios roles 
	@JoinColumn(name = "id")
	private Usuario usuario;*/
	
	//@OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
	//@JoinColum
	//@OneToMany(targetEntity = RoleUsuario.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	//private List<RoleUsuario> roleUsuario =  new ArrayList<RoleUsuario>();
	
	
	
	public int getId() {
		return idRole;
	}
	public void setId(int id) {
		this.idRole = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
/*	public List<RoleUsuario> getRoleUsuario() {
		return roleUsuario;
	}
	public void setRoleUsuario(List<RoleUsuario> roleUsuario) {
		this.roleUsuario = roleUsuario;
	}*/
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", role=" + role + "]";
	}
	
	
}
