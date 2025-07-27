/*
 * EJERCICIO:
 * - Crea ejemplos utilizando todos los tipos de operadores de tu lenguaje:
 *   Aritméticos, lógicos, de comparación, asignación, identidad, pertenencia, bits...
 *   (Ten en cuenta que cada lenguaje puede poseer unos diferentes)
 * 
 * - Utilizando las operaciones con operadores que tú quieras, crea ejemplos
 *   que representen todos los tipos de estructuras de control que existan
 *   en tu lenguaje: Condicionales, iterativas, excepciones...
 * 
 * - Debes hacer print por consola del resultado de todos los ejemplos.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un programa que imprima por consola todos los números comprendidos
 * entre 10 y 55 (incluidos), pares, y que no son ni el 16 ni múltiplos de 3.
 *
 * Seguro que al revisar detenidamente las posibilidades has descubierto algo nuevo.
 */


var numero = 5
var numero2 = 6
val palabra = "Hola"


fun main() {
    // operadores aritméticos
    println("$numero + 1 es igual a ${numero + 1}") // suma
    println("$numero - 1 es igual a ${numero - 1}") // resta
    println("$numero multiplicado por 2 es igual a ${numero * 2}") // multiplicación
    println("$numero dividido en 2 es igual a ${numero / 2f}") // división. Para que la operación de un Float 
    														   // en vez de un Int debe declararse la constante 2 como float "2"
    println("El módulo de $numero dividido en 2 es igual a ${numero % 2}") // módulo
    
    
    // operadores comparación
    println("Es $numero menor que $numero2? ${numero < numero2}") // menor que
    println("Es $numero menor o igual que $numero2? ${numero <= numero2}") // menor o igual que
    println("Es $numero mayor que $numero2? ${numero > numero2}") // mayor que
    println("Es $numero mayor o igual que $numero2? ${numero >= numero2}") // mayor o igual que
    println("Es $numero igual que $numero2? ${numero == numero2}") // igual que
    println("Es $numero distinto que $numero2? ${numero != numero2}") // distinto que
    
    // operadores ++ y --
    println("Si a ${numero++}  le sumamos 1 da $numero")
    println("Si a ${numero--}  le restamos 1 da $numero")
    
    // operadores de asignación
    println("A $numero le sumamos 2 permanentemente") // suma y asignación
    numero += 2
    println("Ahora la variable numero es $numero")
    
    println("A $numero le restamos 1 permanentemente") // resta y asignación
    numero -= 1
    println("Ahora la variable numero es $numero")
    
    println("Multiplicamos $numero por 2 permanentemente") // multiplicación y asignación
    numero *= 2
    println("Ahora la variable numero es $numero")  
    
    println("Dividimos $numero por 4 permanentemente") // división y asignación
    numero /= 4
    println("Ahora la variable numero es $numero")
        
    println("Extraemos el módulo de $numero sobre 2 y le asignamos ese nuevo valor a la variable numero") // modulo y asignación
    numero %= 2
    println("Ahora la variable numero es $numero")
    
    // operadores lógicos
    var a = 2
    var b = 3
    println("La variable a y la b son iguales a 5? ${a==5 && b ==5}") // and
    println("Al menos una de las variables a o b son iguales a 3? ${a==3 || b ==3}") // or
    var c = a != b
    println(!c) // not
    println("$a $b y $c")
    
    //Operadores a nivel de bits
    println("a and b = ${a and b}")//and bit a bit
    println (" a or b = ${a or b}")// or bit a bit
    println(" a xor b = ${a xor b}")// xor bit a bit
    println("a.inv()= ${a.inv()}")// not bit a bit
    println("a shl b = ${a shl b}")// Desplazamiento de bits a la izquierda
    println("a shr b = ${a shl b}")//Desplazamiento de bits a la derecha
    println("a ushr b = ${a ushr b}")// Desplazamiento de bits a la derecha sin signo
    
    // estructuras de control condicionales
    // if
    
    if (palabra.contains("o")){
        println("La palabra $palabra contiene la letra 'o'")
    }else{
        println("La palabra $palabra no contiene la letra 'o'")
    }
    
    // when
    
    when (a){
        1 -> println("La variable $a es 1")
        2 -> println("La variable $a es 2")
        else -> println("La variable $a no es ni 1 ni 2")
    }
    
    // for
    
    for (d in 1..9){
        print(d)
    }
    
    // while
    
    while (a<6){
        println("El valor de la variable a es $a")
        a++
    }

    do{
        println("El nuevo valor de a es $a")
        a--
    }while (a>0)
    
    // breaks y continues
    
    for (d in 1..9){
        if(d == 4)break
        println(d)
    }
    
    for (d in 1..9){
        if(d == 4)continue
        println(d)
    }
    
    // manejo de errores
    
    try{
        val resultado = 10/0
    }catch (e:ArithmeticException){
        println("Error: Division por 0")
    }finally {
        println("Este bloque siempre se ejecuta")
    }
    
    desafio()
}
    /*DIFICULTAD EXTRA (opcional):
 * Crea un programa que imprima por consola todos los números comprendidos
 * entre 10 y 55 (incluidos), pares, y que no son ni el 16 ni múltiplos de 3.
 * */
 
 fun desafio() {
     for (r in 10..55){
         if(r % 2 == 0 && r != 16 && r % 3 != 0){
             println(r)
             /*
         if (r % 3 == 0){
             continue
         }
         if (r == 16){
             continue        
         }
         if (r % 2 == 0){
             println(r)*/
         }
     }
     
     
     
 }
