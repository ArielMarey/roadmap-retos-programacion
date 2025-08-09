import kotlin.system.exitProcess

/*
 * EJERCICIO:
 * - Muestra ejemplos de asignación de variables "por valor" y "por referencia", según
 *   su tipo de dato.
 * - Muestra ejemplos de funciones con variables que se les pasan "por valor" y
 *   "por referencia", y cómo se comportan en cada caso en el momento de ser modificadas.
 * (Entender estos conceptos es algo esencial en la gran mayoría de lenguajes)
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea dos programas que reciban dos parámetros (cada uno) definidos como
 * variables anteriormente.
 * - Cada programa recibe, en un caso, dos parámetros por valor, y en otro, por referencia.
 *   Estos parámetros los intercambia entre ellos en su interior, los retorna, y su retorno
 *   se asigna a dos variables diferentes a las originales. A continuación, imprime
 *   el valor de las variables originales y las nuevas, comprobando que se ha invertido
 *   su en las segundas.
 *   Comprueba también que se ha conservado el valor original en las primeras.
 */

/*
Gemini IA dice:
En Kotlin, las variables se pasan por valor, no por referencia como en otros lenguajes como C++.
Esto significa que al pasar una variable a una función, se crea una copia del valor (si es un tipo primitivo)
o una referencia al objeto (si es una referencia).
Sin embargo, Kotlin no permite la modificación directa de la referencia a la variable original dentro de la función,
como se haría con el paso por referencia en C++.
Paso por valor:
En Kotlin, al pasar una variable a una función, se crea una copia del valor de la variable.
Si la variable es un tipo primitivo (como un entero o un booleano), se copia el valor directamente.
Si es un tipo de referencia (como un objeto), se copia la referencia al objeto, no el objeto en sí.
No se puede modificar la referencia original:
Aunque se pase una referencia a un objeto, no se puede modificar la referencia dentro de la función para que apunte a un objeto diferente
y que ese cambio se refleje fuera de la función. La función solo puede modificar el estado del objeto referenciado,
pero no la dirección de memoria a la que apunta la referencia original.
Simulando el paso por referencia:
Aunque Kotlin no tiene la funcionalidad nativa de paso por referencia, se pueden utilizar ciertas técnicas para simular un comportamiento similar.
Una forma común es usar variables mutable que se pasan como parámetros y se modifican dentro de la función,
aunque esto no modifica directamente la referencia original sino que modifica el valor del objeto al que apunta.
 */

fun chalFun() {
    println("Primero, crearemos dos variables por valor:")
    var userPar1 = "str1"
    var userPar2 = "str2"
    println("La primera es \"userPar1\", y su valor es $userPar1.")
    println("La segunda es \"userPar2\", y su valor es $userPar2.")
    println("Ahora ingresa un nuevo valor para la primera variable:")
    userPar1 = readln()
    println("Ahora ingresa un nuevo valor para la segunda variable:")
    userPar2 = readln()
    println("Intercambiaremos el valor de las variables entre sí, y las almacenaremos en nuevas variables.")
    val newPar1 = userPar2
    val newPar2 = userPar1
    println("""Ahora tenemos 4 variables diferentes:
        |- La primera variable "userPar1" tiene su valor asignado por el usuario: ${userPar1}.
        |- La segunda variable "userPar2" también tiene su valor asignado por el usuario: ${userPar2}.
        |- La tercera variable "newPar1" tiene el valor de la variable "userPar2": ${newPar1}.
        |- Finalmente, la cuarta variable "newPar2" tiene el valor de la variable "userPar1": ${newPar2}.
    """.trimMargin())
}

fun main() {
    println("""
        En Kotlin existen dos formas de crear una variable, con "var" y con "val".
        Como sería de esperarse, "var", de "variable", se utiliza para crear un elemento cuyo valor puede variar,
        mientras que "val", de "value", se utiliza para crear un elemento cuyo valor es fijo.
        """.trimIndent())
    val abc = 123
    println("""
        Si creamos un "val" con un valor nativo, como un Int o una String, estamos creándola por valor:
        Escribiendo "val abc = 123" creamos un valor abc cuyo valor será fijo
        Si intentamos reasignarle un valor a "abc", el programa no funcionará.
        """.trimIndent())
    println("El valor de abc es $abc")
    var def = 123
    println("""
        Si creamos una variable, esta se puede modificar.
        Tomaremos la variable "def" con el valor $def y le asignaremos un nuevo valor con la siguiente operación:
        var def += 100
        """.trimIndent())
    def += 999
    println("Ahora, el valor de \"def\" es de $def")
    println("""
        Finalmente, se le puede pasar como referencia otra variable a una nueva variable. 
        Modificar la nueva variable no modifica el valor anterior. Se realizará la siguiente operación:
        var ghi = abc
        println("El valor de ghi es ${'$'}ghi")
        ghi += 777
        println("Ahora ghi vale ${'$'}ghi")
        println("Pero abc sigue valiendo ${'$'}abc")
        """.trimIndent())
    var ghi = abc
    println("El valor de ghi es $ghi")
    ghi += 777
    println("Ahora ghi vale $ghi")
    println("Pero abc sigue valiendo $abc")
    println("Ingresa 1 para ingresar al desafío, o cualquier otro input para salir.")
    val userInput: String = readln()
    when (userInput) {
        "1" -> chalFun()
        else -> exitProcess(0)
    }
}
