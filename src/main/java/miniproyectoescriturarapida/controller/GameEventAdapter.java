package miniproyectoescriturarapida.controller;

/**
 * Adaptador de {@link GameEventListener} con implementaciones vacías.
 * Permite a las subclases sobrescribir solo los eventos de interés.
 *
 * <p>Los métodos de la interfaz se dejan vacíos intencionalmente: la subclase
 * que los necesite los sobrescribe.</p>
 */
public abstract class GameEventAdapter implements GameEventListener {

    @Override
    public void onCorrectAnswer(int newLevel) {
    }

    @Override
    public void onIncorrectAnswer() {
    }

    @Override
    public void onTimeOut() {
    }

    @Override
    public void onLevelUp(int level) {
    }

    @Override
    public void onGameOver(int levelsCompleted, int remainingSeconds) {
    }
}
