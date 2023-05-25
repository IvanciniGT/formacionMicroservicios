# Por donde comenzamos con el proyecto usuario-apirest?

- DTOs √
- Mapeo
- Implementar APIs
- Aplicación... otro proyecto!!

No vamos a empezar por ninguno de esos !
Vamos a empezar por ..... LAS PRUEBAS !

# TDD

Test driven development

REQUISITOS -> TEST <- DESARROLLO

## BDD

Behaviour driven development

Desarrollo dirigido por pruebas de comportamiento (Sistema)

## ATDD

Acceptance test driven development

## La gracia de definir primero los test es:

- De entrada me obliga a pensar en lo que tengo que implementar antes de implementarlo (controlar todos los casos)
- Me ayuda a definir/validar el API

---

Suministrador
	boolean tienesDiccionarioDe(String idioma)
	Optional<Diccionario> getDiccionario(String idioma)
	
Diccionario
	String getIdioma()
	boolean existe(String palabra)
	List<String> getSignificados(String palabra)
	List<String> getSugerencias(String palabra)

### Prueba 1: Preguntar por diccionario que existe

 	Suministrador.tienesDiccionarioDe("ES") -> true
 	
### Prueba 2: Preguntar por diccionario que no existe

 	Suministrador.tienesDiccionarioDe("ELFICO") -> false


 	Suministrador.tienesDiccionarioDe(null) -> false
 	Suministrador.tienesDiccionarioDe("") -> false
 	Suministrador.tienesDiccionarioDe("es") -> true

## Prueba 3: Recuperar un diccionario que existe
	
	Suministrador.getDiccionario("es") -> Me debería llegar un Optional con un diccionario dentro
										  -> El diccionario que se me entrega es el diccionario de español
	Optional<Diccionario> dict = Suministrador.getDiccionario("es") ;
	assertTrue(dict.isPresent());
	asserrEquals("ES",dict.getIdioma())
	
---


