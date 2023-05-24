package com.curso.usuarios.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.curso.usuarios.service.dto.DatosUsuario;
import com.curso.usuarios.service.dto.DatosNuevoUsuario;
import java.util.List;
import java.util.Optional;

// Quiero una unica instancia para todaslas pruebas
// Por defecto JUPITER crea una instancia para cada prueba @Test
@TestInstance(Lifecycle.PER_CLASS)

// Ejecute los test en base al orden INDICADO en la anotación @Order
@TestMethodOrder(OrderAnnotation.class)

// Me permite arrancar en paralelo un servidor de pruebas tomcat en un puerto aleatorio y ejecutarme dentro de él
@SpringBootTest( classes = AplicacionTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// Por defecto, Spring, si no he configurado una BBDD, mirará a ver si puede crear una BBDD H2 en memoria... Autom.

// Esta anotación le indica a Junit que delegue la creación de la instancia de esta clase a Spring,
// para que pueda resolverse la inyección de depdencias
@ExtendWith(SpringExtension.class)
public class ServicioUsuariosTest {
	private ServicioDeUsuarios servicioAProbar; // Esto es lo que quiero probar.
												// pero.... necesito una instalacia.
												// A) la creo yo = RUINA !
												// B) se la pido a Spring (inyección de dependencias)
	
	// Con esto le decimos a JUnit que en el contructor necesitamos inyeccion de depedencias... que este no es un dato de Junit para parametrizar el test
	@Autowired
	public ServicioUsuariosTest(ServicioDeUsuarios servicioAProbar) { // se lo pido a SPring... inyección de depedencias
		this.servicioAProbar=servicioAProbar;
	}
																	  // Quién va a ajecutar las pruebas? Junit
																	  // Quién va a crear una instancia de esta clase? Junit
																	  // Problema:
																	  // Si la instancia (llamar al constructor) lo hace JUNIT
																	  // Quien coño me hace la inyección de dependencias?
																	  // Junit no me puede dar ese servicio .. No es quien lo controla ni quien lo crea
																	  // Eso lo resolvemos con otra anotación: @ExtendWith
	////////////////////////////////////////////////////////////////////////////////////////
	// Cuando solicite a Junit que ha pruebas
	// Junit mira en las clases que hay de pruebas (src/test/java) aquellas que tienen funciones con anotación @Test
	// Crea una instancia de esas clases
	// Y ejecuta esas funciones con anotación @Test

	@Order(1)
	@Test
	public void recuperarUsuariosTest() {
		List<DatosUsuario> listadoUsuarios = servicioAProbar.recuperarUsuarios();
		// Las pruebas las hacemos mediante Aseguraciones
		// Dentro de la clase Assertions, tenemos funciones que comprobarán cosas.
		Assertions.assertTrue(listadoUsuarios.size()==0);
	}
	@Order(2)
	@Test
	public void recuperarUsuarioInexistente() {
		Optional<DatosUsuario> usuario = servicioAProbar.recuperarUsuario((long) -177);
		Assertions.assertTrue(usuario.isEmpty());
	}

	@Order(3)
	@Test
	public void crearUsuario() {
		DatosNuevoUsuario datos = new DatosNuevoUsuario();
		datos.setNombre("Ivan");
		datos.setApellidos("Osuna");
		datos.setEdad(44);
		DatosUsuario usuario = servicioAProbar.crearUsuario(datos);
		Assertions.assertEquals(datos.getNombre(), usuario.getNombre());
		Assertions.assertEquals(datos.getApellidos(), usuario.getApellidos());
		Assertions.assertEquals(datos.getEdad(), usuario.getEdad());
		Assertions.assertTrue(usuario.getId()>0);
	}

	@Order(4)
	@Test
	public void recuperarUsuariosYaCreados() {
		DatosNuevoUsuario datos = new DatosNuevoUsuario();
		datos.setNombre("Menchu");
		datos.setApellidos("García");
		datos.setEdad(27);
		DatosUsuario usuario = servicioAProbar.crearUsuario(datos);
		
		Optional<DatosUsuario> usuarioRecuperado = servicioAProbar.recuperarUsuario(usuario.getId());
		Assertions.assertTrue(usuarioRecuperado.isPresent());
		Assertions.assertEquals(usuario.getNombre(), usuarioRecuperado.get().getNombre());
		Assertions.assertEquals(usuario.getApellidos(), usuarioRecuperado.get().getApellidos());
		Assertions.assertEquals(usuario.getEdad(), usuarioRecuperado.get().getEdad());
		Assertions.assertEquals(usuario.getId(), usuarioRecuperado.get().getId());

	}
	@Order(5)
	@Test
	public void borrarUsuario() {
		DatosNuevoUsuario datos = new DatosNuevoUsuario();
		datos.setNombre("Felipe");
		datos.setApellidos("Ruiz");
		datos.setEdad(33);
		DatosUsuario usuario = servicioAProbar.crearUsuario(datos);
		
		Optional<DatosUsuario> usuarioEliminado = servicioAProbar.borrarUsuario(usuario.getId());
		
		Assertions.assertTrue(usuarioEliminado.isPresent());
		Assertions.assertEquals(usuario.getNombre(), usuarioEliminado.get().getNombre());
		Assertions.assertEquals(usuario.getApellidos(), usuarioEliminado.get().getApellidos());
		Assertions.assertEquals(usuario.getEdad(), usuarioEliminado.get().getEdad());
		Assertions.assertEquals(usuario.getId(), usuarioEliminado.get().getId());
		
		Optional<DatosUsuario> usuarioRecuperado = servicioAProbar.recuperarUsuario(usuario.getId());
		Assertions.assertTrue(usuarioRecuperado.isEmpty());

	}
	// Probar la modificacion...
	// Probar que despueés de crear muchos usuarios, los recupera bien TODOS
}
