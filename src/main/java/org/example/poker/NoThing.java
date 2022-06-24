package org.example.poker;

import org.example.poker.card.Card;

public class NoThing implements Combination {
    private final Card bestCard;

    public NoThing(Card bestCard) {
        this.bestCard = bestCard;
    }

    @Override
    public int compareTo(Combination other) {
        if (other instanceof NoThing) {
            return 0;
        } else {
            return -1;
        }
    }

    public Card bestCard() {
        return this.bestCard;
    }
}
