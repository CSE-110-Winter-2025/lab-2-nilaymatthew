package com.example.secards.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
        private final List<Flashcard> flashcards;

    public Deck(List<Flashcard> flashcards) {
        this.flashcards = List.copyOf(flashcards);
    }

    public int size() {
        return flashcards.size();
    }

    public Flashcard top() {
        return flashcards.get(0);
    }

    public static Deck forward(Deck deck) {
        var cards = new ArrayList<>(deck.flashcards);
        Collections.rotate(cards, -1);
        return new Deck(cards);
    }

    public static Deck backward(Deck deck) {
        var cards = new ArrayList<>(deck.flashcards);
        Collections.rotate(cards, 1);
        return new Deck(cards);
    }

    public static Deck shuffle(Deck deck) {
        var cards = new ArrayList<>(deck.flashcards);
        Collections.shuffle(cards);
        return new Deck(cards);
    }
}
