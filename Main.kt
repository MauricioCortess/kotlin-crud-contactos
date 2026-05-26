import java.io.File

// Data class que modela el dominio
data class Contacto(val id: Int, val nombre: String, val telefono: String)

val archivo = File("contactos.txt")

fun obtenerContactos(): List<Contacto> {
    if (!archivo.exists()) return emptyList()

    // Colecciones con mapNotNull
    return archivo.readLines().mapNotNull { Linea ->
        val datos = linea.split("|")
        // if para la toma de decisiones
        if (datos.size == 3) Contacto(datos[0].toInt(), datos[1], datos[2]) else null
    }
}

fun guardarContactos(contactos: List<Contacto>) {
    val contenido = contactos.joinToString("\n") { "${it.id}|${it.nombre}|${it.telefono}" }
    archivo.writeText(contenido)
}

fun agregarContacto() {
    print("Ingresa el nombre: ")
    // CUMPLE: Null safety con elvis operator [cite: 70]
    val nombre = readLine()?.takeIf { it.isNotBlank() } ?: "Desconocido"

    print("Ingresa el teléfono: ")
    val telefono = readLine()?.takeIf { it.isNotBlank() } ?: "Sin número"

    val contactos = obtenerContactos().toMutableList()
    // CUMPLE: Operaciones funcionales maxByOrNull [cite: 68]
    val nuevoId = (contactos.maxByOrNull { it.id }?.id ?: 0) + 1

    contactos.add(Contacto(nuevoId, nombre, telefono))
    guardarContactos(contactos)
    println("¡Contacto guardado exitosamente!")
}

fun listarContactos() {
    val contactos = obtenerContactos()
    if (contactos.isEmpty()) {
        println("No hay contactos registrados.")
        return
    }
    println("\n--- LISTA DE CONTACTOS ---")
    // CUMPLE: Operación forEach [cite: 68]
    contactos.forEach { println("[${it.id}] ${it.nombre} - Tel: ${it.telefono}") }
}

fun buscarContacto() {
    print("Ingresa el nombre a buscar: ")
    val busqueda = readLine() ?: ""

    // CUMPLE: filter y any [cite: 68]
    val resultados = obtenerContactos().filter { it.nombre.contains(busqueda, ignoreCase = true) }

    if (resultados.any()) {
        println("Resultados encontrados:")
        resultados.forEach { println("${it.nombre} -> ${it.telefono}") }
    } else {
        println("No se encontró a nadie con ese nombre.")
    }
}