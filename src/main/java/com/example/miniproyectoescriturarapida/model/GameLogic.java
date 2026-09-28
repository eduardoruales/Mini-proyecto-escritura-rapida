package com.example.miniproyectoescriturarapida.model;

public class GameLogic {
    private final WordProvider wordProvider = new WordProvider();
    private String currentWord = wordProvider.nextWord();

    public boolean esRespuestaCorrecta(String textoEscrito) {
        boolean correcta = currentWord.equals(textoEscrito);
        return currentWord.equals(textoEscrito);
    }

    public void avanzarPalabra() {
        currentWord = wordProvider.nextWord();
    }

    public String getCurrentWord() {
        return currentWord;

    }

}
