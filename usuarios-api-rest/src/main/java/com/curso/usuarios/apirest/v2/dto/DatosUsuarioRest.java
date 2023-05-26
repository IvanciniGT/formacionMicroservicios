package com.curso.usuarios.apirest.v2.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class DatosUsuarioRest extends DatosNuevoUsuarioRest {

	private Long Id;
	
}
