
# Pruebas de software

## Vocabulario que usamos en el mundo del testing

- Error: Los humanos cometemos ERRORES, y al hacerlo
- Defecto: introducimos DEFECTOS en los productos, que pueden manifestarse en forma de 
- Fallo: Manifestación de un DEFECTO

## Para qué sirven?

- Verificar el cumplimiento de unos requisitos
- Ayudarnos a identificar FALLOS -> Poniendo el sistema en funcionamiento y viendo si se comporta como debe o no.
	- Esto se hace mediante PRUEBAS DINAMICAS
	- Recopilar información para que nos sea facil identificar los DEFECTOS que han dado lugar a un fallo.
	- Ese proceso se llama: FALLO -> DEFECTO para posteriormente arreglarlo? DEPURACION: Debugging
- Ayudarnos a identificar DEFECTOS -> Mirando el sistema por dentro.. sin hacernos falta el ponerlo en funcionamiento.
	- Esto se hace mediante pruebas ESTATICAS, que no necesitan poner el sistema en funcionamiento: SONARQUBE
	- Esto es lo que antes hacía un Senior
- Ayudan a identificar ERRORES, mediante un análisis de causas raices. Viendo los DEFECTOS que tengo... saco conclusiones.
	- Tenemos muchos problemas en esta parte del código... por qué? No sabemos de esa tecnología concreta -> FORMACION
- Determinar el estado del proyecto > Metodologías ágiles
- Aumentar la confianza en el producto > DEVOPS

## DEVOPS

Movimiento en pro de la automatización.

Circuitos de:
- Integración Continua
	Cuando tengo automatizado las pruebas en un entorno de pruebas (Integración) continuamente de la última versión que los desarrolladores suben a un repo de git
- Entrega Continua
	Si las pruebas van bien, genero en automático una artefacto y pongo en disposición de mis clientes.
- Despliegue continuo
	Un paso más... si todo ha ido bien, instalo en automatico en producción sin intervención humana.

## Tipos de pruebas

### Por un lado en función del nivel de la prueba

- Unitarias		Prueba una característica de un componente AISLADO del sistema.		A	 B      A [MOCK - Man in the middle]
- Integración	Prueban la COMUNICACION entre componentes							A -> B
- Sistema		Prueban el COMPORTAMIENTO de sistema en su conjunto
- De aceptación Estas son las que hay que hacer por el articulo 33. Suelen ser un subconjunto de las anteriores.

### Por otro lado tenemos el OBJETO de prueba:

- Funcionales
- No funcionales:
 - Rendimiento
 - Alta disponibilidad
 - Estres
 - Carga
 - UX
 - ...

## Automatización de las pruebas

Por qué? porque las voy a hacer un huevo de veces, las mismas pruebas... diariamente!

Cada tipo de prueba tiene sus herramientas de automatización.

Para probar código usamos FRAMEWORKS DE PRUEBAS.
- Junit 


## Objetivo final

Tener un jar, que tenga dentro un tomcat que arranque un WebApp que dentro tenga un Servicio Rest

	Servidor de Aplciaciones: TOMCAT
		vvv
	Aplicación WEB										> Aplicación
		vvv
	Exportar este servicio JAVA mediante un API HTTP REST	> Exportación del servicio
		vvv
	Servicio JAVA
		vvv
	Repo JAVA para controlar Entidades JAVA















