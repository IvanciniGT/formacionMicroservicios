package com.curso.usuarios.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.json.JSONObject;

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
// Con esto le decimos a cucumber, a través de JUNIT, dónde están los fichero de features
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
	private JSONObject objetoJson;
	
	public APIRestServicioUsuariosTest(ServicioDeUsuarios servicioDeUsuarios, MockMvc clienteHTTP) {
		this.servicioDeUsuarios = servicioDeUsuarios;
		this.clienteHTTP = clienteHTTP;
	}

	@Dado("que tengo un objeto JSON")
	public void que_tengo_un_objeto_json() {
		objetoJson = new JSONObject();
	}
	
	@Dado("que el objeto json tiene por campo {string} el valor {string}")
	public void que_el_objeto_json_tiene_por_campo_el_valor(String campo, String valor) throws Exception {
	    objetoJson.put(campo, valor);
	}
	
	@Dado("que el objeto json tiene por campo {string} el valor {int}")
	public void que_el_objeto_json_tiene_por_campo_el_valor(String campo, Integer valor) throws Exception {
	    objetoJson.put(campo, valor);
	}

	@Dado("que tengo un usuario")
	public void que_tengo_un_usuario() {
		usuario = new DatosNuevoUsuario();
	}
	
	@Dado("el usuario tiene por nombre {string}")
	public void el_usuario_tiene_por_nombre(String nombre) {
	    usuario.setNombre(nombre);
	}
	@Dado("el usuario tiene por nombreCompleto {string}")
	public void el_usuario_tiene_por_nombre_comlpeto(String nombre) {
	    usuario.setNombreCompleto(nombre);
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
	public void guardarUsuario() {
		servicioDeUsuarios.crearUsuario(usuario);
	}
	
	@Cuando("invoco al servicio rest {string} con método {string}")
	public void invoco_al_servicio_rest_con_método(String url, String metodo) throws Exception {
		switch(metodo) {
			case "get":
				respuesta = clienteHTTP.perform(MockMvcRequestBuilders.get(url));
				break;
			case "delete":
				respuesta = clienteHTTP.perform(MockMvcRequestBuilders.delete(url));
				break;
			case "post":
				respuesta = clienteHTTP.perform(MockMvcRequestBuilders.post(url)
																	  .contentType(MediaType.APPLICATION_JSON)
																	  .content(objetoJson.toString())
												);
				break;
			case "put":
				respuesta = clienteHTTP.perform(MockMvcRequestBuilders.put(url)
																	  .contentType(MediaType.APPLICATION_JSON)
																	  .content(objetoJson.toString())
												);
				break;
		}
	}
	
	@Entonces("se recibe una respuesta con código {string}")
	public void se_recibe_una_respuesta_con_código(String codigoRespuesta) throws Exception {
		switch(codigoRespuesta) {
			case "OK":
				respuesta.andExpect(status().isOk() );
				break;		
			case "CREATED":
				respuesta.andExpect(status().isCreated() );
				break;		
			case "NOT_FOUND":
				respuesta.andExpect(status().isNotFound() );
				break;
		}
	}
	
	@Entonces("la respuesta debe contener un json")
	public void la_respuesta_debe_contener_un_json() throws Exception {
	    respuesta.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	/*
	 * 	JSON										XML
		{
			"id": 1,
	        "nombre": "Ivan",
	        "apellidos": "Osuna",
	        "edad": 44
	    }
	 *	JSONPATH									XPATH
	 *  Me permite una sintaxis con la que extraer/localocar partes de un documento json
	 */
        
	@Entonces("ese json debe contener una lista de longitud {int}")
	public void ese_json_debe_contener_una_lista_de_longitud(Integer tamano) throws Exception {
	    respuesta.andExpect(jsonPath("$.*", IsCollectionWithSize.hasSize(tamano)));
	}
	
	@Entonces("el elemento en la posicion {int} debe tener por {string}: {string}")
	public void el_elemento_en_la_posicion_debe_tener_por(Integer posicion, String campo, String valor) throws Exception {
	    respuesta.andExpect(jsonPath("$["+(posicion-1)+"]."+campo, Matchers.is(valor)));
	}
	
	@Entonces("el elemento en la posicion {int} debe tener por {string}: {int}")
	public void el_elemento_en_la_posicion_debe_tener_por_entero(Integer posicion, String campo, Integer valor) throws Exception {
	    respuesta.andExpect(jsonPath("$["+(posicion-1)+"]."+campo, Matchers.is(valor)));
	}
	
	@Entonces("que tener por {string}: {string}")
	public void que_tener_por(String campo, String valor) throws Exception {
	    respuesta.andExpect(jsonPath("$."+campo, Matchers.is(valor)));
	}
	
	@Entonces("que tener por {string}: {int}")
	public void que_tener_por(String campo, Integer valor) throws Exception {
	    respuesta.andExpect(jsonPath("$."+campo, Matchers.is(valor)));
	}
}

