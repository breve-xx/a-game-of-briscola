package briscola.play;

import briscola.card.Card;
import briscola.deck.Deck;
import briscola.player.Player;

import java.util.Collections;
import java.util.List;

public class PlayEvaluator {

    private final Deck deck;

    public PlayEvaluator(final Deck deck) {
        this.deck = deck;
    }

    public void evaluate(final List<Player> players, final List<Card> played) {
        final Player player1 = players.get(0);
        final Card played1 = played.get(0);

        final Player player2 = players.get(1);
        final Card played2 = played.get(1);

        if (deck.isBriscola(played1.suit())) {
            if (!deck.isBriscola(played2.suit())) {
                player1.take(played);
            } else {
                if (played1.value().order() > played2.value().order()) {
                    player1.take(played);
                } else {
                    player2.take(played);
                    Collections.reverse(players);
                }
            }
        } else {
            if (deck.isBriscola(played2.suit())) {
                player2.take(played);
                Collections.reverse(players);
            } else {
                if (played1.suit().equals(played2.suit())) {
                    if (played1.value().order() > played2.value().order()) {
                        player1.take(played);
                    } else {
                        player2.take(played);
                        Collections.reverse(players);
                    }
                } else {
                    player1.take(played);
                }
            }
        }
    }
}