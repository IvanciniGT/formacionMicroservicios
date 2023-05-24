package com.curso.usuarios.apirest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.usuarios.apirest.dto.DatosModificablesUsuarioRest;
import com.curso.usuarios.apirest.dto.DatosNuevoUsuarioRest;
import com.curso.usuarios.apirest.dto.DatosUsuarioRest;


//Servicio REST
@RestController
//Se antepone al resto de mapping que hay
@RequestMapping("/api/v1")

public class ApiRestServicioUsuarios {
	
	@PostMapping("/usuarios") 
	public ResponseEntity<DatosUsuarioRest> crearUsuario(@RequestBody DatosNuevoUsuarioRest datosNuevoUsuario) {
		return null;
	}
	@GetMapping("/usuarios/{id}") 
	public ResponseEntity<DatosUsuarioRest> recuperarUsuario(@PathVariable Long id){
		return null;
	}
	@DeleteMapping("/usuarios/{id}") 
	public ResponseEntity<DatosUsuarioRest> borrarUsuario(@PathVariable Long id){
		return null;
	}
	@PutMapping("/usuarios/{id}") 
	public ResponseEntity<DatosUsuarioRest> modificarUsuario(@PathVariable Long id, @RequestBody DatosModificablesUsuarioRest datosModificablesUsuario){
		return null;
	}
	@GetMapping("/usuarios") 
	public ResponseEntity<List<DatosUsuarioRest>> recuperarUsuarios(){
		return null;
	}

}