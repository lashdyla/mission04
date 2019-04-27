package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

/**
 * A linked stack based on Stack
 *
 * @author Dylan Lasher
 * @param <E> any stack type
 */
public class LinkedStack<E> implements Stack<E>
{
	DoublyLinkedList<E> theList = new DoublyLinkedList<>();

	/**
	 * Add new element onto stack at beginning
	 *
	 * @param element data to add to top, unless null
	 */
	@Override
	public void push(E element) {
		theList.addFirst(element);
	}

	/**
	 * See value at beginning without removing it
	 *
	 * @return value at beginning of stack
	 */
	@Override
	public E peek() {
		return theList.first();
	}

	/**
	 * Remove value at beginning of stack
	 *
	 * @return value at beginning of stack
	 */
	@Override
	public E pop() {
		return theList.removeFirst();
	}

	/**
	 * Get number of elements in stack
	 *
	 * @return Number of elements in stack
	 */
	@Override
	public int size() {
		return theList.size();
	}

	/**
	 * Determine if stack is empty
	 *
	 * @return True if stack is empty, else is false
	 */
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}

	/**
	 * Transfer all data from one stack to another,
	 * reversing order
	 *
	 * @param to transfer to unless null
	 */
	@Override
	public void transfer(Stack<E> to)
	{
		if (to != null && this.size() > 0)
		{
			while(this.size() > 0)
			{
				to.push(this.pop());
			}
		}
	}

	/**
	 *Reverse order of stack elements
	 */
	@Override
	public void reverse() {
		LinkedStack<E> temp1 = new LinkedStack<>();
		LinkedStack<E> temp2 = new LinkedStack<>();

		this.transfer(temp1);
		temp1.transfer(temp2);
		temp2.transfer(this);
	}

	/**
	 * Copy other stack to end of this stack.
	 *
	 * @param other stack
	 */
	@Override
	public void merge(Stack<E> other)
	{
		if (other != null)
		{
			LinkedStack<E> origCopy = new LinkedStack<>();
			LinkedStack<E> otherCopy = new LinkedStack<>();

			this.transfer(origCopy);
			other.transfer(otherCopy);

			while (otherCopy.size() > 0)
			{
				E tempElem = otherCopy.pop();
				other.push(tempElem);
				this.push(tempElem);
			}

			origCopy.transfer(this);
		}
	}

	/**
	 * Prints content of stack
	 */
	@Override
	public void printStack() {
		theList.printList();
	}
}
