
# Version 1.2.3 del proyecto

Me piden añadir el campo Genero
A qué versión del proyecto paso 1.3.0

Añadir el campo nombre completo: Nombre y apellidos
+ Deprecated nombre!!!!
+ Deprecated apellidos!!!!
A qué versión del proyecto paso 1.4.0

Quito el campo nombre y el campo apellidos:
A qué versión del proyecto paso 2.0.0 
										-> 1.5.0

Me llevo esto a una arquitectura de microservicios... donde estoy aplciaciondo una metodologóa AGIL !
Quizás hay 5 servicios que usan este... que llaman a este!

A	2.0x >
B	1.4x >				Servicio REST Usuarios v.1.5.0 	< Coexisten el tiempo... los cambios que haga en 2 , 
															deben permitir que 1 siga funcionando
C	2.0* >				Servicio REST Usaurios v.2.0.0	<
D	2.0x >
E	2.0* >


				Cuando los incrementamos?
				
1 - MAJOR		Cuando hacemos un cambio que no respeta retrocompatibilidad
				Quito cosas del api
					+ Nuevas funcionalidades
					+ Arreglos de bugs

2 - MINOR		Nueva funcionalidad
				Si marco una funcionalidad como DEPRECATED (Obsoleta)
					+ Arreglo de bugs

3 - PATCH		Arreglo de bugs. SOLO arreglo de bugs
	
---

Queremos montar un app para gestionar listas de tareas asociadas a los usuarios
Frontal JS...
Ese frontal v a estar trabajando contra unos servicios Back REST end que vamos a montar con springboot 


Usuarios -<	 >-	Listas de tareas --< Tareas
		 n    m					 1 n 
	



http://servidor:8080/listadosTareas/182746/usuarios
http://servidor:8080/listadosTareas/182746/tareas
http://servidor:8080/usuarios/127256372/listadosTareas

---

Los servicios, cuando estamos en una arquitectura de microservicios
querremos que se comuniquen entre si.

Esas comunicaciones las queremos SINCRONAS o ASINCRONAS ?

Depende
	
	Sincronas: A -> B		A espera
				 <-
	
	Asíncronas: A -> B					B -> A			A no espera
						fire & forget 			
	
	
	Llamada de telefono -> Síncrona
	Mensajes de Whatsapp -> Asíncrona
	
			A -> Whatsapp -> B		Whatsapp inyecta a B en mensaje
											RabbitMQ (push)
											
						   <- ?		B pregunta a Whatsapp.. tengo algo?
											Kafka (pull)

RabbitMQ, ActiveMQ, Kafka son sistemas de mensajería

Las sincronas tienen una costa... por ahí? Si B no está disponible? Se ha perdido la comunicación

Las asíncronas por su parte... aunque B no esté disponible A puede mandar su comunicación

Servicio que da de alta un usuario en netflix -> Meter los Datos en una BBDD (sincrona) (asincrona)
											  -> Mandar un email al usuario (asincrona)




1º IDENTIFIQUESE
2º AUTENTICARLO  Asegurarme que es quién dice ser!
3º AUTORIZARLO   Sabiendo ya quien eres... si te dejo hacer lo que quieres hacer.

Servidores de Autenticación/Autorización

ActiveDirectory
IAM de AWS
KeyCloack

Estas herramientas son las que emiten TOKENS DE ACCESO ... Protocolo OAuth2, donde los tokens son JSON
JWT Json Web Tokens








	