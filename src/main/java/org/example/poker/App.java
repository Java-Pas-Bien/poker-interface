import org.example.poker.card.Card;
import org.example.poker.hand.Hand;

public class App {
    public static void main(String[] args) {
        Hand hand = new Hand(
                Card.fromString(args[0]),
                Card.fromString(args[1]),
                Card.fromString(args[2]),
                Card.fromString(args[3]),
                Card.fromString(args[4])
        );
        System.out.println(hand);
    }
}
