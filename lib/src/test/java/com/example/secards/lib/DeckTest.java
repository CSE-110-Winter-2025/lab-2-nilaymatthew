package com.example.secards.lib;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeckTest {

    @Test
    public void top() {
        var deck = new Deck(List.of(
                new Flashcard("A", "1"),
                new Flashcard("B", "2"),
                new Flashcard("C", "3")
        ));
        var expected = new Flashcard("A", "1");
        var actual = deck.top();
        assertEquals(expected, actual);
    }

    @Test
    public void forward() {
        var deck = new Deck(List.of(
                new Flashcard("A", "1"),
                new Flashcard("B", "2"),
                new Flashcard("C", "3")
        ));
        var forwardedDeck = Deck.forward(deck);
        var expected = new Flashcard("B", "2");
        var actual = forwardedDeck.top();
        assertEquals(expected, actual);
    }

    @Test
    public void backward() {
        var deck = new Deck(List.of(
                new Flashcard("A", "1"),
                new Flashcard("B", "2"),
                new Flashcard("C", "3")
        ));
        var backwardDeck = Deck.backward(deck);
        var expected = new Flashcard("C", "3");
        var actual = backwardDeck.top();
        assertEquals(expected, actual);
    }

    @Test
    public void shuffle() {
        var deck = new Deck(List.of(
                new Flashcard("A", "1"),
                new Flashcard("B", "2"),
                new Flashcard("C", "3"),
                new Flashcard("D", "4"),
                new Flashcard("E", "5"),
                new Flashcard("F", "6"),
                new Flashcard("G", "7"),
                new Flashcard("H", "8"),
                new Flashcard("I", "9")
        ));
        // Test is non-deterministic, with a very small chance it could fail. ( ~ 1/300,000)
        var shuffledDeck = Deck.shuffle(deck);

        // Verify all cards are still in deck
        assertEquals(deck.size(), shuffledDeck.size());
        // Verify cards are not in the same order
        assertNotEquals(deck, shuffledDeck);
    }

    @Test
    public void size() {
        // Testing with decks from size 0 - 10
        for (int i = 0; i <= 10; i++) {
            List<Flashcard> cards = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                cards.add(new Flashcard("Question" + j, "Answer" + j));
            }

            var deck = new Deck(cards);
            assertEquals(i, deck.size());
        }
    }
}