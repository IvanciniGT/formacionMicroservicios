package com.curso.usuarios.apirest.v2.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

// DTO: Data Transfer Object
@Data
@EqualsAndHashCode(callSuper=true)
public class DatosNuevoUsuarioRest extends DatosModificablesUsuarioRest{

	private String nombreCompleto;
	
}
