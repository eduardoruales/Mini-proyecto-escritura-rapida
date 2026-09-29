package com.example.miniproyectoescriturarapida.model;

public class GameLogic {


    private static final int INITIAL_TIME_SECONDS = 20;
    private static final int REDUCE_TIME_LEVELS = 5;
    private static final int REDUCE_TIME_SECOND = 2;
    private static final int MIN_TIME_SECONDS = 2;

    private final WordProvider wordProvider = new WordProvider();
    private String currentWord = wordProvider.nextWord();
    private int currentLevel = 1;

    public boolean esRespuestaCorrecta(String textoEscrito) {
        return currentWord.equals(textoEscrito);
    }

    public void avanzarPalabra() {
        currentWord = wordProvider.nextWord();
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void advanceLevel() {
        currentLevel++;
    }
}