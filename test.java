


public class test {
	public static void main(String [] args) {
		OurQueue<String> queue = new PriorityQueueHeap<String>();
		System.out.println("Checking whether queue is empty : "+queue.isEmpty()); // expect true
		System.out.println("Checking the size of queue : "+queue.size()); // expect 0
		System.out.println("//////////////////////////////////////////");
		System.out.println("After adding elements in the queue ....");
		queue.add("g");
		queue.add("f");
		queue.add("e");
		System.out.print("Queue now is : ");
		for (String fruit: queue)
			System.out.print(fruit+" "); 
	    System.out.println();
		System.out.println("Checking whether queue is empty : "+queue.isEmpty()); // expect false
		System.out.println("Checking the size of queue : "+queue.size()); // expect 1
		System.out.println("The head of the queue is : "+queue.element()); // expect "kiwi"
		System.out.println("//////////////////////////////////////////");
		System.out.println("Adding more elements in the queue ....");
		queue.add("a");
	    queue.add("b");
	    queue.add("c");
	    queue.add("d");
	    System.out.print("Queue now is : ");
		for (String fruit: queue)
			System.out.print(fruit+" "); 
	    System.out.println();
		System.out.println("Checking whether queue is empty : "+queue.isEmpty()); // expect false
		System.out.println("Checking the size of queue : "+queue.size()); // expect 1
		System.out.println("The head of the queue is : "+queue.element()); // expect "kiwi"
		System.out.println("//////////////////////////////////////////");
		System.out.println("Retrieving and removing the head of the queue : "+queue.remove());
		System.out.print("Queue now is : ");
		for (String fruit: queue)
			System.out.print(fruit+" "); 
	    System.out.println();
		System.out.println("Checking the size of queue : "+queue.size()); // expect 1
		System.out.println("The head of the queue is : "+queue.element()); // expect "kiwi"
		System.out.println("//////////////////////////////////////////");
		System.out.println("Retrieving and removing the head of the queue again : "+queue.remove());
		System.out.print("Queue now is : ");
		for (String fruit: queue)
			System.out.print(fruit+" "); 
	    System.out.println();
		System.out.println("Checking the size of queue : "+queue.size()); // expect 1
		System.out.println("The head of the queue is : "+queue.element()); // expect "kiwi"
		System.out.println("//////////////////////////////////////////");
		System.out.println("Clearing the queue");
		queue.clear();
		System.out.println("Checking the size of queue : "+queue.size()); // expect 1
	}

}
