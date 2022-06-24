package org.example.poker;

import org.example.poker.card.Card;

public class Pair implements Combination {
    @Override
    public int compareTo(Combination other) {
        if (other instanceof Pair) {
            return 0;
        } else if (other instanceof NoThing) {
            return -1;
        } else {
            return 1;
        }
    }
}
