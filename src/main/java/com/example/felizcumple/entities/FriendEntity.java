package com.example.felizcumple.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friends")
public class FriendEntity {

	private Long id;
	private String nombre;
	private Date fechaNacimiento;
	private String telefono;
	
	public FriendEntity(){
		
	}
	
	public FriendEntity(String nombre, String telefono, Date fechaNacimiento) {
    	this.setNombre(nombre);
    	this.setTelefono(telefono);
    	this.setFechaNacimiento(fechaNacimiento);
    }

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	
}
