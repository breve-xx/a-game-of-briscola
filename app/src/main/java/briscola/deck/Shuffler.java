package briscola.deck;

import java.util.Collection;
import java.util.Stack;

public interface Shuffler<T> {
    Stack<T> shuffle(Collection<T> elements);
}