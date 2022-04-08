package org.example.poker.hand;

import org.example.poker.card.Card;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Hand {
    private final Set<Card> cards;

    public Hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
        this.cards = Arrays.stream(new Card[]{card1, card2, card3, card4, card5}).collect(toSet());
    }

    public Set<Card> getCards() {
        return this.cards.stream().collect(toSet());
    }

    @Override
    public String toString() {
        return this.cards.stream().map(Card::toString).collect(Collectors.joining(" ", "( ", " )"));
    }
}
