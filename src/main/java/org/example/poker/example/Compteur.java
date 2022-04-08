package org.example.poker.example;

import java.util.List;
import java.util.function.Predicate;

// Cette classe sert d'exemple et d'aide-mémoire de la syntaxe Java.
// Elle n'est pas nécessaire à la réalisation de l'exercice.
public class Compteur {
    // Un prédicat définit une condition à vérifier, ici sur un entier.
    // Il peut être vu comme une fonction qui prend un entier et renvoie vrai ou faux.
    private final Predicate<Integer> filtre;

    public Compteur(Predicate<Integer> filtre) {
        this.filtre = filtre;
    }

    public long compte(List<Integer> liste) {
        return liste.stream().filter(filtre).count() +1; // Supprimer le +1 pour faire passer le test.
    }
}
