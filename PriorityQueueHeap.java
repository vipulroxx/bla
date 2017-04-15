import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * The class implements a min-priority queue, i.e. smaller numbers have higher
 * priority. For instance, if the queue contains 2, 4, 1, then 1 is returned
 * first, then 2, then 4. The smallest element in the queue is called the head
 * of the queue. If the queue contains several elements with the same minimal
 * value, any one of them may play the role of the head.
 * 
 * Elements inserted in the the queue must implement Comparable interface. They
 * are ordered based on the ordering determined by their compareTo method.
 * 
 * The class employs a heap-based implementation, i.e. add and remove are
 * guaranteed to work in O(log(n)) time.
 * 
 * The queue is iterable. However, there are no guarantees on the order of the
 * elements, i.e. they are in general not sorted.
 * 
 * @param <E>

 *            - type of elements in the queue. Must implement Comparable<E>
 */
public class PriorityQueueHeap<E extends Comparable<E>> implements OurQueue<E>,
		Iterable<E> 
{
	private ArrayList<E> elements = new ArrayList<E>();
	private int size;
	/**
	 * Returns true if this list contains no elements, false otherwise. Runs in
	 * constant time.
	 * 
	 * @return true if this list contains no elements, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		
		return (elements.size() == 0);
	}

	/**
	 * Returns the number of elements in this queue. Runs in constant time.
	 * 
	 * @return the number of elements in this queue
	 */
	@Override
	public int size() {
		
		return size;
	}

	/**
	 * Inserts the specified element at its position in the priority queue. The
	 * position is determined by compareTo method: the element e is placed after
	 * all queue elements that are smaller than e based on compareTo and before
	 * all elements that are >= e. Runs in at most log N time where N is the
	 * number of elements currently in the queue.
	 * 
	 * @param e
	 *            - the element to be added to the queue
	 * @throws NullPointerException
	 *             - if the specified element is null
	 */
	@Override
	public void add(E item) throws NullPointerException
	{
		if (item == null)
		{
			throw new NullPointerException("Insertion of the item failed!");
		}
		else
		{
			int p = elements.size();
			elements.add(p, item);
			int parentNode = (p - 1)/2;
			while (parentNode >= 0 && elements.get(p).compareTo(elements.get(parentNode)) < 0)
			{
				swap(p, parentNode);
				p = parentNode;
				parentNode = parent(p);
			}
			size++;
		}
	}

	/**
	 * Retrieves and removes the head of this queue. Runs in at most log N time
	 * where N is the number of elements currently in the queue. Throws:
	 * NoSuchElementException - if this queue is empty
	 * 
	 * @return - the head of the queue
	 */
	public E remove() 
	{
		if (size == 0)
			throw new NoSuchElementException("No item in the queue!");
		else		
		{
			E head = null;
			int loc;
			if (!elements.isEmpty())
			{
				head = elements.get(0);
				loc = elements.size() - 1;
				elements.set(0, elements.get(loc));
				elements.remove(loc);
				--size;
				heap(0);
			}
			return head;
		}
	}
				
	public void heap(int root)
	{
		int child = leftChild(root);
		if (child < elements.size())
		{
			int rightChild = child + 1;
			if ((rightChild(root) < elements.size()) && elements.get(rightChild).compareTo(elements.get(child)) < 0)
			{
				child = rightChild;
			}
			if (elements.get(root).compareTo(elements.get(child)) > 0)
			{
				swap(root,child);
		        heap(child);
			}
		}
	}
	/**
	 * Retrieves but does not remove the head of this queue. Runs in constant
	 * time. Throws: NoSuchElementException - if this queue is empty
	 * 
	 * @return - the head of the queue
	 */
	public E element() {
		E head = elements.get(0);
		return head;
	}

	/**
	 * Removes all elements from the queue. This queue will be empty after this
	 * call returns.
	 * 
	 * @return
	 */
	public void clear() 
	{
		elements.clear();
		size = 0;
	}

	/**
	 * Returns an iterator for the queue. There are no guarantees on the order
	 * of the elements, i.e. they are in general not sorted.
	 */
	public Iterator<E> iterator() {
		return elements.iterator();
		}
	
	
	// swaps elements at indices i and j
	// to-do: think about checking error conditions
	private void swap(int i, int j) 
	{
		E tmp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, tmp);
	}

	// returns the index of the parent of this node
	// to-do: think about the behavior for the root
	private int parent(int i) {
		return (i - 1) / 2;
	}

	// returns the index of the left child of this node
	// to-do: think about the behavior if no such child
	private int leftChild(int i) {
		return 2 * i + 1;
	}

	// returns the index of the right child of this node
	// to-do: think about the behavior if no such child
	private int rightChild(int i) {
		return 2 * i + 2;
	}
}
