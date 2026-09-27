package com.example.miniproyectoescriturarapida.model;

import java.util.List;
import java.util.Random;

public class WordProvider {
    private final List<String> words = List.of("JavaFX", "Univalle", "Programación","Estudio", "Computador", "Tecnología");
    private final Random random = new Random();

    public String nextWord() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}