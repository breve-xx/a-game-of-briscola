package briscola.deck;

import briscola.card.Card;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

import static com.google.common.collect.Lists.newArrayList;

public class CardShuffler implements Shuffler<Card> {

    @Override
    public Stack<Card> shuffle(Collection<Card> elements) {
        final List<Card> cards = newArrayList(elements);
        final Stack<Card> shuffledDeck = new Stack<>();
        while (!cards.isEmpty()) {
            final int i = ThreadLocalRandom.current().nextInt(cards.size());
            final Card anyCard = cards.get(i);
            shuffledDeck.push(anyCard);
            cards.remove(anyCard);
        }
        return shuffledDeck;
    }
}