package com.curso.tareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.tareas.entidades.UsuarioParticipanteEnTarea;

public interface RepositorioDeUsuariosParticipantesEnTAreas extends JpaRepository<UsuarioParticipanteEnTarea, Long>{

}
