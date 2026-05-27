# Proyecto Mini Aplicación CRUD de Contactos por Consola

Este proyecto se desarrollo como una aplicación de línea de comandos (CLI) desarrollada en Kotlin que nos permite gestionar una agenda de contactos mediante operaciones de Creación, Lectura y Búsqueda (CRUD), simulando la persistencia de datos a través de un archivo de texto plano.

## Instrucciones de instalación y ejecución:
1. Clona este repositorio desde terminal de Windows Powershell o desde el entorno de desarrollo preferido compatible con Kotlin utilizando el comando:
   `git clone https://github.com/MauricioCortess/kotlin-crud-contactos.git`
2. Espera unos segundos a que el IDE reconozca el archivo `build.gradle.kts` y sincronice el proyecto automáticamente (Gradle descargará la librería estándar de Kotlin), Esto suele demorar unos 5 mn o más.
3. Haz clic en el botón verde de **Ejecutar (Run / Play ▶️) Que se encuentra hasta arriba o bien dentro del archivo Main.kt en la linea 67 alado debería salir un boton verde de Run** ubicado a la izquierda de la línea `fun main()`.
4. Interactúa con el menú directamente en la consola integrada de tu entorno. 
   *(Nota: El archivo `contactos.txt` para la persistencia de datos se generará automáticamente en la raíz del proyecto al agregar el primer registro).*

## Funcionalidades principales:
* Registro de nuevos contactos (Nombre y Teléfono).
* Listado completo de la agenda almacenada.
* Búsqueda dinámica de contactos por coincidencias de texto.
* Persistencia local de datos.

## Conceptos de Kotlin aplicados:
-Funciones, condicionales y ciclos | Uso de `while` en `main()`, y sentencias `if/when` para control de flujo y validaciones. |
-Colecciones con operaciones | Uso intensivo de `mapNotNull`, `filter`, `forEach` y `any` en la manipulación de la lista en memoria. |
-Null safety | Uso del operador Elvis (`?:`) y `takeIf` al recibir entradas del usuario por consola y al buscar IDs. |
-Data class | Implementación de `data class Contacto` para modelar las entidades del dominio. |

## Reflexión de proceso
**a) ¿Qué fue lo más difícil de este proyecto y cómo lo resolviste?**
Lo más complejo fue abstraer el manejo de datos en archivos planos en lugar de utilizar motores de bases de datos estructurados tradicionales. Tambien ajustar la lógica para que el archivo de texto simule la persistencia, gestionando correctamente los saltos de línea y el parseo de strings (usando `.split("|")`), se tuvo que asegurar la integridad de los datos de forma manual. Lo resolví apoyándome fuertemente en el mapeo de colecciones al momento de leer el archivo.

**b) ¿Hubo algún concepto de Kotlin que al principio no entendías y que ahora sí comprendes?**
Si, entender a fondo el paradigma funcional sobre las colecciones me era complicado. Al principio intentaba recorrer y modificar los arreglos con ciclos `for` tradicionales o iteradores manuales. Al comprender cómo encadenar operaciones como `filter` seguido de un `forEach`, me di cuenta de que el código se reduce drásticamente y es mucho más declarativo.

**c) Si tuvieras que mejorar o ampliar este proyecto, ¿qué le agregarías y por qué?**
Yo creo que migraría la persistencia a una base de datos real. Separaría la lógica de acceso a datos creando una pequeña API de backend o implementando un conector directo, además de aplicar encriptación a la lectura y escritura de los registros para mejorar la seguridad del sistema.

**d) ¿Qué aprendiste de este proyecto que no aprendiste solo leyendo o viendo videos?**
Por ejemplo aprendí la importancia del tipado estático estricto y el `null safety` en tiempo de compilación. En lenguajes de tipado dinámico, los errores por valores nulos suelen saltar hasta el tiempo de ejecución en el servidor, pero el compilador de Kotlin te obliga a proyectar y manejar el escenario de un valor faltante desde el momento en que estás escribiendo el código.
