package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.RedBlueDoubleStack;

/**
 * Implement 2 stacks in one deque, with the red values on top, and
 * blue values on bottom
 *
 * @author Dylan Lasher
 * @param <E> any list type
 */
public class RedBlueDoubleStackImpl<E> implements RedBlueDoubleStack<E> {
	protected LinkedDeque<E> listRedBlue = new LinkedDeque<>();
	protected int redSize = 0;
	protected boolean redIsEmpty = true;
	protected int blueSize = 0;
	protected boolean blueIsEmpty = true;

	/**
	 * Adds element to top of the Red Stack, unless null.
	 *
	 * @param element to add.
	 */
	@Override
	public void pushRed(E element)
	{
		if (element != null)
		{
			listRedBlue.offerFirst(element);
			if (redSize == 0)
			{
				redIsEmpty = false;
			}
			redSize++;
		}
	}

	/**
	 * Adds element to top of Blue Stack, unless element is null.
	 *
	 * @param element to add.
	 */
	@Override
	public void pushBlue(E element)
	{
		if (element != null)
		{
			listRedBlue.offer(element);
			if (blueSize == 0)
			{
				blueIsEmpty = false;
			}
			blueSize++;
		}
	}

	/**
	 * Removes element at top of Red Stack and returns value,
	 * unless empty
	 *
	 * @return Element at the top of Red Stack, or null if
	 * empty
	 */
	@Override
	public E popRed()
	{
		if (!isRedEmpty())
		{
			redSize--;
			if (redSize == 0)
			{
				redIsEmpty = true;
			}
			return listRedBlue.poll();
		}
		else {
			return null;
		}
	}

	/**
	 * Removes element at top of Blue Stack and returns value,
	 * unless empty.
	 *
	 * @return Element at top of Red Stack, or null if
	 * empty
	 */
	@Override
	public E popBlue()
	{
		if (!isBlueEmpty())
		{
			blueSize--;
			if (blueSize == 0)
			{
				blueIsEmpty = true;
			}
			return listRedBlue.pollLast();
		}
		else {
			return null;
		}
	}

	/**
	 * Returns value at top of Red Stack.
	 * *
	 * @return value at top of Red Stack, or null if Red Stack
	 * is empty
	 */
	@Override
	public E peekRed() {
		return listRedBlue.peek();
	}

	/**
	 * Returns value at top of Blue Stack
	 *
	 * @return value at top of Blue Stack, or null if
	 * is empty
	 */
	@Override
	public E peekBlue() {
		return listRedBlue.peekLast();
	}

	/**
	 * Current Blue size counter
	 *
	 * @return Current size of Blue Stack
	 */
	@Override
	public int sizeBlue() {
		return blueSize;
	}

	/**
	 * Current Red size counter
	 *
	 * @return Current size of Red Stack
	 */
	@Override
	public int sizeRed() {
		return redSize;
	}

	/**
	 * Checks if Blue is empty
	 *
	 * @return True if Blue Stack is empty, false otherwise
	 */
	@Override
	public boolean isBlueEmpty() {
		return blueIsEmpty;
	}

	/**
	 * Checks if Red is empty
	 *
	 * @return True if Red Stack is empty, false otherwise
	 */
	@Override
	public boolean isRedEmpty() {
		return redIsEmpty;
	}
}
