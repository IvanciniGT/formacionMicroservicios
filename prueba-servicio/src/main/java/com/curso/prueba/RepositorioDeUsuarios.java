package com.curso.prueba;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository: Le indica a Springboot que esto debe permitirme obtener una clase
// Para acceder a la tabla Usuarios y hacer operaciones contra ella
// MAGIA !!! Spring, cuando arranque la app, va a generar una implementación de esta interfaz (REPOSITORIODEUSUARIO)
// Y va a meter un huevo de funciones predeterminadas:
	// save(Usuario)
	// delete(Usuario)
	// findById(id)
																	  // Id
public interface RepositorioDeUsuarios extends JpaRepository<Usuario, Long>{
															// Objeto que quiero gestionar
	// Aquí puedo decirle a Spring que quiero ADICIONALMENTE otras funciones de mi interés, que necesito para mi app
	//List<Usuario> findByEdadGreaterThan(Integer edad);
					    //// Es porque mi campo se llama edad
				  // El resto de palabras son especificas de Spring
}
