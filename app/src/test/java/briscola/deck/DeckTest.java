package briscola.deck;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
import java.util.Stack;

import static briscola.deck.Suit.SPADES;
import static briscola.deck.Value.ACE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeckTest {

    @Mock
    private Shuffler<Card> cardShuffler;

    @Test
    public void aa() {
        final Stack<Card> deck = prepareStack();
        when(cardShuffler.shuffle(anySet())).thenReturn(deck);

        final Deck sut = new Deck(cardShuffler, new Value[0], new Suit[0]);

        assertEquals(ACE.of(SPADES), sut.draw());
        assertTrue(sut.isEmpty());
    }

    private Stack<Card> prepareStack() {
        final Stack<Card> cards = new Stack<>();
        cards.push(ACE.of(SPADES));
        return cards;
    }
}