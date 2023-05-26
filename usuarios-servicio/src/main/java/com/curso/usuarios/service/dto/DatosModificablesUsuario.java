package com.curso.usuarios.service.dto;

import com.curso.usuarios.Usuario.Genero;

import lombok.Data;

@Data
public class DatosModificablesUsuario {

	private int edad;
	private Genero genero= Genero.Desconocido;

}
