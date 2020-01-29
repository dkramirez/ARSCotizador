package net.enfoco.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String cuenta;
	private String pwd;
	private int estatus;
	private String email;
	private String telefono;
	
	//@Transient
	//@OneToMany(mappedBy = "usuarios", cascade = CascadeType.REMOVE)
	//@JoinColumn(name = "id")
	//@OneToMany(targetEntity = RoleUsuario.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios", fetch = FetchType.EAGER)
	//@OneToMany(mappedBy = "usuarios") este era el que esta funcionando 
	
	@JsonIgnore
	private List<RoleUsuario> listRollUsuario =  new ArrayList<RoleUsuario>();
	
	public List<RoleUsuario> getListRollUsuario() {
		return listRollUsuario;
	}

	public void setListRollUsuario(List<RoleUsuario> listRollUsuario) {
		this.listRollUsuario = listRollUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cuenta=" + cuenta + ", pwd="
				+ pwd + ", estatus=" + estatus + ", email=" + email + ", telefono=" + telefono + "]";
	}


	
}
