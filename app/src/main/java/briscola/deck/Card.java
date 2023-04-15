package briscola.deck;

import java.util.Objects;

public record Card(Value value, Suit suit) {

    @Override
    public String toString() {
        return value.value() + suit.suit();
    }
}
