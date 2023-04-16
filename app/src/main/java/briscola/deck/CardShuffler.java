package briscola.deck;

import briscola.card.Card;

import java.util.Collection;
import java.util.Stack;

public class CardShuffler implements Shuffler<Card> {

    @Override
    public Stack<Card> shuffle(Collection<Card> elements) {
        final Stack<Card> shuffledDeck = new Stack<>();
        while (!elements.isEmpty()) {
            final Card anyCard = elements.stream()
            .findAny()
            .orElseThrow();
            shuffledDeck.push(anyCard);
            elements.remove(anyCard);
        }
        return shuffledDeck;
    }
}