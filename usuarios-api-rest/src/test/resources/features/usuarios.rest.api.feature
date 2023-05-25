#language:es

Característica: API REST del servicio de usuarios

	Antecedentes:
	      Dado que tengo un usuario
	      	 Y el usuario tiene por nombre "Ivan"
	      	 Y el usuario tiene por apellidos "Osuna"
	      	 Y el usuario tiene por edad 44
	      	 Y el usuario está guardado en mi sistema
	         Y que tengo un usuario
	      	 Y el usuario tiene por nombre "Menchu"
	      	 Y el usuario tiene por apellidos "García"
	      	 Y el usuario tiene por edad 27
	      	 Y el usuario está guardado en mi sistema

	Esquema del escenario: Recuperar usuarios
   	  Cuando invoco al servicio rest "/api/v1/usuarios" con método "get"
	  Entonces se recibe una respuesta con código "OK"
	         Y la respuesta debe contener un json
	         Y ese json debe contener una lista de longitud 2
	         Y el elemento en la posicion <posicion> debe tener por "nombre": "<nombre>"
	         Y el elemento en la posicion <posicion> debe tener por "apellidos": "<apellidos>"
	         Y el elemento en la posicion <posicion> debe tener por "edad": <edad>
	         
					Ejemplos:	        
					| posicion | nombre | apellidos | edad 	|
					| 1 			 | Ivan 	| Osuna 		| 44 		|
					| 2 			 | Menchu | García 		| 27 		|


	Escenario: Recuperar un usuario que existe
   	  Cuando invoco al servicio rest "/api/v1/usuarios/1" con método "get"
	  Entonces se recibe una respuesta con código "OK"
	         Y la respuesta debe contener un json
	         Y que tener por "id": 1
	         Y que tener por "nombre": "Ivan"
	         Y que tener por "apellidos": "Osuna"
	         Y que tener por "edad": 44
	         
	Escenario: Recuperar un usuario que NO existe
   	  Cuando invoco al servicio rest "/api/v1/usuarios/021215841" con método "get"
	  Entonces se recibe una respuesta con código "NOT_FOUND"
	         
	Escenario: Borrar un usuario que existe
   	  Cuando invoco al servicio rest "/api/v1/usuarios/1" con método "delete"
	  Entonces se recibe una respuesta con código "OK"
	         Y la respuesta debe contener un json
	         Y que tener por "id": 1
	         Y que tener por "nombre": "Ivan"
	         Y que tener por "apellidos": "Osuna"
	         Y que tener por "edad": 44
	         
	Escenario: Borrar un usuario que NO existe
   	  Cuando invoco al servicio rest "/api/v1/usuarios/021215841" con método "delete"
	  Entonces se recibe una respuesta con código "NOT_FOUND"
	         
