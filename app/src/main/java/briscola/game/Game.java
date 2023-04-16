package briscola.game;

import briscola.card.Card;
import briscola.deck.Deck;
import briscola.play.PlayEvaluator;
import briscola.player.Player;
import com.google.common.flogger.FluentLogger;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class Game {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    
    public static final int HAND_SIZE = 3;

    private final Deck deck;
    private final PlayEvaluator evaluator;
    private final List<Player> players;

    public Game(final Player player1, final Player player2, final Deck deck, final Dice dice) {
        this.deck = deck;
        evaluator = new PlayEvaluator(deck);
        players = newArrayList(player1, player2);
        if(player1.roll(dice) < player2.roll(dice)) {
            Collections.reverse(players);
        }
    }

    public Map<String, Integer> play() {
        logger.atInfo().log("Players order: %s", players.stream().map(Player::name).toList());
        for (int i = 0; i < HAND_SIZE; i++) {
            players.forEach(player -> player.draw(deck));
        }
        while (players.stream().noneMatch(Player::hadCards)) {
            final List<Card> played = players.stream()
                    .map(Player::play)
                    .toList();

            evaluator.evaluate(players, played);

            players.forEach(player -> player.draw(deck));
        }
        return players.stream()
                .collect(Collectors.toMap(Player::name, Player::points));
    }
}