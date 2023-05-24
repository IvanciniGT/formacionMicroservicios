package com.curso.usuarios.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class DatosUsuario extends DatosNuevoUsuario{

	private Long Id;
	
}
