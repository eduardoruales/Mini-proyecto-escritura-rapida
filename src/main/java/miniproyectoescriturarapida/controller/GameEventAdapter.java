package miniproyectoescriturarapida.controller;

/**
 * Adapter for {@link GameEventListener} with empty implementations.
 * Lets subclasses override only the events they care about.
 * <p>
 * Interface methods are intentionally left empty: the subclass that needs
 * them overrides them.</p>
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
