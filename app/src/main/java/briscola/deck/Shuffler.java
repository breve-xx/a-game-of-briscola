package briscola.deck;

import java.util.Set;
import java.util.Stack;

public interface Shuffler<T> {
    Stack<T> shuffle(Set<T> elements);
}