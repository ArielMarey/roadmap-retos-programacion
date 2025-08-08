import kotlin.system.exitProcess

/*
 * EJERCICIO:
 * Muestra ejemplos de todas las operaciones que puedes realizar con cadenas de caracteres
 * en tu lenguaje. Algunas de esas operaciones podrían ser (busca todas las que puedas):
 * - Acceso a caracteres específicos, subcadenas, longitud, concatenación, repetición, recorrido,
 *   conversión a mayúsculas y minúsculas, reemplazo, división, unión, interpolación, verificación…
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un programa que analice dos palabras diferentes y realice comprobaciones
 * para descubrir si son:
 * - Palíndromos: Palabra o frase que se puede leer en ambos sentidos.
 * - Anagramas: Palabras o frases que comparten sus mismos caracteres en distinto orden
 * - Isogramas: Palabras o frases cuyas letras se repiten la misma cantidad de veces (por ejemplo, "caca" tiene 2 letras c y 2 letras a.)
 */

// En Kotlin, las cadenas de texto se representan con la class "String"

/* Se pueden usar carácteres especiales poniéndoles un backslash antes del carácter en cuestión:
\t – tab

\b – backspace

\n – new line (LF)

\r – carriage return (CR)

\' – single quotation mark

\" – double quotation mark

\\ – backslash

\$ – dollar sign
*/
// También se pueden hacer cadenas de texto en múltiples líneas con comillas dobles triples """

// Para saber la cantidad de carácteres que componen una cadena de texto, se puede usar la propiedad .length, que retorna un valor entero.
fun strLongitude() {
    println("Ingresa una palabra para contar sus carácteres:")
    val ejemplo = readln()
    val ejLongitude: Int = ejemplo.length
    println("'$ejemplo' tiene $ejLongitude carácteres")
}

// Se pueden comparar 2 cadenas de texto con la función ".compareTo()". La comparación es entre los valores Unicode del primer carácter de la cadena.
// Retorna 0 si las cadenas de texto son iguales, un número negativo si la primera es menor que la segunda, y uno positivo en caso contrario.
// Si bien la comparación es básicamente alfabética, los tildes y carácteres especiales (ñ por ejemplo) deberían ser tratados de manera distinta según sus valores Unicode.
fun strCompare() {
    println("Ingresa una palabra para ordenar alfabéticamente con otra:")
    val ejemplo1 = readln()
    println("Ingresa la palabra para comparar alfabéticamente")
    val ejemplo2 = readln()
    val comparar1 = ejemplo1.compareTo(ejemplo2)
    if (comparar1 == 0) {println("Las palabras '$ejemplo1' y '$ejemplo2' comienzan con la misma letra.")}
    else if (comparar1 > 0) {println("Alfabéticamente, la palabra '$ejemplo1' está después que la palabra '$ejemplo2'.")}
    else {println("Alfabéticamente, la palabra '$ejemplo1' está antes que la palabra '$ejemplo2'.")}
}

// Para comprobar si dos cadenas de texto son iguales se puede utilizar el operador == a pesar de que existe el compare.To().
// Dicha operación genera un valor Boolean; True si ambas palabras son iguales, y False si son distintas.
// La comparación es case-sensitive.
fun strEquals() {
    println("Ingresa una palabra para chequear si es igual a otra:")
    val ejemplo1 = readln()
    println("Ingresa la palabra con la que quieres comprobar la igualdad")
    val ejemplo2 = readln()
    val equal = ejemplo1 == ejemplo2 // También se puede escribir como ejemplo1.equals(ejemplo2), pero usar el operador == es más práctico.
    if (equal) {println("Las palabras ingresadas son iguales.")}
    else {println("Las palabras ingresadas son distintas.")}
}

// Para obtener un carácter específico de una cadena de texto se puede usar la sintaxis "palabra[índice: Int]".
fun strGet () {
    println("Ingresa una palabra para extraer uno de sus caracteres:")
    val ejemplo1 = readln()
    val charNum = ejemplo1.length // Obtenemos la cantidad de caracteres que tiene la palabra ingresada para que el usuario sepa el rango numérico que puede poner.
    println("La palabra ingresada tiene $charNum caracteres. Ingresa un número del 1 al $charNum")
    val ejemplo2 = readln().toInt()
    val strInd = ejemplo1[ejemplo2 - 1] // También se puede escribir como ejemplo1.get(ejemplo2.toInt()), pero usar el operador de índex [] es más práctico.
    // Al valor de ejemplo2 se le resta 1 para que sea más intuitivo para el usuario, ya que se suele asumir que el primer elemento debería ser 1, no 0.
    println("El carácter en el lugar $ejemplo2 de la palabra es '$strInd'")
}

