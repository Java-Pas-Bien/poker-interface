package org.example.poker.card;

public class Card {
    public final Value value;
    public final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "[" + this.value.toString() + this.suit.toString() + "]";
    }

    public static Card fromString(String string) {
        return new Card(
                Value.fromString(string.substring(0, 1)),
                Suit.valueOf(string.substring(1))
        );
    }
}
