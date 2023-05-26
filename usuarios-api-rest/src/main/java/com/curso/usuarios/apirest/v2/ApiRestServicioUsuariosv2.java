package com.curso.usuarios.apirest.v2;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.usuarios.apirest.v2.dto.DatosModificablesUsuarioRest;
import com.curso.usuarios.apirest.v2.dto.DatosNuevoUsuarioRest;
import com.curso.usuarios.apirest.v2.dto.DatosUsuarioRest;
import com.curso.usuarios.apirest.v2.mapper.Mapeador;
import com.curso.usuarios.service.ServicioDeUsuarios;
import com.curso.usuarios.service.dto.DatosUsuario;


//Servicio REST
@RestController
//Se antepone al resto de mapping que hay
@RequestMapping("/api/v2")

public class ApiRestServicioUsuariosv2 {
	
	private ServicioDeUsuarios servicioUsuarios;
	
	public ApiRestServicioUsuariosv2(ServicioDeUsuarios servicioUsuarios) {
		this.servicioUsuarios = servicioUsuarios;
	}
	@GetMapping("/usuarios") 
	public ResponseEntity<List<DatosUsuarioRest>> recuperarUsuarios(){
		List<DatosUsuario> usuarios = servicioUsuarios.recuperarUsuarios();
		return new ResponseEntity<>(usuarios.stream()
												.map(Mapeador.INSTANCE::convertirA)
												.collect(Collectors.toList()), HttpStatus.OK);
	}
	@GetMapping("/usuarios/{id}") 
	public ResponseEntity<DatosUsuarioRest> recuperarUsuario(@PathVariable Long id){
		Optional<DatosUsuario> usuario = servicioUsuarios.recuperarUsuario(id);
		if(usuario.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(Mapeador.INSTANCE.convertirA(usuario.get()), HttpStatus.OK);
	}
	@DeleteMapping("/usuarios/{id}") 
	public ResponseEntity<DatosUsuarioRest> borrarUsuario(@PathVariable Long id){
		Optional<DatosUsuario> usuarioBorrado = servicioUsuarios.borrarUsuario(id);
		if(usuarioBorrado.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(Mapeador.INSTANCE.convertirA(usuarioBorrado.get()), HttpStatus.OK);
	}
	@PostMapping("/usuarios") 
	public ResponseEntity<DatosUsuarioRest> crearUsuario(@RequestBody DatosNuevoUsuarioRest datosNuevoUsuario) {
		DatosUsuario nuevoUsuario = servicioUsuarios.crearUsuario(Mapeador.INSTANCE.convertirA(datosNuevoUsuario) );
		return new ResponseEntity<>(Mapeador.INSTANCE.convertirA(nuevoUsuario), HttpStatus.CREATED);
	}
	@PutMapping("/usuarios/{id}") 
	public ResponseEntity<DatosUsuarioRest> modificarUsuario(@PathVariable Long id, @RequestBody DatosModificablesUsuarioRest datosModificablesUsuario){
		Optional <DatosUsuario> usuarioActualizado = servicioUsuarios.modificarUsuario(id, Mapeador.INSTANCE.convertirA(datosModificablesUsuario) );
		if(usuarioActualizado.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(Mapeador.INSTANCE.convertirA(usuarioActualizado.get()), HttpStatus.OK);
	}
	

}
