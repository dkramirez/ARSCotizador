package net.enfoco.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "roles")
public class Role {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	private String role;
	private String detalles;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.EAGER)
	private List<RoleUsuario> listRoleUsuario = new ArrayList<RoleUsuario>();
	
	
	public List<RoleUsuario> getListRoleUsuario() {
		return listRoleUsuario;
	}
	public void setListRoleUsuario(List<RoleUsuario> listRoleUsuario) {
		this.listRoleUsuario = listRoleUsuario;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", role=" + role + ", detalles=" + detalles + "]";
	}	
	
	
}
