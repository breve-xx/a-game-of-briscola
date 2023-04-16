package briscola.deck;

import briscola.card.Card;
import briscola.card.Suit;
import briscola.card.Value;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static briscola.card.Suit.HEARTS;
import static briscola.card.Suit.SPADES;
import static briscola.card.Value.ACE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeckTest {

    private final Shuffler<Card> noop = elements -> {
        final Stack<Card> stack = new Stack<>();
        ImmutableList.copyOf(elements).reverse().forEach(stack::push);
        return stack;
    };

    @Test
    public void givenAShufflerValuesAndSuitsThenShouldReturnAShuffledDeck() {
        final Deck sut = new Deck(noop, new Value[]{ACE}, new Suit[]{SPADES, HEARTS});

        assertEquals(ACE.of(HEARTS), sut.draw());
        assertEquals(ACE.of(SPADES), sut.draw());
        assertTrue(sut.isEmpty());
    }
}