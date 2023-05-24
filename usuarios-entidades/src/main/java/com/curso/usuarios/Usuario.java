package com.curso.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
		name = "Usuarios"
)
public class Usuario {

	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@Getter @Setter
	@Column(length = 50, nullable = false, updatable = false)
	private String nombre;
	
	@Getter @Setter
	@Column(length = 50, nullable = false, updatable = false)
	private String apellidos;
	
	@Getter @Setter
	private int edad;

}
