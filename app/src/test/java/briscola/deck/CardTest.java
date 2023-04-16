package briscola.deck;

import briscola.card.Card;
import org.junit.jupiter.api.Test;

import static briscola.card.Suit.SPADES;
import static briscola.card.Value.ACE;
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