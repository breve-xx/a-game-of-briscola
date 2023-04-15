package briscola.deck;

import org.junit.jupiter.api.Test;

import static briscola.deck.Suit.SPADES;
import static briscola.deck.Value.ACE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    public void givenACardThenShouldReturnTheLiteral() {
        assertEquals("1♠", new Card(ACE, SPADES).toString());
    }

    @Test
    public void givenTwoCardsWithSameValueAndSameSuitThenShouldBeEquals() {
        assertEquals(new Card(ACE, SPADES), new Card(ACE, SPADES));
    }
}