package com.curso.prueba;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Servicio REST
@RestController
// Se antepone al resto de mapping que hay
@RequestMapping("/api/v1")
public class ServicioRestDeUsuarios {
	
	private RepositorioDeUsuarios miRepo;
	
	public ServicioRestDeUsuarios(RepositorioDeUsuarios miRepo) { // QUIERO UN REPO DE ESTE TIPO, SPRING !
								// Inyección de dependencias: Me dan una instancia.. no la creo yo
								// Que me permite respetar el ppo de Inversión de dependencias: SOLO DEPENDO DE INTERFACES
								// Y lo consigo gracias a la Inversión de Control: Spring es el que crea mis objetos... no yo... le delegué el curro 
		this.miRepo = miRepo;
	}
	
		   // HttpResponse de Springboot
		   // Te permite generar una respuesta Http, 
		   // MAS MAGINA !!! en la que el cuerpo de la respuesta se convertiraá en JSON o XML en automático
						  // Lo que devuelvo en el cuerpo (body) del HTTP Response
	@GetMapping("/usuarios") // cuando invoquen a http://miservidor:8080/usuarios
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		List<Usuario> usuarios = miRepo.findAll();
		return new ResponseEntity<>(usuarios, HttpStatus.OK); // Se convertirán a JSON En automatico
	}	

	@PostMapping("/usuarios") // cuando invoquen a http://miservidor:8080/usuarios
	public ResponseEntity<Usuario> nuevoUsuario(@RequestBody Usuario nuevoUsuario){
												// Los datos del usuario me vienen en el body del request
		// Mandar correo
		// Generale un a contraseña
		// Dalo de alta en otra de BBDD
		return new ResponseEntity<>(miRepo.save(nuevoUsuario), HttpStatus.OK); // Se convertirán a JSON En automatico
	}

	@DeleteMapping("/usuarios/{id}") // cuando invoquen a http://miservidor:8080/usuarios/1
	public ResponseEntity<Usuario> borrarUsuario(@PathVariable("id") Long id){
												// Los datos del usuario me vienen en el body del request
		Optional<Usuario> usuario = miRepo.findById(id);
		if(usuario.isPresent()) {
			miRepo.deleteById(id);
			return new ResponseEntity<>(usuario.get(), HttpStatus.OK); // Se convertirán a JSON En automatico
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
}

// En algún sitio, alguien va a a ejecutar: 
// new ServicioRestDeUsuarios();
// Lo he escrito yo eso por algún lao ? NO
// Lo hace Spring... ya le delegué