package com.curso.usuarios.service;

import java.util.List;
import java.util.Optional;

import com.curso.usuarios.service.dto.DatosModificablesUsuario;
import com.curso.usuarios.service.dto.DatosNuevoUsuario;
import com.curso.usuarios.service.dto.DatosUsuario;

public interface ServicioDeUsuarios {

	// Que tipo de operaciones hemos metido aqui? CRUD
	// Pero... es que este caso es muy sencillo... hay poca lógica
	// Aquí metemos en general operaciones de más alto nivel
	// Por ejemplo: HacerLogin
	// Cambiar preferencias de usuario
	// Bloquear cuenta de usuario
	public DatosUsuario crearUsuario(DatosNuevoUsuario datosNuevoUsuario);
	public Optional<DatosUsuario> recuperarUsuario(Long id);
	public Optional<DatosUsuario> borrarUsuario(Long id);
	public Optional<DatosUsuario> modificarUsuario(Long id, DatosModificablesUsuario datosModificablesUsuario);
	public List<DatosUsuario> recuperarUsuarios();
	
}
