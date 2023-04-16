package briscola.deck;

import briscola.card.Card;
import org.junit.jupiter.api.Test;

import static briscola.card.Suit.SPADES;
import static briscola.card.Value.ACE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValueTest {

    @Test
    public void givenASuitThenShouldBuildACard() {
        assertEquals(new Card(ACE, SPADES), ACE.of(SPADES));
    }
}