# Práctica: Implementación de Pila, Maven y Ofuscación

Este repositorio contiene la implementación manual de una estructura de datos tipo Pila (Stack), distribuida como una librería local mediante Maven, y un proyecto ejecutable diseñado para validar expresiones algebraicas. Además, incluye la configuración de seguridad mediante ofuscación de código con ProGuard.

## Estructura del Repositorio

* **umg.edu.gt.data-structure.stack:** Librería base que contiene la lógica manual de la Pila y el validador de símbolos.
* **stackHandler:** Aplicación principal que consume la librería y ejecuta la validación interactiva.
* **evidencias:** Carpeta con las capturas de pantalla sobre la ofuscación, ingeniería inversa y ejecución requeridas en la práctica.

## Requisitos del Sistema

* Java JDK 11 o superior
* Apache Maven

## Instrucciones de Compilación y Ofuscación

La ofuscación está configurada en ambos proyectos mediante un perfil de Maven. Para generar los artefactos (JAR normal y JAR ofuscado), ejecuta los siguientes comandos en la terminal.

1. Ingresé a la carpeta de la librería y compile y ofusqué
   `cd umg.edu.gt.data-structure.stack`
   `mvn clean package -Pobfuscate`
2. Ingresé a la carpeta de la librería y compile y ofusqué
   `cd ../stackHandler`
   `mvn clean package -Pobfuscate`
  
  Pero antes de hacer todo esto se tiene que modificar el archivo pom para que se adapté bien a la ofuscación mediante Proguard
  
# Prueba de Regresión
Para ejecutar la prueba funcional utilizando el código ofuscado, posicione la terminal en la carpeta stackHandler y ejecuté el siguiente comando
* java -jar target/stackHandler-0.0.3-SNAPSHOT-obf.jar "(a+b) * [c-d]"
## Análisis de Ingeniería Inversa (Parte D)

Al decompilar los archivos JAR ofuscados utilizando la herramienta JD-GUI, se concluye lo siguiente:

* **¿Qué tanto se dificulta la lectura?** La lectura se vuelve prácticamente imposible en la librería. La jerarquía de paquetes original (`impl`, `manual`) fue reemplazada por letras simples (`a.a.a.a`) y las variables perdieron sus nombres descriptivos.
* **¿Se pierde claridad estructural?** Sí, se pierde por completo. No es posible distinguir a simple vista qué clase corresponde al Nodo, cuál a la Pila o cuál al Validador.
* **¿Sigue siendo posible entender la lógica?** Aunque el bytecode decompilado permite intuir la estructura de bucles o condicionales, la total ausencia de nombres originales hace que descifrar el propósito matemático del algoritmo tome muchísimo tiempo.

## Conclusión de Ofuscación (Parte E)

A través de la prueba de regresión desde la consola, se confirmó que el programa lee y evalúa correctamente la expresión matemática insertada (`Es valida?: true`). Esto demuestra que la ofuscación aplicada con ProGuard protege eficazmente el código fuente contra la ingeniería inversa directa, sin alterar ni romper la lógica funcional y el comportamiento del sistema.
