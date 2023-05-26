package com.curso.tareas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(
		name = "ListadoTareas"
)
public class ListadoTareas {

	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@Getter @Setter
	@Column(length = 100, nullable = false, updatable = true)
	private String titulo;
	
	@Getter @Setter
	@OneToMany(mappedBy = "listadoTareas" )
	private List<Tarea> tareasAsociadas;

	@Getter @Setter
	@ManyToMany(mappedBy = "listadosDeTareas" )
	private List<UsuarioParticipanteEnTarea> usuarios;
}
