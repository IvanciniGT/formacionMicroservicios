package com.curso.usuarios.service.mapper;

import com.curso.usuarios.Usuario;
import com.curso.usuarios.service.dto.DatosModificablesUsuario;
import com.curso.usuarios.service.dto.DatosNuevoUsuario;
import com.curso.usuarios.service.dto.DatosUsuario;

public class Mapeador {

	public static DatosUsuario usuario2DatosUsuario(Usuario usuario) {
		DatosUsuario datos= new DatosUsuario();
		datos.setId(usuario.getId());
		datos.setNombre(usuario.getNombre());
		datos.setApellidos(usuario.getApellidos());
		datos.setEdad(usuario.getEdad());
		datos.setGenero(usuario.getGenero());
		return datos;
	}

	public static Usuario datosUsuario2Usuario(DatosNuevoUsuario datosNuevoUsuario) {
		Usuario usuario= new Usuario();
		usuario.setNombre(datosNuevoUsuario.getNombre());
		usuario.setApellidos(datosNuevoUsuario.getApellidos());
		modificarUsuario(usuario, datosNuevoUsuario);
		return usuario;
	}

	public static Usuario modificarUsuario(Usuario usuario,
			DatosModificablesUsuario nuevosDatos) {
		usuario.setEdad(nuevosDatos.getEdad());
		usuario.setGenero(nuevosDatos.getGenero());
		return usuario;
	}

}
