/*
  EJERCICIO:
  - Crea ejemplos de funciones básicas que representen las diferentes
    posibilidades del lenguaje:
    Sin parámetros ni retorno, con uno o varios parámetros, con retorno...
  - Comprueba si puedes crear funciones dentro de funciones.
  - Utiliza algún ejemplo de funciones ya creadas en el lenguaje.
  - Pon a prueba el concepto de variable LOCAL y GLOBAL.
  - Debes hacer print por consola del resultado de todos los ejemplos.
    (y tener en cuenta que cada lenguaje puede poseer más o menos posibilidades)
 
  DIFICULTAD EXTRA (opcional):
  Crea una función que reciba dos parámetros de tipo cadena de texto y retorne un número.
  - La función imprime todos los números del 1 al 100. Teniendo en cuenta que:
    - Si el número es múltiplo de 3, muestra la cadena de texto del primer parámetro.
    - Si el número es múltiplo de 5, muestra la cadena de texto del segundo parámetro.
    - Si el número es múltiplo de 3 y de 5, muestra las dos cadenas de texto concatenadas.
    - La función retorna el número de veces que se ha impreso el número en lugar de los textos.
 
  Presta especial atención a la sintaxis que debes utilizar en cada uno de los casos.
  Cada lenguaje sigue una convenciones que debes de respetar para que el código se entienda.
  */

// Variables globales

val instCuerda = listOf("Violin", "Viola", "Cello", "Contrabajo")

// Ejemplos de funciones

fun nombrarInstr1() { 										// funcion sin parametros
	for (instrumento in instCuerda) {
        println(instrumento)
    }
}

fun nombrarInstr(instrumento: String){						// funcion con parametros
    val instCheck = instrumento in instCuerda 				// variable local
    println("La orquesta tiene $instrumento? $instCheck")
}

fun getInstr(): String {									// funcion con return
    return instCuerda.find {it=="Violin"}.toString()
}

fun getInstSize() {											// funcion dentro de otra funcion
    fun instSize() {
        val size = mapOf("Violin" to "chico", "Viola" to "mediano", "Cello" to "grande", "Contrabajo" to "Gigante")
        for ((instCuerda, size) in size) {
            println("El $instCuerda es $size")
        }
    }
    println(instSize())
}

fun cusFizzBuzz(word1: String = "Fizz", word2: String = "Buzz"): Int {
    
    var w1Quant: Int = 0
    var w2Quant: Int = 0
    var w3Quant: Int = 0
    var nuQuant: Int = 0

    for (x in 1..100) {
        when {
            x % 15 == 0 -> {println("$word1$word2"); w3Quant++}
            x % 3 == 0 -> {println("$word1"); w1Quant++}      
            x % 5 == 0 -> {println("$word2"); w2Quant++}                      
         else -> 
            {println("$x"); nuQuant++}           
        }
    }
    println("La palabra $word1 se dijo $w1Quant veces.") 
    println("La palabra $word2 se dijo $w2Quant veces.")
    println("La combinacion de ambas se dijo $w3Quant veces.")
    println("Los numeros por si solos aparecieron $nuQuant veces.")
    return nuQuant
}

fun main() {							// funcion "main"
    println(nombrarInstr1())
    println(nombrarInstr("Viola"))
    println(getInstr())
    println(getInstSize())
    println(cusFizzBuzz("Manzana", "Pera"))
    
}
   
    
