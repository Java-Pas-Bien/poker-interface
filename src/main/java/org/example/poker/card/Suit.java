package org.example.poker.card;

public enum Suit {
    P("\u2660"), C("\u2665"), K("\u2666"), T("\u2663");

    public final String symbol;
    Suit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
