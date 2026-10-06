package miniproyectoescriturarapida.controller;

/**
 * Listener interface for the typing game's events. Classes that want to
 * react to game events should implement this interface (or extend
 * {@link GameEventAdapter}).
 */
public interface GameEventListener {

    /**
     * Called when the player types the word correctly.
     *
     * @param newLevel the newly reached level
     */
    void onCorrectAnswer(int newLevel);

    /**
     * Called when the player types an incorrect word.
     */
    void onIncorrectAnswer();

    /**
     * Called when the level timer runs out.
     */
    void onTimeOut();

    /**
     * Called when the player advances to a new level.
     *
     * @param level the new level
     */
    void onLevelUp(int level);

    /**
     * Called when the game ends.
     *
     * @param levelsCompleted total levels completed
     * @param remainingSeconds time left on the last level (if applicable)
     */
    void onGameOver(int levelsCompleted, int remainingSeconds);
}
