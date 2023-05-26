package com.curso.tareas.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import com.curso.usuarios.Usuario;

import lombok.Getter;
import lombok.Setter;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UsuarioParticipanteEnTarea extends Usuario{

	@Getter @Setter
	@ManyToMany
	@JoinTable(
				name = "UsuariosAsignadosAListados",
				joinColumns = @JoinColumn(name = "usuarioId"),
				inverseJoinColumns = @JoinColumn(name = "listadoId")
			)
	private List<ListadoTareas> listadosDeTareas;
}
