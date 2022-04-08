package org.example.poker.example;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Cette classe est une suite de tests servant d'exemple et d'aide-mémoire de la syntaxe Java et JUnit.
// Elle n'est pas nécessaire à la réalisation de l'exercice.
public class CompteurTest {

    private final Predicate<Integer> estPair = (Integer nombre) -> (nombre % 2) == 0;

    @BeforeAll
    public static void globalSetUp() {
        System.out.println("Ce code est exécuté une seule fois avant l'ensemble des tests");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Ce code est exécuté avant chaque test");
    }

    @Test
    public void shouldAlwaysPass() {
        assertTrue(true);
    }

    @Test
    public void shouldCountOnlyTheNumbersCheckingThePredicate() {
        // Arrange
        Compteur compteur = new Compteur(estPair);
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        int expected = 2;

        // Act
        long actual = compteur.compte(input);

        // Assert
        assertEquals(expected, actual, "Compteur.count devrait trouver deux nombres pairs parmi 1, 2, 3, 4 et 5");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Ce code est exécuté après chaque test");
    }

    @AfterAll
    public static void globalTearDown() {
        System.out.println("Ce code est exécuté une seule fois après l'ensemble des tests");
    }

}
