package com.curso.tareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.tareas.entidades.Tarea;

public interface RepositorioDeTareas extends JpaRepository<Tarea, Long>{

}
