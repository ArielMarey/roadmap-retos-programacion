// https://kotlinlang.org/

// esto es un comentario de una línea

/* esto es
 * un comentario
 * en varias líneas
 * */

// variables con los datos primitivos del lenguaje:

// Integers
val numeroEntero: Int = 17
val byte: Byte = 10
val numeroCorto: Short = 3
val numeroLargo: Long = 100000000000

// Unsigned integers es igual pero con una "U" antes del nombre (ej. UInt)
// Floating-Point Numbers (decimales). "Float" maneja hasta 6-7 decimales, 
// mientras que double maneja entre 15 y 16. Por defecto los decimales quedan
// asignados como "Double". Para asignar explícitamente el tipo "Float" se le debe
// poner una "f" al final del número

val decimalCorto: Float = 3.1416f
val decimalDoble: Double = 10.12345678912345

// Booleans
var verdad: Boolean = true

//Characters
var punto: Char = '.'

//Strings
var palabras: String = "Hola mundo!"


fun main() {
	println(palabras)
}
