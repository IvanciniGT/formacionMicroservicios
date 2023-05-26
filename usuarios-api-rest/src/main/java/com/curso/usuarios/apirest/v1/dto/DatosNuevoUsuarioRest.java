package com.curso.usuarios.apirest.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

// DTO: Data Transfer Object
@Data
@EqualsAndHashCode(callSuper=true)
public class DatosNuevoUsuarioRest extends DatosModificablesUsuarioRest{

	private String nombre;
	private String apellidos;
	
	public void setNombreCompleto(String nombreCompleto) {
		if(this.nombre== null || this.apellidos == null) {
			this.nombre = nombreCompleto;
			this.apellidos = "";
		}
	}
	public String getNombreCompleto() {
		return (this.nombre +" "+this.apellidos).trim();
	}
	
}
