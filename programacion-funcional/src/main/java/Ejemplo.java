import java.util.function.Function;

public class Ejemplo {

	public static void main(String[] args) {
		
		// Programación funcional:
		// Cuando el lenguaje me permite que una variable apunte a una función.
		// La cuestión es el impacto de esto a la hora de escribir código... y es gigante
		// Desde el momento que puedo hacer eso, puedo:
		// - Crear una función que reciba como argumentos otras funciones
		// - Crear una función que devuelva otras función
		
		System.out.println(doblar(10));		// Statement
		int numero = 5+7;					// Statement
					 /// 					   Expresión
		String texto = "hola";
		// Hemos asignado el valor "hola" a la variable "texto"
		// Hemos asignado la variable "texto" al valor "hola"
		// La variable no es un cajoncito donde meto cosas... Al menos eso no es una variable en JAVA
		// Cosas que hemos hecho en esa linea?
		// - "hola": 	Crea un objeto de tipo String con valor "hola"... donde? en RAM... en que sitio? NPI
		// - String texto: Crea una variable que puede apuntar a objetos de tipo String
		// - = :		Asigno la variable al objeto "hola"
		texto = "adios";
		// Cosas que hemos hecho en esa linea?
		// - "adios": 	Crea un objeto de tipo String con valor "adios"... donde? en RAM... en que sitio? En otro distinto
		// - texto = :    Asigno la variable al objeto "adios"
		// En ese momento "hola" se convierte en Basura-> garbage, ya que no hay ninguna variable que apunte a ese Objeto
		// Y en algún momento o no entrará el Recolector de Basura (GarbageCollector) a eliminar de la RAM... y dejar hueco para escribir cosas nuevas.

		 Function<Integer, Integer> miFuncion = Ejemplo::doblar;		// :: Referenciar una función Operador nuevo en Java 1.8
		 System.out.println(miFuncion.apply(20));
		 imprimirResultadoOperacion(miFuncion, 30);
		 imprimirResultadoOperacion(Ejemplo::doblar, 50);
		 
		 // Optativamente podemos hacer uso de otro operador que sale en Java 1.9: Lamdba (->), que permite crear expresiones lambda
		 // Expresion lambda? 
		 // - Es una EXPRESSION: Una porción de código que devuelve un valor
		 // - Lo que devuelve es una referencia a una función ANONIMA creada dentro de la expresión
		 Function<Integer, Integer> miFuncion2 = Ejemplo::doblar;
		 										 /// Una referencia a una función que exista
		 Function<Integer, Integer> miFuncion3 = (Integer numero2) -> {
																	return numero2*2;
																};
												 /// Una referencia a una función que se acaba de crear en RAM
		 imprimirResultadoOperacion(miFuncion3, 7);
		 
		 Function<Integer, Integer> miFuncion4 = (numero4) -> {	// Inferencia de tipos
																		return numero4*2;
													  				};
		 Function<Integer, Integer> miFuncion5 = numero5 -> {	
																	return numero5*2;
																};
		 Function<Integer, Integer> miFuncion6 = numero6 -> numero6*2;

		 imprimirResultadoOperacion( num -> num * 20, 7);

	}
	
	public static int doblar(int numero) {
		return numero*2;
	}
	
	public static void imprimirResultadoOperacion(Function<Integer, Integer> operacion, int numero) {
		System.out.println(operacion.apply(numero));
	}
	
}
