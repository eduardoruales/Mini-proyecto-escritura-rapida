package miniproyectoescriturarapida.model;

import java.util.List;
import java.util.Random;

/**
 * Provides random words for the typing game.
 */
public class WordProvider {

    private final List<String> words = List.of("JavaFX", "Univalle", "Programación", "Estudio", "Computador", "Tecnología"); // Lista fija de palabras
    private final Random random = new Random(); // Generador de números aleatorios
    private String lastWord; // Última palabra entregada (para no repetirla)

    /**
     * Returns a random word, different (when possible) from the previous one.
     *
     * @return a new word
     */
    public String nextWord() {
        String word;
        do {
            word = words.get(random.nextInt(words.size())); // Elegir una posición al azar
        } while (word.equals(lastWord) && words.size() > 1); // Repetir si es igual a la anterior
        lastWord = word; // Guardar la palabra actual
        return word;
    }
}
