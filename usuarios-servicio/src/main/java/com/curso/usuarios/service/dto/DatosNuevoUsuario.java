package com.curso.usuarios.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

// DTO: Data Transfer Object
@Data
@EqualsAndHashCode(callSuper=true)
public class DatosNuevoUsuario extends DatosModificablesUsuario{

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
