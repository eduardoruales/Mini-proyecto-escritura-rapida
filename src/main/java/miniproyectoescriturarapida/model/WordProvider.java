package miniproyectoescriturarapida.model;

import java.util.List;
import java.util.Random;

/**
 * Provee palabras aleatorias para el juego de escritura rápida.
 */
public class WordProvider {

    private final List<String> words = List.of("JavaFX", "Univalle", "Programación", "Estudio", "Computador", "Tecnología");
    private final Random random = new Random();
    private String lastWord;

    /**
     * Retorna una palabra aleatoria distinta (en lo posible) de la anterior.
     *
     * @return nueva palabra
     */
    public String nextWord() {
        String word;
        do {
            word = words.get(random.nextInt(words.size()));
        } while (word.equals(lastWord) && words.size() > 1);
        lastWord = word;
        return word;
    }
}
