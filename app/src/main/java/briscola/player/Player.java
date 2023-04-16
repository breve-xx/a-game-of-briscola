package briscola.player;

import briscola.card.Card;
import briscola.card.Value;
import briscola.deck.Deck;
import briscola.game.Dice;
import com.google.common.flogger.FluentLogger;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class Player {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private final String name;
    private final Set<Card> hand = new HashSet<>();
    private final Set<Card> taken = new HashSet<>();

    public Player(final String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void draw(final Deck deck) {
        deck.draw().ifPresent(drawn -> {
            logger.atInfo().log("%s drawn %s", name, drawn);
            hand.add(drawn);
        });
    }

    public boolean hadCards() {
        return hand.isEmpty();
    }

    public Card play() {
        final Card played = hand.stream()
                .findFirst()
                .orElseThrow();
        hand.remove(played);
        logger.atInfo().log("%s played %s", name, played);
        return played;
    }

    public void take(final Collection<Card> cards) {
        logger.atInfo().log("%s took %s", name, cards);
        taken.addAll(cards);
    }

    public int points() {
        return taken.stream()
                .map(Card::value)
                .mapToInt(Value::points)
                .sum();
    }

    public int roll(final Dice dice) {
        final int rolled = dice.roll();
        logger.atInfo().log("%s rolled: %d", name, rolled);
        return rolled;
    }
}