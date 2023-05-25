package com.curso.usuarios.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.curso.usuarios.service.dto.DatosNuevoUsuario;

import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.spring.CucumberContextConfiguration;

// Es una suite de pruebas que generamos con Junit
@Suite
// Le indicamos a junit que delegue las pruebas a cucumber
@IncludeEngines("cucumber")
// Ponemos en marcha cucumber
@CucumberContextConfiguration
// Con esto le decimos a cucumber, dónde están los fichero de features
@SelectClasspathResource("features")
// Solicitar el arranque en paralelo de un servidor tomcat con mi app dentro para hacer pruebas
@SpringBootTest( classes = AplicacionTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// Permitir la inyección de dependencias
@ExtendWith(SpringExtension.class)
// Queremos que Spring nos provea de un cliente HTTP contra nuestro servidor de pruebas
@AutoConfigureMockMvc
public class APIRestServicioUsuariosTest {

	private ServicioDeUsuarios servicioDeUsuarios;
	private MockMvc clienteHTTP;
	private DatosNuevoUsuario usuario;
	private ResultActions respuesta;
	
	public APIRestServicioUsuariosTest(ServicioDeUsuarios servicioDeUsuarios, MockMvc clienteHTTP) {
		this.servicioDeUsuarios = servicioDeUsuarios;
		this.clienteHTTP = clienteHTTP;
	}

	@Dado("que tengo un usuario")
	public void que_tengo_un_usuario() {
		usuario = new DatosNuevoUsuario();
	}
	
	@Dado("el usuario tiene por nombre {string}")
	public void el_usuario_tiene_por_nombre(String nombre) {
	    usuario.setNombre(nombre);
	}
	
	@Dado("el usuario tiene por apellidos {string}")
	public void el_usuario_tiene_por_apellidos(String apellidos) {
	    usuario.setApellidos(apellidos);
	}

	@Dado("el usuario tiene por edad {int}")
	public void el_usuario_tiene_por_edad(Integer edad) {
	    usuario.setEdad(edad);
	}
	
	@Dado("el usuario está guardado en mi sistema")
	public void guardarUsuario(Integer edad) {
		servicioDeUsuarios.crearUsuario(usuario);
	}
	
	@Cuando("invoco al servicio rest {string} con método {string}")
	public void invoco_al_servicio_rest_con_método(String url, String metodo) throws Exception {
		switch(metodo) {
			case "get":
				respuesta = clienteHTTP.perform(MockMvcRequestBuilders.get(url));
				break;
		}
	}
	
	@Entonces("se recibe una respuesta con código {string}")
	public void se_recibe_una_respuesta_con_código(String codigoRespuesta) throws Exception {
		switch(codigoRespuesta) {
			case "OK":
				respuesta.andExpect(status().isOk() );
				break;		
			case "NOT_FOUND":
				respuesta.andExpect(status().isNotFound() );
				break;
		}
	}
	
	@Entonces("la respuesta debe contener un json")
	public void la_respuesta_debe_contener_un_json() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Entonces("ese json debe contener una lista de longitud {int}")
	public void ese_json_debe_contener_una_lista_de_longitud(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Entonces("el elemento en la posicion {int} debe tener por {string}: {string}")
	public void el_elemento_en_la_posicion_debe_tener_por(Integer int1, String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Entonces("el elemento en la posicion {int} debe tener por {string}: {int}")
	public void el_elemento_en_la_posicion_debe_tener_por(Integer int1, String string, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Entonces("que tener por {string}: {string}")
	public void que_tener_por(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Entonces("que tener por {string}: {int}")
	public void que_tener_por(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}

