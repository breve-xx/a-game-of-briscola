package briscola.deck;

public enum Value {
    ACE(1, 11),
    TWO(2),
    THREE(3, 10),
    FOUR(4, 0),
    FIVE(5, 0),
    SIX(6, 0),
    SEVEN(7, 0),
    JACK(8, 2),
    QUEEN(9, 3),
    KING(10, 4);

    private final int value;
    private final int points;

    Value(final int value) {
        this(value, 0);
    }

    Value(final int value, final int points) {
        this.value = value;
        this.points = points;
    }

    public int points() {
        return points;
    }

    public int value() {
        return value;
    }
    
    public Card of(final Suit suit) {
        return new Card(this, suit);
    }
}