import java.io.File

// Data class que modela el dominio
data class Contacto(val id: Int, val nombre: String, val telefono: String)

val archivo = File("contactos.txt")