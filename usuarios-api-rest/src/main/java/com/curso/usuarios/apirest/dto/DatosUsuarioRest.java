package com.curso.usuarios.apirest.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class DatosUsuarioRest extends DatosNuevoUsuarioRest {

	private Long Id;
	
}
