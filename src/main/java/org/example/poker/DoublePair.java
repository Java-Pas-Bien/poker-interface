package org.example.poker;

public class DoublePair implements Combination {
    @Override
    public int compareTo(Combination other) {
        if (other instanceof DoublePair) {
            return 0;
        } else if (other instanceof Pair || other instanceof NoThing) {
            return -1;
        } else {
            return 1;
        }
    }
}
