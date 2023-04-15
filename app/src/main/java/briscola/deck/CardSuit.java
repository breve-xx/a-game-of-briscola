package briscola.deck;

import com.google.common.base.MoreObjects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

import java.util.Objects;

public class CardSuit {
    private final Suit suit;
    private final Color color;

    public static CardSuit of(final Suit suit, final Color color) {
        return new CardSuit(suit, color);
    }

    private CardSuit(final Suit suit, final Color color) {
        this.suit = suit;
        this.color = color;
    }

    public Suit suit() {
        return suit;
    }

    public Color color() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardSuit cardSuit = (CardSuit) o;
        return suit == cardSuit.suit && color == cardSuit.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, color);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("suit", suit)
                .add("color", color)
                .toString();
    }
}