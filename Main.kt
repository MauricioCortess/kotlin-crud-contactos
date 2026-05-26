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