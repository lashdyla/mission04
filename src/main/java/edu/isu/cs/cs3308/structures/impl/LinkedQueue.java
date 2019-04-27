package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;

/**
 * Linked queue based on Queue
 *
 * @author Dylan Lasher
 * @param <E> any queue type
 */
public class LinkedQueue<E> implements Queue<E>
{
	protected DoublyLinkedList<E> theList = new DoublyLinkedList<>();

	/**
	 * Add new element to end of queue
	 *
	 * @param element data to add to end, unless null
	 */
	@Override
	public void offer(E element) {
		theList.addLast(element);
	}

	/**
	 * Remove value at beginning of queue
	 *
	 * @return value at beginning of queue
	 */
	@Override
	public E poll() {
		return theList.removeFirst();
	}

	/**
	 * See value at beginning, without removing it
	 *
	 * @return value at queue beginning
	 */
	@Override
	public E peek() {
		return theList.first();
	}

	/**
	 * Get number of queue elements
	 *
	 * @return number of elements in queue
	 */
	@Override
	public int size() {
		return theList.size();
	}

	/**
	 * Determine if empty queue
	 *
	 * @return True if empty queue, else is false
	 */
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}

	/**
	 * Transfer all data from one queue to another,
	 * reversing element order
	 *
	 * @param to to transfer to unless null
	 */
	@Override
	public void transfer(Queue<E> to) {
		if (to != null && this.size() > 0) {
			LinkedStack<E> tempLinkStack = new LinkedStack<>();

			while(this.size() > 0) {
				tempLinkStack.push(this.poll());
			}
			while(tempLinkStack.size() > 0) {
				to.offer(tempLinkStack.pop());
			}
		}
	}

	/**
	 *Reverse order of queue elements
	 */
	@Override
	public void reverse()
	{
		LinkedQueue<E> temp1 = new LinkedQueue<>();
		LinkedQueue<E> temp2 = new LinkedQueue<>();

		this.transfer(temp1);
		temp1.transfer(temp2);
		temp2.transfer(this);

	}

	/**
	 * Copy from other queue to this queue's end
	 *
	 * @param other queue
	 */
	@Override
	public void merge(Queue<E> other)
	{
		if (other != null)
		{
			int listSize = other.size();

			for(int i = 0; i < listSize; i++)
			{
				E tempElement = other.poll();
				other.offer(tempElement);
				this.offer(tempElement);
			}
		}
	}

	/**
	 * Prints out the content of the queue list
	 */
	@Override
	public void printQueue() {
		theList.printList();
	}
}
