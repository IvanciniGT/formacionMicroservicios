package com.curso.usuarios.apirest.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.curso.usuarios.apirest.v1.dto.DatosModificablesUsuarioRest;
import com.curso.usuarios.apirest.v1.dto.DatosNuevoUsuarioRest;
import com.curso.usuarios.apirest.v1.dto.DatosUsuarioRest;
import com.curso.usuarios.service.dto.DatosModificablesUsuario;
import com.curso.usuarios.service.dto.DatosNuevoUsuario;
import com.curso.usuarios.service.dto.DatosUsuario;

@Mapper
public interface Mapeador {

	Mapeador INSTANCE = Mappers.getMapper(Mapeador.class); 
	
	DatosUsuarioRest convertirA(DatosUsuario datosUsuario);
	DatosNuevoUsuario convertirA(DatosNuevoUsuarioRest datosUsuario);
	DatosModificablesUsuario convertirA(DatosModificablesUsuarioRest datosUsuario);
	
}
