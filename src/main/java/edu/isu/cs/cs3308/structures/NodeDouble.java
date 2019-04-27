package edu.isu.cs.cs3308.structures;

/**
 * Node class for Double List functionality
 *
 * @author Dylan Lasher
 * @param <E>
 */
public class NodeDouble<E> extends Node<E>{

	private NodeDouble<E> prev;

	/**
	 * Constructor with data parameter
	 * @param data for Node storage
	 */
	public NodeDouble(E data) {
		super(data);
	}

	/**
	 * Get prev Node storage
	 * @return prev Node
	 */
	public NodeDouble<E> getPrev() {
		return prev;
	}

	/**
	 * Set what should be prev Node
	 * @param prev Node
	 */
	public void setPrev(NodeDouble<E> prev) {
		this.prev = prev;
	}
}
