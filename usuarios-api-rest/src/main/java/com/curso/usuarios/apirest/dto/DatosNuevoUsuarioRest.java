package com.curso.usuarios.apirest.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

// DTO: Data Transfer Object
@Data
@EqualsAndHashCode(callSuper=true)
public class DatosNuevoUsuarioRest extends DatosModificablesUsuarioRest{

	private String nombre;
	private String apellidos;
	
}
