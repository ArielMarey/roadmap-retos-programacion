import kotlin.system.exitProcess

/*
 * EJERCICIO:
 * - Muestra ejemplos de creación de todas las estructuras soportadas por defecto
 *   en tu lenguaje.
 * - Utiliza operaciones de inserción, borrado, actualización y ordenación.
 */

// En Kotlin hay 3 tipos de estructuras: List, Set, y Map

// List: Almacena objetos en el orden en que se agregan. Soporta duplicados
// listOf() crea una lista solo de lectura
// mutableListOf() crea una lista modificable
// Para declarar el tipo de objetos en una lista se agrega el tipo entre <> despues de la declaracion
// val x: MutableList<String>

/* val familiares = listOf("Marco", "Tavo", "Max", "Javier", "Humberto")
 val amigos = mutableListOf("Fernando", "Catalina", "Sebastian", "Alonso")

// Se puede acceder a los elementos de las listas por su index (parte desde 0) con []
// Tambien se puede acceder al primer o ultimo elemento de la lista con la extension .first() y .last()

 fun getFamPl(x: Int): String {
    println(familiares[x])
    return familiares[x]    
}

 Con la extension .count() se puede saber cuantos elementos hay en una lista

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
// Básicamente es una lista de pares de valores. Los valores se enlazan con "to"
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
*/
/* DIFICULTAD EXTRA (opcional):
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
 
 // en kotlin se utiliza la función "readln()" para leer inputs de usuarios

// Creación del "Map" que servirá como agenda
var agendaCont: MutableMap<String, Long> = mutableMapOf()

// Declaración de constantes para facilitar la inserción de texto repetitivo
const val srcCon = "1: Buscar contacto"
const val addCon = "2: Agregar nuevo contacto"
const val modCon = "3: Modificar contacto existente"
const val delCon = "4: Eliminar contacto"
const val clAgen = "5: Cerrar la agenda"

// función específica para imprimir el menú
fun printMenu() {
    println(srcCon)
    println(addCon)
    println(modCon)
    println(delCon)
    println(clAgen)
}

// Función de búsqueda de elementos en el Map
fun srcContact() {
    println("Has seleccionado la opción $srcCon")
    println("Por favor, ingresa el nombre del contacto que deseas buscar")
    val srcName = readln() // Leemos el input del usuario y lo guardamos en el valor srcName
    if (srcName in agendaCont.keys) { // Buscamos el input en el Map
        println("El teléfono del contacto '$srcName' es ${agendaCont[srcName]}") // Si el input existe en el Map, entregamos el valor asociado
    } else { // En caso de que no exista el input, se le dice al usuario
        println("El contacto de nombre '$srcName' no existe aún. Utiliza la función de agregar contacto para crearlo.")
    }
}

// Función para agregar elementos al Map
fun addContact() {
    println("Has seleccionado la opción $addCon")
    println("Por favor, ingresa el nombre del contacto que deseas agregar")
    val conName = readln() // Leemos el input del usuario y lo guardamos en el valor conName
    println("Agrega el número que deseas guardar para el contacto de '$conName'. El teléfono debe tener 9 dígitos y estar compuesto solo por números")
    val conTele = readln().toLongOrNull() // Leemos el segundo input del usuario y lo almacenamos en el valor conTele. El "toLongOrNull" se asegura de que el input sea exclusivamente numérico
    if (conTele.toString().length == 9) { // Nos aseguramos de que el input, además de ser un número, sea de 9 dígitos
        agendaCont[conName] = conTele as Long // Si se cumplen las condiciones anteriores, el valor se almacena asociado al primer input como un número del tipo "Long"
        println("Se ha agregado el contacto de nombre '$conName' con el teléfono '$conTele' de manera exitosa.")
    } else { // En caso de que el segundo input no haya pasado ambos chequeos, se le informa al usuario y se reinicia la función main
        println("El teléfono ingresado no es válido. Por favor ingresa un teléfono de 9 dígitos")
        addContact()
    }
}

// Función para modificar elementos existentes en el Map
fun modContact() {
    println("Has seleccionado la opción $modCon")
    println("Por favor, ingresa el nombre del contacto que deseas modificar")
    val modName = readln() // Leemos el input del usuario y lo guardamos en el valor modName
    if (agendaCont.containsKey(modName)) { // Verificamos que el input del usuario exista dentro del Map
        println("Se modificará el número del contacto de nombre '$modName'. Por favor, ingresa el nuevo número")
        val modTele = readln().toLongOrNull() // Leemos el segundo input del usuario y lo almacenamos en el valor modTele
        if (modTele.toString().length == 9) { // Nos aseguramos de que el input, además de ser un número, sea de 9 dígitos
            agendaCont[modName] = modTele as Long // Si se cumplen las condiciones anteriores, el valor se almacena asociado al primer input como un número del tipo "Long"
            println("Se ha actualizado el número del contacto de nombre '$modName' al teléfono '$modTele' de manera exitosa.")
        }
        else { // En caso de que el segundo input no haya pasado ambos chequeos, se le dice al usuario y se reinicia la función main
            println("El teléfono ingresado no es válido. Por favor ingresa un teléfono de 9 dígitos")
            modContact()
        }
    } else { // En caso de que el primer input no coincida con un valor del Map, se le informa al usuario y se reinicia la función main
        println("El contacto de nombre '$modName' no existe aún. Utiliza la función de agregar contacto para crearlo.")
    }
}

// Función para eliminar elementos existentes en el Map
fun delContacto() {
    println("Has seleccionado la opción $delCon")
    println("Por favor, ingresa el nombre del contacto que deseas eliminar")
    val delName = readln() // Leemos el input del usuario y lo almacenamos en el valor delName
    if (agendaCont.containsKey(delName)) { // Verificamos que el nombre del contacto ingresado existe en el Map
        agendaCont -= delName // Si el nombre ingresado existe, se elimina del Map
        println("Se ha eliminado el contacto de nombre '$delName'.")
    } else {
        println("No hace falta eliminar el contacto '$delName', ya que este no existe.") // En caso de que el input del usuario no coincida con ningún nombre, se le informa y se reinicia la función Main
    }
}

// Función para cerrar el programa
fun endAgenda() {
    println("Has seleccionado la opción $clAgen")
    println("La agenda se cerrará ahora. Adiós!")
    exitProcess(0)
}

// Función de error en caso de que el input del usuario no sea válido
fun errAgenda() {
    println("Por favor ingresa una opción válida (un número del 1 al 5)") // Se le informa al usuario que debe ingresar un input válido
}

fun main() {
    println("Bienvenido a tu agenda personal Kotlin. Por favor ingresa el número de la opción que deseas ejecutar")
    printMenu()
    val userInput = readln()
    when (userInput) {
        "1" -> srcContact()
        "2" -> addContact()
        "3" -> modContact()
        "4" -> delContacto()
        "5" -> endAgenda()
        else -> errAgenda()
    }
    main()
}
