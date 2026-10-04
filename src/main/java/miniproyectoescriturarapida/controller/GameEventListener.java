package miniproyectoescriturarapida.controller;

/**
 * Interfaz de escucha de eventos del juego de escritura rápida.
 * Las clases que quieran reaccionar a los eventos del juego deben
 * implementar esta interfaz (o extender {@link GameEventAdapter}).
 */
public interface GameEventListener {

    /**
     * Se invoca cuando el jugador escribe correctamente la palabra.
     *
     * @param newLevel nuevo nivel alcanzado
     */
    void onCorrectAnswer(int newLevel);

    /**
     * Se invoca cuando el jugador escribe una palabra incorrecta.
     */
    void onIncorrectAnswer();

    /**
     * Se invoca cuando se agota el tiempo de un nivel.
     */
    void onTimeOut();

    /**
     * Se invoca cuando el jugador sube de nivel.
     *
     * @param level nuevo nivel
     */
    void onLevelUp(int level);

    /**
     * Se invoca cuando la partida termina.
     *
     * @param levelsCompleted total de niveles completados
     * @param remainingSeconds tiempo restante del último nivel (si aplica)
     */
    void onGameOver(int levelsCompleted, int remainingSeconds);
}
