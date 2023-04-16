package briscola.game;

import com.google.common.flogger.FluentLogger;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    
    private final int faces;

    public Dice(final int faces) {
        this.faces = faces;
    }

    public int roll() {
        final int rolled = ThreadLocalRandom.current().nextInt(1, faces + 1);
        logger.atFine().log("Dice rolled: %d", rolled);
        return rolled;
    }
}