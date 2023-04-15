package briscola.deck;

import org.junit.jupiter.api.Test;

import static briscola.deck.Suit.SPADES;
import static briscola.deck.Value.ACE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValueTest {

    @Test
    public void givenASuitThenShouldBuildACard() {
        assertEquals(new Card(ACE, SPADES), ACE.of(SPADES));
    }
}