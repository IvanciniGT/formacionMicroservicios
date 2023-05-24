package com.curso.usuarios.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

// DTO: Data Transfer Object
@Data
@EqualsAndHashCode(callSuper=true)
public class DatosNuevoUsuario extends DatosModificablesUsuario{

	private String nombre;
	private String apellidos;
	
}
