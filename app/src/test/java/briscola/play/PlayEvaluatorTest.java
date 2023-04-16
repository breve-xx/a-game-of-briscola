package briscola.play;

import briscola.card.Suit;
import briscola.deck.Deck;
import briscola.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static briscola.card.Suit.*;
import static briscola.card.Value.*;
import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayEvaluatorTest {

    @Mock
    private Deck deck;

    @InjectMocks
    private PlayEvaluator sut;

    @Mock
    private Player player1;

    @Mock
    private Player player2;

    private List<Player> players;

    @BeforeEach
    public void setUp() {
        players = newArrayList(player1, player2);
    }

    @Test
    public void givenBriscolaAndNotBriscolaThenFirstShouldTakeAndPlay() {
        when(deck.isBriscola(any(Suit.class))).thenReturn(false);
        when(deck.isBriscola(SPADES)).thenReturn(true);

        sut.evaluate(players, newArrayList(SEVEN.of(SPADES), ACE.of(HEARTS)));

        verify(player1).take(newArrayList(SEVEN.of(SPADES), ACE.of(HEARTS)));
        assertEquals(newArrayList(player1, player2), players);
    }

    @Test
    public void givenNotBriscolaAndBriscolaThenSecondShouldTakeAndPlay() {
        when(deck.isBriscola(any(Suit.class))).thenReturn(false);
        when(deck.isBriscola(SPADES)).thenReturn(true);

        sut.evaluate(players, newArrayList(ACE.of(HEARTS), SEVEN.of(SPADES)));

        verify(player2).take(newArrayList(ACE.of(HEARTS), SEVEN.of(SPADES)));
        assertEquals(newArrayList(player2, player1), players);
    }

    @Test
    public void givenBriscolaAndHgherBriscolaThenSecondShouldTakeAndPlay() {
        when(deck.isBriscola(SPADES)).thenReturn(true);

        sut.evaluate(players, newArrayList(SEVEN.of(SPADES), ACE.of(SPADES)));

        verify(player2).take(newArrayList(SEVEN.of(SPADES), ACE.of(SPADES)));
        assertEquals(newArrayList(player2, player1), players);
    }

    @Test
    public void givenBriscolaAndLowerBriscolaThenFirstShouldTakeAndPlay() {
        when(deck.isBriscola(SPADES)).thenReturn(true);

        sut.evaluate(players, newArrayList(SEVEN.of(SPADES), SIX.of(SPADES)));

        verify(player1).take(newArrayList(SEVEN.of(SPADES), SIX.of(SPADES)));
        assertEquals(newArrayList(player1, player2), players);
    }

    @Test
    public void givenNotBriscolaAndLowerNotBriscolaSameSuitThenFirstShouldTakeAndPlay() {
        sut.evaluate(players, newArrayList(SEVEN.of(HEARTS), SIX.of(HEARTS)));

        verify(player1).take(newArrayList(SEVEN.of(HEARTS), SIX.of(HEARTS)));
        assertEquals(newArrayList(player1, player2), players);
    }

    @Test
    public void givenNotBriscolaAndHigherNotBriscolaSameSuitThenSecondShouldTakeAndPlay() {
        sut.evaluate(players, newArrayList(SEVEN.of(HEARTS), JACK.of(HEARTS)));

        verify(player2).take(newArrayList(SEVEN.of(HEARTS), JACK.of(HEARTS)));
        assertEquals(newArrayList(player2, player1), players);
    }

    @Test
    public void givenNotBriscolaAndHigherNotBriscolaDifferentSuitThenFirstShouldTakeAndPlay() {
        sut.evaluate(players, newArrayList(SEVEN.of(HEARTS), JACK.of(CLUBS)));

        verify(player1).take(newArrayList(SEVEN.of(HEARTS), JACK.of(CLUBS)));
        assertEquals(newArrayList(player1, player2), players);
    }
}