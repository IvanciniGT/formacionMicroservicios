package com.curso.tareas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
		name = "Tareas"
)
public class Tarea {

	public enum Estado {
		PENDIENTE, INICIADA, ACABADA
	}
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@Getter @Setter
	@Column(length = 100, nullable = false, updatable = true)
	private String titulo;
	
	@Getter @Setter
	@Column(length = 2500, nullable = true, updatable = true)
	private String descripcion;
	
	@Getter @Setter
	@Column(nullable = false)
	private Estado estado = Estado.PENDIENTE;

	@Getter @Setter
	@ManyToOne
	@JoinColumn(nullable = false, updatable = false)
	private ListadoTareas listadoTareas;
}
