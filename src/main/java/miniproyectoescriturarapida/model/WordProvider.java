package miniproyectoescriturarapida.model;

import java.util.List;
import java.util.Random;

/**
 * Provides random words for the typing game.
 */
public class WordProvider {

    private final List<String> words = List.of("JavaFX", "Univalle", "Programación", "Estudio", "Computador", "Tecnología", "Software", "Apuntes", "Listado", "Reciclaje", "Sistemas", "Procesos", "Escribir", "Rápido", "ChatGPT", "Inteligencia", "Colombia", "Python", "SQL", "Plugins", "Hardware", "IntelliJ", "Repositorio", "Torres", "Gemelas", "Tela", "Millonario", "Palabras", "Adios", "Chao", "Celular", "Computador", "GitHub", "Ventas", "Procesos", "Careta", "Quipitos", "Amigos", "Totem", "Decisión", "Opciones", "Árbol", "Querella", "Denuncia", "Patria", "Milagro", "Araña", "Aplausos", "Factorial", "Fibonacci", "Quirófano", "GOAT", "Volumen", "Perros", "Completar"); // Lista fija de palabras
    private final Random random = new Random(); // Random number generator
    private String lastWord; // Last delivered word (To no repeat)

    /**
     * Returns a random word, different (when possible) from the previous one.
     *
     * @return a new word
     */
    public String nextWord() {
        String word;
        do {
            word = words.get(random.nextInt(words.size())); // Choose random word
        } while (word.equals(lastWord) && words.size() > 1); // Repetir si es igual a la anterior
        lastWord = word; // Save current word
        return word;
    }
}
