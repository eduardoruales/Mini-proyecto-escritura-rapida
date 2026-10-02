package miniproyectoescriturarapida.model;

/**
 * Contiene la lógica principal del juego de escritura rápida.
 * <p>
 * El jugador debe escribir correctamente la palabra mostrada antes de que se
 * agote el tiempo. Cada acierto sube de nivel y cada 5 niveles el tiempo
 * disponible se reduce en 2 segundos (mínimo 2 segundos). Cuenta con 3 vidas;
 * escribir mal o agotar el tiempo resta una vida. Cuando no quedan vidas,
 * la partida termina.
 * </p>
 */
public class GameLogic {

    /** Tiempo inicial por nivel, en segundos. */
    private static final int INITIAL_TIME_SECONDS = 20;
    /** Cada cuántos niveles completados se reduce el tiempo. */
    private static final int REDUCE_TIME_LEVELS = 5;
    /** Segundos que se reducen cada {@value #REDUCE_TIME_LEVELS} niveles. */
    private static final int REDUCE_TIME_SECOND = 2;
    /** Tiempo mínimo permitido por nivel, en segundos. */
    private static final int MIN_TIME_SECONDS = 2;
    /** Vidas con las que inicia el jugador. */
    private static final int INITIAL_LIVES = 3;

    private final WordProvider wordProvider = new WordProvider();
    private String currentWord = wordProvider.nextWord();
    private int currentLevel = 1;
    private int lives = INITIAL_LIVES;

    /**
     * Verifica si el texto escrito coincide con la palabra actual.
     *
     * @param textoEscrito texto ingresado por el jugador
     * @return {@code true} si la respuesta es correcta
     */
    public boolean esRespuestaCorrecta(String textoEscrito) {
        return currentWord.equals(textoEscrito);
    }

    /** Avanza a una nueva palabra aleatoria. */
    public void avanzarPalabra() {
        currentWord = wordProvider.nextWord();
    }

    /**
     * Obtiene la palabra que el jugador debe escribir.
     *
     * @return palabra actual
     */
    public String getCurrentWord() {
        return currentWord;
    }

    /** Sube un nivel al juego. */
    public void advanceLevel() {
        currentLevel++;
    }

    /**
     * Obtiene el nivel actual del juego.
     *
     * @return nivel actual (empieza en 1)
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Calcula el tiempo disponible para el nivel actual.
     * Se reducen 2 segundos cada 5 niveles, sin bajar de 2 segundos.
     *
     * @return segundos disponibles para este nivel
     */
    public int getTimeForCurrentLevel() {
        int completedLevels = currentLevel - 1;
        int reductions = completedLevels / REDUCE_TIME_LEVELS;
        int time = INITIAL_TIME_SECONDS - (reductions * REDUCE_TIME_SECOND);
        return Math.max(time, MIN_TIME_SECONDS);
    }

    /**
     * Resta una vida al jugador.
     */
    public void perderVida() {
        if (lives > 0) {
            lives--;
        }
    }

    /**
     * Obtiene las vidas restantes.
     *
     * @return número de vidas (0 a 3)
     */
    public int getLives() {
        return lives;
    }

    /**
     * Indica si la partida terminó por falta de vidas.
     *
     * @return {@code true} si no quedan vidas
     */
    public boolean isGameOver() {
        return lives <= 0;
    }
}
