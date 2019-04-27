package edu.isu.cs.cs3308.structures;

/**
 * Node class needed for the List
 * based on code shown by Isaac Griffith in class
 *
 * @author Dylan Lasher
 * @param <E> any node type
 */
public class Node<E>
{

	protected E data;
	protected Node<E> next;

	/**
	 * Constructor with data parameter
	 * @param data Node stores
	 */
	public Node(E data) {
		this.data = data;
	}

	/**
	 * Get data stored Node
	 * @return data node currently stores
	 */
	public E getData() {
		return data;
	}

	/**
	 * Set data stored in Node
	 * @param data node should store
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Get what Node stores as next in list
	 * @return Node currently stored in next attribute
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * Set next Node
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
