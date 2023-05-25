package com.curso.usuarios.apirest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.curso.usuarios.apirest.dto.DatosUsuarioRest;
import com.curso.usuarios.service.dto.DatosUsuario;

@Mapper
public interface Mapeador {

	Mapeador INSTANCE = Mappers.getMapper(Mapeador.class); 
	
	DatosUsuarioRest convertirA(DatosUsuario datosUsuario);
	//DatosNuevoUsuario convertirA(DatosNuevoUsuarioRest datosUsuario);
	//DatosModificablesUsuario convertirA(DatosModificablesUsuarioRest datosUsuario);
	
}
