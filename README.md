# Descripción

Este proyecto fue un ejercicio de clase donde nos pedían programar un juego del ahorcado en java con una interfaz gráfica

# Requisitos para ejecutar

- Tener instalados tanto java como el SDK de java

## Como ejecutar

- navegar con la terminal hasta la ubicación del archivo main.java dentro del paquete "main"
- Compilar el proyecto

````shell
javac *.java
````

- Ejecutar el proyecto
  - Primero es necesario navegar hasta la carpeta raiz del proyecto y ejecutar el siguiente comando

```` shell
java -cp src main.Main
````

# Como jugar

El juego elegirá automáticamente una palabra al azar de las que tiene guardadas. Tendrás 5 errores permitidos y un máximo de 10 intentos. Primero se introduce una letra en la casilla indicada y se pulsa el botón "introducir letra" si la letra introducida es correcta se sustituirán los asteriscos correspondientes por esa letra. en caso de ser incorrecta se añadirá una imagen a la derecha iniciando el dibujo del ahorcado. Cuando creas que conoces la palabra introdúcela en el recuadro "Introduce la palabra" y pulsa el botón "Completar". Si aciertas el juego habrá terminado con un mensaje de felicitaciones y unas estadisticas. Si fracasas se restará otro intento.
