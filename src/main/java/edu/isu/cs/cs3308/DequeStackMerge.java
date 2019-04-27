package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.Deque;
import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.impl.LinkedDeque;

/**
 * Merge two stacks together by using a LinkedDeque
 *
 * @author Isaac Griffith
 * @author Dylan Lasher
 */
public class DequeStackMerge {

    /**
     * Merges contents of second stack into bottom of
     * first stack, while preserving order of stack.
     *
     * @param <E> Element type of stack
     * @param into other stack to be merged
     * @param from stack which is merged into bottom other stack
     */
    public static <E> void dequeStackMerge(final Stack<E> into, Stack<E> from) {
        if (into != null && from != null) {
            LinkedDeque<E> mergeHandler = new LinkedDeque<>();

            while (into.size() > 0) {
                mergeHandler.offer(into.pop());
            }
            while (from.size() > 0) {
                mergeHandler.offer(from.pop());
            }
            while (mergeHandler.size() > 0) {
                into.push(mergeHandler.pollLast());
            }
        }
    }
}