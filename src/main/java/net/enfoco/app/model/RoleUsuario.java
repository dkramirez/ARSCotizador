package net.enfoco.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "userRoles")
public class RoleUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private int idCuenta;
	//private int idRole;
	
	
	//@Transient
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idRole", referencedColumnName = "idRole") // cuando es de many tu one tengo que usar esta etiqueta
	private Role role;
	
	//@Transient
	
	//@JoinColumn(name = "idCuenta", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCuenta", referencedColumnName = "id")
	private  Usuario usuarios;

	public RoleUsuario() {
		
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "RoleUsuario [id=" + id + ", role=" + role + ", usuarios=" + usuarios + "]";
	}
	
}
