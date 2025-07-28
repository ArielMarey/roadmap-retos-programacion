/*
 * EJERCICIO:
 * - Muestra ejemplos de creación de todas las estructuras soportadas por defecto
 *   en tu lenguaje.
 * - Utiliza operaciones de inserción, borrado, actualización y ordenación.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea una agenda de contactos por terminal.
 * - Debes implementar funcionalidades de búsqueda, inserción, actualización
 *   y eliminación de contactos.
 * - Cada contacto debe tener un nombre y un número de teléfono.
 * - El programa solicita en primer lugar cuál es la operación que se quiere realizar,
 *   y a continuación los datos necesarios para llevarla a cabo.
 * - El programa no puede dejar introducir números de teléfono no numéricos y con más
 *   de 11 dígitos (o el número de dígitos que quieras).
 * - También se debe proponer una operación de finalización del programa.
 */

// En Kotlin hay 3 tipos de estructuras: List, Set, y Map

// List: Almacena objetos en el orden en que se agregan. Soporta duplicados
// listOf() crea una lista solo de lectura
// mutableListOf() crea una lista modificable
// Para declarar el tipo de objetos en una lista se agrega el tipo entre <> despues de la declaracion
// val x: MutableList<String>

val familiares = listOf("Marco", "Tavo", "Max", "Javier", "Humberto")
val amigos = mutableListOf("Fernando", "Catalina", "Sebastian", "Alonso")

// Se puede acceder a los elementos de las listas por su index (parte desde 0) con []
// Tambien se puede acceder al primer o ultimo elemento de la lista con la extension .first() y .last()

fun getFamPl(x: Int): String {
    println(familiares[x])
    return familiares[x]    
}

// Con la extension .count() se puede saber cuantos elementos hay en una lista

fun getFrnQt(): Int {
    return amigos.count()
}

// Con el operador in se puede chequear que un elemento este en una lista

fun frnChk(): Boolean {
    return "Tavo" in amigos
}

// con las extensiones .add y .remove se pueden modificar las listas mutables

fun frnAdd(name: String) {
    amigos.add(name)
}

fun frnRem(name: String) {
    amigos.remove(name)
}

// Set
// Basicamente es una lista pero sin ningun orden ni admision de duplicados
// setOf() crea un set solo de lectura
// mutableSetOf() crea un set modificable
// Para declarar el tipo de objetos en un set se agrega el tipo entre <> despues de la declaracion
// val x: MutableSet<String>
// En caso de que se intente agregar un elemento duplicado, simplemente se ignora
// Excepto por el acceso por index [], el Set se comporta de la misma manera que una List

// Map
// Basicamente es una lista de pares de valores. Los valores se enlazan con "to"
// mapOf() crea un Map solo de lectura
// mutableMapOf() crea un Map modificable
// Para declarar el tipo de objetos en un Map se agrega el tipo entre <> despues de la declaracion
// val x: MutableMap<String>
// Como es una lista ordenada, se puede acceder a los elementos por index [] indicando el primer valor

val precios = mutableMapOf("Pan" to 200, "Galleta" to 500, "Cocada" to 1100, "Cafe" to 2100, "Agua" to 600)

// Para agregar elementos a un Map, en vez del .add se utiliza la siguiente syntaxis

fun addPrecio(item: String, precio: Int) {
    precios[item] = precio
    println(precios)
}

// Para eliminar elementos se utiliza el .remove . El .count tambien funciona de la misma manera que antes
// Se puede chequear un elemento especifico en un Mapa usando .containsKey()

fun chkIt(item: String): Boolean {
    return precios.containsKey(item)
}

// Se puede obtener por separado la Key y el valor de un Map utilizando las propiedades .keys y .values

fun separarMap() {
    println(precios.keys)
    println(precios.values)
}

// Para chequear si algo se encuentra en un mapa, independiente de si es Key o Value, se puede usar el in

fun srchMap(item: String): Boolean {
    return (item in precios)
}

fun main() {
    println(srchMap("Cocada"))    
}
