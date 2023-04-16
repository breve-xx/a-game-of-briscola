package briscola.deck;

import briscola.card.Card;
import briscola.card.Suit;
import briscola.card.Value;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

import static java.util.stream.Collectors.toSet;

public class Deck {

    private final Stack<Card> cards;
    private Card briscola;

    public Deck(final Shuffler<Card> shuffler, final Value[] values, final Suit[] suits) {
        final Set<Card> sortedCards = Arrays.stream(values)
                .flatMap(value -> Arrays.stream(suits).map(suit -> new Card(value, suit)))
                .collect(toSet());
        this.cards = shuffler.shuffle(sortedCards);
    }

    public void setBriscola() {
        briscola = cards.pop();
    }

    public boolean isBriscola(final Card card) {
        return Objects.equals(briscola.suit(), card.suit());
    }

    public Card draw() {
        if(cards.isEmpty()) {
            return briscola;
        }
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}