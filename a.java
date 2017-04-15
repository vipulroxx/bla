

/**
 * A collection that typically stores its elements in a FIFO
 * (first-in-first-out) manner
 * Modeled after Queue interface in the Java Collections Framework
 *
 * @author Elena Machkasova for CSCi 2101 
 *
 * @param <E> - the type of elements it holds
 */
public interface OurQueue<E> extends Iterable<E> {
	/**
	 * Returns the number of elements in this queue.
	 * 
	 * @return the size of the queue
	 */
	public int size();
	
	/**
	 * Returns true if this collection contains no elements, false 
	 * otherwise.
	 * 
	 * @return true if this collection contains no elements, false 
	 * otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Retrieves, but does not remove, the head of this queue. 
	 * Throws an exception if this queue is empty. 
	 * 
	 * @return the head of this queue. 
	 * @throws NoSuchElementException - if this queue is empty.
	 */
	public E element();
	
	/**
	 * Adds an element to the end of the queue
	 * 
	 * @param element - the element to be added to the queue
	 */
	public void add(E element);
	
	/**
	 * Retrieves and removes the head of this queue. 
	 * Throws an exception if this queue is empty. 
	 * 
	 * @return the head of this queue
	 * @throws NoSuchElementException - if this queue is empty.
	 */
	public E remove();
	
	/**
	 * Removes all of the elements from this queue making it empty.
	 */
	public void clear();
	
}
