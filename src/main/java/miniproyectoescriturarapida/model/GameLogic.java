package miniproyectoescriturarapida.model;

/**
 * Core game logic for the typing game.
 * <p>
 * The player must type the displayed word before the timer runs out. Every
 * correct answer advances one level and every 5 levels the available time is
 * reduced by 2 seconds (minimum 2 seconds). The player starts with 3 lives;
 * a wrong answer or a timeout costs one life. When no lives remain, the
 * game ends.
 * </p>
 */
public class GameLogic {

    /** Initial time per level, in seconds. */
    private static final int INITIAL_TIME_SECONDS = 20;
    /** How many completed levels trigger a time reduction. */
    private static final int REDUCE_TIME_LEVELS = 5;
    /** Seconds reduced every {@value #REDUCE_TIME_LEVELS} levels. */
    private static final int REDUCE_TIME_SECOND = 2;
    /** Minimum allowed time per level, in seconds. */
    private static final int MIN_TIME_SECONDS = 2;
    /** Lives the player starts with. */
    private static final int INITIAL_LIVES = 3;

    private final WordProvider wordProvider = new WordProvider(); // Fuente de palabras
    private String currentWord = wordProvider.nextWord(); // Palabra que se muestra ahora
    private int currentLevel = 1; // Nivel actual, empieza en 1
    private int lives = INITIAL_LIVES; // Vidas del jugador

    /**
     * Checks whether the typed text matches the current word.
     *
     * @param textoEscrito text entered by the player
     * @return {@code true} if the answer is correct
     */
    public boolean itsCorrectAnswer(String textoEscrito) {
        return currentWord.equals(textoEscrito); // Compara el texto con la palabra actual
    }

    /** Advances to a new random word. */
    public void nextWord() {
        currentWord = wordProvider.nextWord(); // Pedir una nueva palabra al proveedor
    }

    /**
     * Gets the word the player must type.
     *
     * @return the current word
     */
    public String getCurrentWord() {
        return currentWord;
    }

    /** Advances the game by one level. */
    public void advanceLevel() {
        currentLevel++; // Incrementar el contador de nivel
    }

    /**
     * Gets the current game level.
     *
     * @return the current level (starts at 1)
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Computes the available time for the current level. 2 seconds are
     * reduced every 5 levels, never going below 2 seconds.
     *
     * @return available seconds for this level
     */
    public int getTimeForCurrentLevel() {
        int completedLevels = currentLevel - 1;              // Niveles ya superados
        int reductions = completedLevels / REDUCE_TIME_LEVELS; // Cada 5 niveles, una reducción
        int time = INITIAL_TIME_SECONDS - (reductions * REDUCE_TIME_SECOND); // Tiempo base menos reducción

        System.out.println("Nivel: " + currentLevel + " -> tiempo calculado: " + Math.max(time, MIN_TIME_SECONDS));

        return Math.max(time, MIN_TIME_SECONDS);             // Nunca bajar del mínimo
    }

    /** Removes one life from the player. */
    public void lostLife() {
        if (lives > 0) {
            lives--; // Restar una vida sin bajar de cero
        }
    }

    /**
     * Gets the remaining lives.
     *
     * @return number of lives (0 to 3)
     */
    public int getLives() {
        return lives;
    }

    /**
     * Indicates whether the game ended because no lives remain.
     *
     * @return {@code true} if no lives are left
     */
    public boolean isGameOver() {
        return lives <= 0; // Verdadero cuando no quedan vidas
    }
}
