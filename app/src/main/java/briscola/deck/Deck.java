package briscola.deck;

import java.util.Arrays;
import java.util.Set;
import java.util.Stack;

import static java.util.stream.Collectors.toSet;

public class Deck {

    private final Stack<Card> cards;

    public Deck(final Shuffler<Card> shuffler, final Value[] values, final Suit[] suits) {
        final Set<Card> sortedCards = Arrays.stream(values)
                .flatMap(value -> Arrays.stream(suits).map(suit -> new Card(value, suit)))
                .collect(toSet());
        this.cards = shuffler.shuffle(sortedCards);
    }

    public Card draw() {
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}