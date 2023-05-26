package com.curso.usuarios.apirest.v1.dto;

import com.curso.usuarios.Usuario.Genero;

import lombok.Data;

@Data
public class DatosModificablesUsuarioRest {

	private int edad;
	private Genero genero = Genero.Desconocido;

}
