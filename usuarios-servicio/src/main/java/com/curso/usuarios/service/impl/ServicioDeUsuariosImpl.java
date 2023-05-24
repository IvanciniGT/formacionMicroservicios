package com.curso.usuarios.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.curso.usuarios.RepositorioDeUsuarios;
import com.curso.usuarios.Usuario;
import com.curso.usuarios.service.ServicioDeUsuarios;
import com.curso.usuarios.service.dto.DatosModificablesUsuario;
import com.curso.usuarios.service.dto.DatosNuevoUsuario;
import com.curso.usuarios.service.dto.DatosUsuario;
import com.curso.usuarios.service.mapper.Mapeador;

// Queremos que Sping cree esta clase... Eso hay que decirselo
// Además, querremos que luego, en otros proyectos alguien pueda solicitar un ServicioDeUsuarios
// y que spring lo inyecte (inyección de dependencias)
// Para resolver todo esto, Een Spring tenemos una anotación que nos viene que ni pintada:
@Service
public class ServicioDeUsuariosImpl implements ServicioDeUsuarios {

	private RepositorioDeUsuarios repositorio;
	
	public ServicioDeUsuariosImpl(RepositorioDeUsuarios repositorio) { // INYECCION DE DEPENENCIAS
		this.repositorio=repositorio;
	}
	
	@Override
	public DatosUsuario crearUsuario(DatosNuevoUsuario datosNuevoUsuario) {
		Usuario nuevoUsuarioACrear = Mapeador.datosUsuario2Usuario(datosNuevoUsuario);
		Usuario usuarioCreado = repositorio.save(nuevoUsuarioACrear);
		return Mapeador.usuario2DatosUsuario(usuarioCreado);
	}

	@Override
	public Optional<DatosUsuario> recuperarUsuario(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		if(usuario.isPresent()) {			// Si el usuario existe lo borro y devuelvo
			DatosUsuario datosDelUsuario = Mapeador.usuario2DatosUsuario(usuario.get()) ;
			return Optional.of( datosDelUsuario );
		} else {							// Si no existe no devuelvo ni hago nada
			return Optional.empty();
		}	
	}

	@Override
	public Optional<DatosUsuario> borrarUsuario(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		if(usuario.isPresent()) {			// Si el usuario existe lo borro y devuelvo
			repositorio.deleteById(id);
			DatosUsuario datosDelUsuario = Mapeador.usuario2DatosUsuario(usuario.get()) ;
			return Optional.of( datosDelUsuario );
		} else {							// Si no existe no devuelvo ni hago nada
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<DatosUsuario> modificarUsuario(Long id, DatosModificablesUsuario datosModificablesUsuario) {
		Optional<Usuario> usuario = repositorio.findById(id);
		if(usuario.isPresent()) {			// Si el usuario existe lo borro y devuelvo
			Usuario usuarioModificado = Mapeador.modificarUsuario(usuario.get(), datosModificablesUsuario) ;
			Usuario modificado = repositorio.save(usuarioModificado);
			return Optional.of( Mapeador.usuario2DatosUsuario(modificado) );
		} else {							// Si no existe no devuelvo ni hago nada
			return Optional.empty();
		}
	}

	@Override
	public List<DatosUsuario> recuperarUsuarios() {
		List<Usuario> usuarios=repositorio.findAll();
		return usuarios.stream()								// Para cada usuario
				.map(Mapeador::usuario2DatosUsuario)	// Conviertelo a DatosUsuario
				.collect( Collectors.toList() ); 		// Y devuelvelo como lista
		/*
		List<DatosUsuario> datosUsuarios = new ArrayList<>();
		for(Usuario usuario : usuarios) {
			datosUsuarios.add(Mapeador.usuario2DatosUsuario(usuario));
		}
		return datosUsuarios;*/
		/*
		usuarios.stream()		// Devolver un Stream<Usuario>
								// ¿Qué es un Stream? Novedad en Java 1.8
								// Toda colección (Set, List, Map...) en Java 1.8 la puedo convertir en un Stream
								// Un Stream es parecido a un Set (una secuencia de datos)
								// Que viene preparada para aplciarle programación funcional (.map(), .filter(),...)
				.map(Mapeador::usuario2DatosUsuario)		// Aplica una función a todos los elementos de un Stream y el rsultado de esa función
								// para cada elemento es añadido a otro stream, que es lo que .map devuelve
								// Esto nos sirve para tranformar los datos de una colección de datos.
								
								 Stream<Usuario> -> .map( funciónDeTransformación )	Stream< Tipo que devuelva la funciónDeTransformación>
									 Usuario1										 funciónDeTransformación(Usuario1)
									 Usuario2										 funciónDeTransformación(Usuario2)
									 Usuario3										 funciónDeTransformación(Usuario3)
								 
				.collect( Collectors.toList() ); // Me permite pasar de un Stream a una Collection
		*/
	}

}









