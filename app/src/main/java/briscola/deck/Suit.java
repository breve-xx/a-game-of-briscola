package briscola.deck;

import static briscola.deck.Color.BLACK;
import static briscola.deck.Color.RED;

public enum Suit {
    HEARTS("♥", RED),
    DIAMONDS("♦", RED),
    CLUBS("♣", BLACK),
    SPADES("♠", BLACK);

    private final String suit;
    private final Color color;

    Suit(final String suit, final Color color) {
        this.suit = suit;
        this.color = color;
    }

    public String suit() {
        return suit;
    }

    public Color color() {
        return color;
    }
}