// hashCode ???

// Concatenación: Se combinan 2 cadenas de texto con el operador +. También existe la función .plus().
fun strCon () {
    println("Ingresa una palabra para combinarla con otra")
    val ejemplo1 = readln()
    println("Ingresa la palabra para combinar")
    val ejemplo2 = readln()
    val result = ejemplo1 + ejemplo2
    println("La combinación de ambas palabras es '$result'")
}

// Formateo de cadenas de texto:

fun strFormat () {
    println("Ingresa una frase para demostrar los posibles formateos")
    val ejemplo = readln()
    println("Se puede pasar todo el texto a mayúsculas: \n${ejemplo.uppercase()}")
    println("También todo a minúsculas: \n${ejemplo.lowercase()}")
    println("Con la extensión .trim() se puede recortar un carácter específico del inicio y el final de las cadenas de texto. Por defecto, recortará los espacios.")

}

// PENDIENTES: Búsquedas varias, slicing, split, eliminación de espacios, inlays,
// conversión a lista de chars y viceversa, transformación a otros tipos,  

// Desafío

fun palCheck (w: String) {
    val charList1 = w.filterNot { it.isWhitespace() }
    val charList2 = charList1.reversed()
    if (charList1 == charList2) {println("El texto ingresado \"$w\" es un palíndromo!")}
    else (println("El texto ingresado \"$w\" no es un palíndromo :("))
}

fun anaCheck (w1: String, w2: String) {
    val w1clean = w1.filterNot { it.isWhitespace() }
    val w2clean = w2.filterNot { it.isWhitespace() }
    val charList1 = w1clean.toCharArray().toList()
    val charList2 = w2clean.toCharArray().toList()
    if (charList1.size == charList2.size && charList1.containsAll(charList2) && charList2.containsAll(charList1)) {
        println("Los textos \"$w1\" y \"$w2\" son anagramas! Wow!")
    } else {
        println("Los textos \"$w1\" y \"$w2\" no son anagramas")
    }
}

fun isoCheck (w: String) {
    val charList = w.filterNot { it.isWhitespace() } // Convierte la palabra o frase en una lista de caracteres
    val charCount = charList.groupingBy { it }.eachCount() // Crea un mapa que asocia cada carácter con la cantidad de veces que aparece en la palabra o frase
    if (charCount.values.all { it == charCount.values.first()}) {println("El texto ingresado \"$w\" es un isograma :o")}
    else (println("El texto ingresado \"$w\" no es un isograma :("))

}

fun strChallenge () {
    println("""
        Este programa puede detectar si 2 palabras ingresadas son palíndromos, anagramas, y/o isogramas.
        - Un palíndromo es una palabra o frase que se puede leer tanto de derecha a izquierda como de izquierda a derecha sin variar el orden de sus letras.
        - Un anagrama es un conjunto de palabras o frases que comparten la misma cantidad de caracteres, pero en distinto orden.
        - Un isograma es una palabra o frase cuyos caracteres se repiten la misma cantidad de veces.
        Por favor, ingresa una palabra o frase para comparar con otra:
    """.trimIndent())
    val input1 = readln().lowercase()
    palCheck(input1)
    isoCheck(input1)
    println("Ahora ingresa otra palabra o frase")
    val input2 = readln().lowercase()
    palCheck(input2)
    isoCheck(input2)
    anaCheck(input1, input2)

}

fun main() {
    println(""" 
Selecciona una opción:
    1. Longitud de cadena de Texto
    2. Ordenar alfabéticamente
    3. Comparación de cadenas de texto
    4. Extraer un carácter de una cadena de texto
    5. Concatenación de cadenas de texto
    6. Formateo de texto
    7. Detector de palíndromos, anagramas, e isogramas
    
Ingresa cualquier otro input para salir del programa""")

    val input = readln()
    when (input) {
        "1" -> strLongitude()
        "2" -> strCompare()
        "3" -> strEquals()
        "4" -> strGet()
        "5" -> strCon()
        "6" -> strFormat()
        "7" -> strChallenge()
    else -> exitProcess(0)
    }
    main()
}
