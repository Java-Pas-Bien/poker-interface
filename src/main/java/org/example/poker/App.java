package org.example.poker;

import org.example.poker.card.Card;
import org.example.poker.hand.Hand;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Set<Card> cards = new HashSet<>();
        cards.add(Card.fromString(args[0]));
        cards.add(Card.fromString(args[1]));
        cards.add(Card.fromString(args[2]));
        cards.add(Card.fromString(args[3]));
        cards.add(Card.fromString(args[4]));
        Hand hand = new Hand(cards);

        System.out.println(hand);
    }

    public static PokerResult compareHands(Hand player1, Hand player2) {
        Combination typeHandPlayer1 = player1.getCombination();
        Combination typeHandPlayer2 = player2.getCombination();

        int compare = typeHandPlayer1.compareTo(typeHandPlayer2);
        if (compare == -1) {
            return PokerResult.Player1;
        } else if (compare == 1) {
            return PokerResult.Player2;
        } else {
            if (typeHandPlayer1 instanceof NoThing) {
                return compareNoThingHands(player1, player2);
            }
            if (typeHandPlayer1 instanceof Pair || typeHandPlayer1 instanceof DoublePair) {
                return comparePairHands(player1, player2);
            }
            // if DoublePair
            // if Brelan
            // if Carre
            // if Suite
        }

        /*Set<Map.Entry<Integer, Long>> pairsPlayer1 = player1.pairs();
        Set<Map.Entry<Integer, Long>> pairsPlayer2 = player2.pairs();

        if (pairsPlayer1.size() > 0 || pairsPlayer2.size() > 0) {
            //comparePairs(2, 6);
            return pairsPlayer1.size() > pairsPlayer2.size() ? PokerResult.Player1
                    : (pairsPlayer2.size() > pairsPlayer1.size() ? PokerResult.Player2 : compare(player1, player2));
        }*/

        return PokerResult.Draw;
    }

    private static PokerResult compareNoThingHands(Hand hand1, Hand hand2) {
        Card bestCardPlayer1 = hand1.bestCardFromHand();
        Card bestCardPlayer2 = hand2.bestCardFromHand();

        boolean totallyDraw = false;
        Set<Integer> drawCardValues = new HashSet<>();

        while(bestCardPlayer1.value.score == bestCardPlayer2.value.score) {
            drawCardValues.add(bestCardPlayer1.value.score);

            Hand tempPlayer1 = new Hand(hand1.getCards().stream()
                    .filter((card) -> !drawCardValues.contains(card.value.score))
                    .collect(Collectors.toSet()));

            Hand tempPlayer2 = new Hand(hand2.getCards().stream()
                    .filter((card) -> !drawCardValues.contains(card.value.score))
                    .collect(Collectors.toSet()));

            if (tempPlayer1.getCards().isEmpty() || tempPlayer2.getCards().isEmpty()) {
                totallyDraw = true;
                break;
            }

            bestCardPlayer1 = tempPlayer1.bestCardFromHand();
            bestCardPlayer2 = tempPlayer2.bestCardFromHand();
        }

        if (!totallyDraw) {
            return bestCardPlayer1.value.score > bestCardPlayer2.value.score ? PokerResult.Player1 : PokerResult.Player2;
        }

        return PokerResult.Draw;
    }

    private static PokerResult comparePairHands(Hand hand1, Hand hand2) {
        List<Integer> pairsHand1 = hand1.pairs();
        List<Integer> pairsHand2 = hand2.pairs();

        PokerResult result = PokerResult.Draw;

        for (int i = 0; i < pairsHand1.size(); i++) {
            if (pairsHand1.get(i) > pairsHand2.get(i)) {
                result = PokerResult.Player1;
            } else if (pairsHand2.get(i) > pairsHand1.get(i)) {
                result = PokerResult.Player2;
            }
        }

        if (result != PokerResult.Draw) {
            return result;
        } else {
            Hand tempHand1 = new Hand(hand1.getCards().stream()
                    .filter(card -> !pairsHand1.contains(card.getScore()))
                    .collect(Collectors.toSet()));

            Hand tempHand2 = new Hand(hand2.getCards().stream()
                    .filter(card -> !pairsHand2.contains(card.getScore()))
                    .collect(Collectors.toSet()));

            return compareNoThingHands(tempHand1, tempHand2);
        }
    }
}
