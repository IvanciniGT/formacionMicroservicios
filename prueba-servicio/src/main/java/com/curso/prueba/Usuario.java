package com.curso.prueba;

import javax.persistence.Column;
import javax.persistence.Entity; // OJO... En versión 3 de springboot, ya se usa el nuevo paquete de persistencia:
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
								 // jakarta.persistence.Entity

// Este tipo de objetos (USUARIO) quiero que se guarden en una BBDD
// Lo hacemos con JPA: Java Persistence API, es parte de la spec JEE (J2EE): Java Enterprise Edition
// Java Enterprise Edition: Conjunto de Especificaciones (JDBC, JMS, JPA, Servlet, JSP)
// Java Enterprise Edition -> Jakarta Enterprise Edition

// Con esta linea, por debajo:
// Se me va a crear Automaticamente una tabla para almacenar este tipo de datos en una BBDD.
// Y si hago cambios en este fichero, la tabla de la BBDD será modificada en consecuencia... AUTOM... 

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
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Getter @Setter
	@Column(length = 50, nullable = false)
	private String apellidos;
	
	@Getter @Setter
	private int edad;
	
	@Getter @Setter
	@Column(nullable = false)
	private Genero genero = Genero.Desconocido;

}
