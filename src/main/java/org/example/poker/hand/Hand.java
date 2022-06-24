package org.example.poker.hand;

import org.example.poker.Combination;
import org.example.poker.DoublePair;
import org.example.poker.NoThing;
import org.example.poker.Pair;
import org.example.poker.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Hand {
    private final Set<Card> cards;

    public Hand(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<Card> getCards() {
        return this.cards.stream().collect(toSet());
    }

    @Override
    public String toString() {
        return this.cards.stream().map(Card::toString).collect(Collectors.joining(" ", "( ", " )"));
    }

    public Combination getCombination() {
        int pairsCount = this.pairs().size();
        if (pairsCount == 1) {
            return new Pair();
        } else if (pairsCount == 2) {
            return new DoublePair();
        } else {
            return new NoThing(this.bestCardFromHand());
        }
    }

    public Card bestCardFromHand () {
        Card bestCard = null;
        for (Card card : this.cards) {
            if (bestCard == null || bestCard.value.score < card.value.score) bestCard = card;
        }

        return bestCard;
    }

    public List<Integer> pairs () {
        List<Integer> duplicate = new ArrayList<>();

        this.cards.stream()
                // Creates a map {4:1, 5:2, 7:2, 8:2, 9:1}
                .collect(Collectors.groupingBy(Card::getScore, Collectors.counting()))
                .entrySet()
                // Convert back to stream to filter
                .stream()
                .filter(element -> element.getValue() == 2)
                // Collect elements to List and print out the values
                .collect(Collectors.toList())
                .forEach((item) -> duplicate.add(item.getKey()));

        return duplicate.stream().sorted().collect(Collectors.toList());
    }
}
