package com.curso.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
		name = "Usuarios"
)
public class Usuario {

	public enum Genero {
		Hombre, Mujer, NoBinario, Desconocido
	}
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@Getter @Setter
	@Column(length = 100, nullable = false, updatable = false)
	@Deprecated
	private String nombre;
	
	@Getter @Setter
	@Column(length = 50, nullable = false, updatable = false)
	@Deprecated
	private String apellidos;
	
	@Getter @Setter
	private int edad;

	@Getter @Setter
	@Column(nullable = false)
	private Genero genero = Genero.Desconocido;

	@Transient // Evita que el dato se persista
	private String nombreCompleto;
	
	public String getNombreCompleto() {
		return (this.nombre + " " + this.apellidos).trim();
	}	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombre = nombreCompleto;
		this.apellidos = "";
	}
	
}
