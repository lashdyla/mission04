package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Deque;

/**
 * A class to implement a Linked Deque which is an extended Linked Queue
 *
 * @author Dylan Lasher
 * @param <E> any list type
 */
public class LinkedDeque<E> extends LinkedQueue<E> implements Deque<E> {

	/**
	 * Return value of last value in list, without removing it
	 *
	 * @return value of last element of the deque, without removing it
	 */
	@Override
	public E peekLast() {
		return (theList != null) ? theList.last() : null;
	}

	/**
	 * Add provided non null value to end of list
	 *
	 * @param element to be inserted to deque front of the deque
	 */
	@Override
	public void offerFirst(E element)
	{
		if (element != null)
		{
			theList.addFirst(element);
		}
	}

	/**
	 * Remove value at list end
	 *
	 * @return value of last item in Deque and removes value
	 * from the deque
	 */
	@Override
	public E pollLast() {
		return (theList.isEmpty()) ? null : theList.removeLast();
	}
}
