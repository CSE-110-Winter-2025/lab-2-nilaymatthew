package com.example.secards.lib;
import java.util.List;

public class PlaceholderData {
    public final static Deck DECK = new Deck(List.of(
            new Flashcard("SRP", "Single Responsibility Principle"),
            new Flashcard("OCP", "Open-Closed Principle"),
            new Flashcard("LSP", "Liskov Substitution Principle"),
            new Flashcard("ISP", "Interface Segregation Principle"),
            new Flashcard("DIP", "Dependency Inversion Principle"),
            new Flashcard("LKP", "Least Knowledge Principle (Law of Demeter)")
    ));
}
