/*Ejercicio 4.2¶
Actualizar el ejercicio 1 para añadir a la clase el siguiente comportamiento:

·Debe retornar un saludo con su nombre... saludar():String
·Debe retornar si altura por encima de la media (solo altura >= 1.75)... alturaEncimaMedia():Boolean
·Debe retornar si peso por encima de la media (solo peso >= 70)... alturaEncimaMedia():Boolean
·Sería conveniente añadir también un método obtenerImcDesc() para usar en mostrarDesc(), que implemente el retorno de la descripción del rango de tipo de imc al que equivale su cálculo.
·Nota: * Si el IMC es menos de 18.5, se encuentra dentro del rango de "peso insuficiente". * Si el IMC está entre 18.5 y 24.9, se encuentra dentro del rango de "peso saludable". * Si el IMC está entre 25.0 y 29.9, se encuentra dentro del rango de "sobrepeso". * Si el IMC es 30.0 o superior, se encuentra dentro del rango de "obesidad".

·Debe implementar también un método que muestre una descripción completa de la persona... mostrarDesc():String. Por ejemplo, este método mostrará por pantalla algo así:

"Julia con una altura de 1.72m (Por debajo de la media) y un peso 64.7kg (Por encima de la media) tiene un IMC de 21,87 (peso saludable)".
2. Crear en el main() una estructura de datos con 4 o 5 personas más, recorrer la estructura y por cada persona debe saludar y mostrar su descripción completa.
·Finalmente, revisa el IDE e intenta actualizar el modificador de visibilidad de los métodos de tu clase cómo os estará indicando... veréis que los métodos que realmente no van a ser llamados desde fuera de la clase te recomienda que sean privados a la misma. De esta manera estamos encapsulando estos métodos para que se puedan utilizar solo desde dentro de la clase y no sean públicos.*/

class Persona(private var peso: Double, private var altura: Double){
    private var nombre: String = "Sin nombre"
    private val  imc : Double

    init {
        this.imc = this.peso / (this.altura * this.altura)
    }

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura){
        this.nombre = nombre
    }

    fun cambiarNombre() {
        do {
            println("Introduzca un nombre para cambiárselo a 'Sin nombre': ")
            val otroNombre = readln()
            if (otroNombre.isNotEmpty()){
                this.nombre = otroNombre
                break
            }
            else{
                println("**Nombre no válido** Este campo no puede estar vacío.")
            }
        }while (true)
    }

    override fun toString(): String{
        return "${this.nombre} tiene un peso de ${this.peso}kg, una altura de ${this.altura}."
    }


    fun saludar():String {
        return "Hola soy ${this.nombre}"
    }


    fun alturaEncimaMedia():Boolean {
        return when{
            this.altura >= 1.75 -> true
            else -> false
        }
    }

    fun pesoEncimaMedia():Boolean{
        return when{
            this.peso >= 70.0 -> true
            else -> false
        }
    }

    fun obtenerMediaPeso(): String{
        return when(pesoEncimaMedia()){
            true -> "Por encima de la media"
            false -> "Por debajo de la media"
        }
    }
    fun obtenerMediaAltura(): String{
        return when(alturaEncimaMedia()){
            true -> "Por encima de la media"
            false -> "Por debajo de la media"
        }
    }

    fun obtenerImc(): String{
        return when{
            (this.imc < 18.5) -> "peso insuficiente"
            (this.imc > 18.5 && this.imc < 24.9 ) -> "peso saludable"
            (this.imc > 25.0 && this.imc < 29.9) -> "sobrepeso"
            (this.imc >= 30.0) -> "obesidad"
            else -> ""
        }

    }

    fun mostrarDesc(): String{
        return "${this.nombre} con una altura de ${this.altura}m (${obtenerMediaAltura()}) y un peso ${this.peso}kg (${obtenerMediaPeso()}) tiene un IMC de ${"%.2f".format(this.imc)} (${obtenerImc()})"
    }
}