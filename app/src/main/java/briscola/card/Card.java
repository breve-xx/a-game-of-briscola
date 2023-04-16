package briscola.card;

public record Card(Value value, Suit suit) {
    
    @Override
    public String toString() {
        return value.value() + suit.suit();
    }
}
