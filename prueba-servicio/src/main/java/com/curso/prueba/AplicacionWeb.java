package com.curso.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Le indico a Spring, que esta app es de springboot
@SpringBootApplication
public class AplicacionWeb {
	
	public static void main(String[] args) {
		// MAS MAGIA: INVERSION DE CONTROL
		SpringApplication.run(AplicacionWeb.class, args); 
		// A partir de este punto, yo ya no controlo el flujo de la app
		// Spring es quien toma el control... Se lo delego
		// Spring: 
		// - Mirará si hay entidades que deban ser gestionadas contra una BBDD...y se conectará con esa BBDD
		// - Y se asegurará que tiene las tablas creadas... y con las columnas adecuadas
		// - Y mirará si necesito algún repositorio... y los crea
		// - Y Mirará si tengo servicios REST o SOAP... y los enchufará en mi app...
		// - Lo que tenga que hacer... ES SU PROBLEMA ... YO PASO !
		// Spring mira en este paquete: com.curso.prueba (ya veremos cómo hacer esto en otros paquetes)
		// - A ver si hay clases de tipo Entity o Repository o RestController
	}
	
}
