package briscola.player;

import briscola.card.Card;
import briscola.card.Value;
import briscola.deck.Deck;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class Player {
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
        hand.add(deck.draw());
    }

    public boolean hadCards() {
        return hand.isEmpty();
    }

    public Card play() {
        final Card played = hand.stream()
                .findFirst()
                .orElseThrow();
        hand.remove(played);
        return played;
    }

    public void take(final Collection<Card> cards) {
        taken.addAll(cards);
    }

    public int points() {
        return taken.stream()
                .map(Card::value)
                .mapToInt(Value::points)
                .sum();
    }
}