package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.Node;

/**
 * An implementation of a SLL based on List class
 *
 * @author Dylan Lasher
 * @param <E> any list type
 */
public class SinglyLinkedList<E> implements List<E>
{
	protected Node<E> head = null;
	protected Node<E> tail = null;
	protected Node<E> tempNode = null;
	protected int size = 0;

	/**
	 * Checks if given element is null
	 *
	 * @param element to check
	 * @return true if not null, false if null
	 */
	protected boolean checkElement(E element) {
		return element != null;
	}

	/**
	 * Checks if given index is greater than 0, less than size
	 *
	 * @param index to check
	 * @return true if valid index, false if invalid
	 */
	protected boolean checkIndex(int index) {
		return index < size && index >= 0;
	}

	protected void verifyList()
	{
		if (size == 1)
		{
			if (head != null)
			{
				tail = head;
			}
			else {
				head = tail;
			}
		}

		if (size == 0)
		{
			head = null;
			tail = null;
		}

		if (size > 0)
		{
			verifyBoundary();
		}
	}

	/**
	 * Set  Node values for add action
	 *
	 * @param dataToAdd
	 * @param atIndex to add node
	 */
	protected void nodeSetAdd(E dataToAdd, int atIndex)
	{
		Node<E> addNode = new Node<>(dataToAdd);

		if (atIndex == 0)
		{
			if (size > 0)
			{
				addNode.setNext(head);
			}
			head = addNode;
		}
		else if (atIndex >= size)
		{
			tail.setNext(addNode);
			tail = addNode;
		}
		else {
			Node<E> prevNode = getNode(atIndex-1);
			addNode.setNext(prevNode.getNext());
			prevNode.setNext(addNode);
		}
		addSize();
		verifyList();
	}

	/**
	 * Set Node values for a remove action
	 *
	 * @param atIndex of node to remove
	 * @return data in node
	 */
	protected E nodeSetRemove(int atIndex)
	{
		Node<E> removeNode = null;

		if (atIndex == 0)
		{
			removeNode = head;
			if (size > 1)
			{
				head = removeNode.getNext();
			}
		}
		else {
			Node<E> prevNode = getNode(atIndex-1);
			removeNode = prevNode.getNext();
			prevNode.setNext(removeNode.getNext());
			if (atIndex >= size-1)
			{
				tail = prevNode;
			}
		}
		removeNode.setNext(null);
		subSize();
		verifyList();

		return removeNode.getData();
	}

	/**
	 * Get node from list, given index
	 *
	 * @param index in list
	 * @return node retrieved from list
	 */
	protected Node<E> getNode(int index)
	{
		Node<E> seekNode = head;

		for (int i = 0; i < index; i++)
		{
			seekNode = seekNode.getNext();
		}

		return seekNode;
	}

	/**
	 * Add 1 to size value
	 */
	protected void addSize() {
		size++;
	}

	/**
	 * Subtracts 1 size counter
	 */
	protected void subSize()
	{
		size--;

		if (size < 0) //Can't drop below 0
		{
			size = 0;
		}
	}

	protected void verifyBoundary() {
		tail.setNext(null);
	}

	/**
	 * Get data from first node in list
	 *
	 * @return data in head node
	 */
	@Override
	public E first() {
		return (head != null) ? head.getData() : null;
	}

	/**
	 * Get data from last node in list
	 *
	 * @return data in tail node
	 */
	@Override
	public E last() {
		return (tail != null) ? tail.getData() : null;
	}

	/**
	 * Creates a node with the given element data to the end of the list
	 *
	 * @param element data to store in last node
	 */
	@Override
	public void addLast(E element)
	{
		if (checkElement(element))
		{
			if (!isEmpty())
			{
				nodeSetAdd(element,size);
			}
			else {
				addFirst(element);
			}
		}
	}

	/**
	 * Create node with given element data to list beginning
	 *
	 * @param element data to store in node
	 */
	@Override
	public void addFirst(E element)
	{
		if (checkElement(element))
		{
			nodeSetAdd(element, 0);
		}
	}

	/**
	 * Remove first node in list
	 *
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E removeFirst()
	{
		if (head != null)
		{
			return nodeSetRemove(0);
		}
		else {
			return null;
		}
	}

	/**
	 * Remove last node
	 *
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E removeLast()
	{
		if (size > 1)
		{
			return remove(size - 1);
		}
		else {
			return removeFirst();
		}
	}

	/**
	 * Create node with given element data, at given index
	 *
	 * @param element data to store in node
	 * @param index where node will be inserted
	 */
	@Override
	public void insert(E element, int index)
	{
		if (checkElement(element))
		{
			if (index >= 0)
			{
				if (index == 0)
				{
					addFirst(element);
				}
				else if (index >= size)
				{
					addLast(element);
				}
				else {
					nodeSetAdd(element, index);
				}
			}
		}
	}

	/**
	 * Remove given node from list
	 *
	 * @param index of to-be-removed node
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E remove(int index)
	{
		if (checkIndex(index))
		{
			if (index == 0)
			{
				return removeFirst();
			}
			else {
				return nodeSetRemove(index);
			}
		}
		else {
			return null;
		}
	}

	/**
	 * Get data in node at index
	 *
	 * @param index of node
	 * @return data stored in node
	 */
	@Override
	public E get(int index)
	{
		if (checkIndex(index))
		{
			if (index == 0)
			{
				return head.getData();
			}
			else if (index == size-1)
			{
				return tail.getData();
			}
			else {
				return getNode(index).getData();
			}
		}
		else {
			return null;
		}
	}

	/**
	 * Get number of nodes in list
	 *
	 * @return node count
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Determines if list is empty
	 *
	 * @return True if the empty, false if size != 0
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Print values
	 */
	@Override
	public void printList()
	{
		if (!isEmpty())
		{
			tempNode = head;

			for (int i = 0; i < size; i++)
			{
				if (i < size-1)
				{
					System.out.print(tempNode.getData() + "\n");
				}
				else {
					System.out.println(tempNode.getData());
				}
				tempNode = tempNode.getNext();
			}
		}
		else {
			System.out.println("This list is empty.");
		}
		tempNode = null;
	}

	/**
	 * Find item in list.
	 *
	 * @param item to find in list
	 * @return index of item
	 */
//	@Override
	public int indexOf(E item)
	{
		if (!isEmpty() && item != null)
		{
			if (head.getData() == item)
			{
				return 0;
			}
			else if (tail.getData() == item)
			{
				return size-1;
			}
			else {
				tempNode = head;

				for (int i = 0; i < size; i++)
				{
					if (tempNode.getData() == item)
					{
						return i;
					}
					tempNode = tempNode.getNext();
				}
			}
		}
		tempNode = null;

		return -1;
	}
}
