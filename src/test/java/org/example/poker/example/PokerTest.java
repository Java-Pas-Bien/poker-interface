package org.example.poker.example;

import org.example.poker.App;
import org.example.poker.PokerResult;
import org.example.poker.card.Card;
import org.example.poker.hand.Hand;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

public class PokerTest {

    @BeforeAll
    public static void globalSetUp() {
        // System.out.println("Ce code est exécuté une seule fois avant l'ensemble des tests");
    }

    @BeforeEach
    public void setUp() {
        // System.out.println("Ce code est exécuté avant chaque test");
    }

    /**************************
     * START TESTS
     **************************/

    @Test
    public void bestHandWin() {
        Set<Card> cardsP1 = new HashSet<>();
        cardsP1.add(Card.fromString("7T"));
        cardsP1.add(Card.fromString("2C"));
        cardsP1.add(Card.fromString("XP"));
        cardsP1.add(Card.fromString("VK"));
        cardsP1.add(Card.fromString("DC"));
        Hand player1 = new Hand(cardsP1);

        Set<Card> cardsP2 = new HashSet<>();
        cardsP2.add(Card.fromString("AT"));
        cardsP2.add(Card.fromString("2C"));
        cardsP2.add(Card.fromString("XP"));
        cardsP2.add(Card.fromString("VK"));
        cardsP2.add(Card.fromString("DC"));
        Hand player2 = new Hand(cardsP2);

        PokerResult result = App.compareHands(player1, player2);
        Assertions.assertEquals(PokerResult.Player2, result);
    }

    @Test
    public void bestHandWinWithDraw() {
        Set<Card> cardsP1 = new HashSet<>();
        cardsP1.add(Card.fromString("AT"));
        cardsP1.add(Card.fromString("2C"));
        cardsP1.add(Card.fromString("XP"));
        cardsP1.add(Card.fromString("VK"));
        cardsP1.add(Card.fromString("RC"));
        Hand player1 = new Hand(cardsP1);

        Set<Card> cardsP2 = new HashSet<>();
        cardsP2.add(Card.fromString("AT"));
        cardsP2.add(Card.fromString("2C"));
        cardsP2.add(Card.fromString("9P"));
        cardsP2.add(Card.fromString("VK"));
        cardsP2.add(Card.fromString("RC"));
        Hand player2 = new Hand(cardsP2);

        PokerResult result = App.compareHands(player1, player2);
        Assertions.assertEquals(PokerResult.Player1, result);
    }

    @Test
    public void bestHandWinWithPair() {
        Set<Card> cardsP1 = new HashSet<>();
        cardsP1.add(Card.fromString("2T"));
        cardsP1.add(Card.fromString("2C"));
        cardsP1.add(Card.fromString("8P"));
        cardsP1.add(Card.fromString("XK"));
        cardsP1.add(Card.fromString("DC"));
        Hand player1 = new Hand(cardsP1);

        Set<Card> cardsP2 = new HashSet<>();
        cardsP2.add(Card.fromString("XT"));
        cardsP2.add(Card.fromString("XC"));
        cardsP2.add(Card.fromString("9P"));
        cardsP2.add(Card.fromString("VK"));
        cardsP2.add(Card.fromString("DC"));
        Hand player2 = new Hand(cardsP2);

        PokerResult result = App.compareHands(player1, player2);
        Assertions.assertEquals(PokerResult.Player2, result);
    }

    @Test
    public void bestHandWinWith2Pairs() {
        Set<Card> cardsP1 = new HashSet<>();
        cardsP1.add(Card.fromString("2T"));
        cardsP1.add(Card.fromString("2C"));
        cardsP1.add(Card.fromString("RP"));
        cardsP1.add(Card.fromString("RK"));
        cardsP1.add(Card.fromString("7C"));
        Hand player1 = new Hand(cardsP1);

        Set<Card> cardsP2 = new HashSet<>();
        cardsP2.add(Card.fromString("2T"));
        cardsP2.add(Card.fromString("2C"));
        cardsP2.add(Card.fromString("RP"));
        cardsP2.add(Card.fromString("RK"));
        cardsP2.add(Card.fromString("7C"));
        Hand player2 = new Hand(cardsP2);

        PokerResult result = App.compareHands(player1, player2);
        Assertions.assertEquals(PokerResult.Draw, result);
    }

    /**************************
     * END TESTS
     **************************/

    @AfterEach
    public void tearDown() {
        // System.out.println("Ce code est exécuté après chaque test");
    }

    @AfterAll
    public static void globalTearDown() {
        // System.out.println("Ce code est exécuté une seule fois après l'ensemble des tests");
    }
}
