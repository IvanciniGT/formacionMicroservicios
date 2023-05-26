package com.curso.tareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.tareas.entidades.ListadoTareas;

public interface RepositoriodeListadosDeTareas extends JpaRepository<ListadoTareas, Long>{

}
