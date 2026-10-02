# Checklist de prueba — Escritura Rápida

## Temporizador
- [x] El temporizador inicia en 20 segundos (00:20) al comenzar una partida.
- [X] Cada segundo el tiempo disminuye en 1 s.
- [X] Al pasar 5 niveles, el tiempo se reduce en 2 segundos (p. ej. de 20 a 18).
- [X] El tiempo nunca baja de 2 segundos.
- [X] Al acertar una palabra, el nivel sube automáticamente y se reinicia el tiempo.

## Vidas
- [X] El jugador inicia con 3 vidas ("Vidas: 3").
- [X] Escribir una palabra incorrecta resta 1 vida y muestra "Incorrecto".
- [X] Si se agota el tiempo, resta 1 vida automáticamente y muestra "¡Tiempo agotado!".
- [X] Al perder la última vida, la partida termina y muestra el resumen.

## Mensajes
- [X] Al acertar: mensaje positivo ("¡Correcto! / ¡Nivel superado!").
- [X] Al fallar: mensaje claro de error ("Incorrecto", "¡Tiempo agotado!").
- [X] El campo de texto se colorea en verde (correcto) o rojo (incorrecto).

## Final de partida
- [X] Se muestra el resumen con el total de niveles completados.
- [x] Se muestra el tiempo restante (si aplica).
- [X] El botón "Reiniciar" permite jugar otra vez.
- [X] El botón "Volver al menú" regresa a la pantalla de inicio.

## Navegación y eventos
- [X] El botón "Iniciar partida" del menú carga el juego.
- [x] "Instrucciones" muestra el diálogo correspondiente.
- [x] "Salir" cierra la aplicación.
- [x] Presionar Enter en el campo valida la respuesta.
- [x] El botón "Validar" responde al clic del ratón.
