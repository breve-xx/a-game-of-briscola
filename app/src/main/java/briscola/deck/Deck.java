package briscola.deck;

import briscola.card.Card;
import briscola.card.Suit;
import briscola.card.Value;
import com.google.common.flogger.FluentLogger;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class Deck {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private final Stack<Card> cards;
    private final Card briscola;

    public Deck(final Shuffler<Card> shuffler, final Value[] values, final Suit[] suits) {
        final Set<Card> sortedCards = Arrays.stream(values)
                .flatMap(value -> Arrays.stream(suits).map(suit -> new Card(value, suit)))
                .collect(toSet());
        cards = shuffler.shuffle(sortedCards);
        briscola = cards.pop();
        logger.atInfo().log("Briscola set to %s", briscola);
        cards.add(0, briscola);
    }
    
    public boolean isBriscola(final Suit suit) {
        return Objects.equals(briscola.suit(), suit);
    }

    public Optional<Card> draw() {
        if(cards.empty()) {
            return Optional.empty();
        }
        return Optional.of(cards.pop());
    }
}