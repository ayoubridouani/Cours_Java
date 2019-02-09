
public class Main {

	public static void main(String[] args) {
		//Stack
		Stack stack = new Stack();
		stack.push(10);
		stack.push(-87);
		stack.push(48);
		stack.printList();
		System.out.println("-----------");
		stack.pop();
		stack.push(5);
		stack.push(1);
		stack.printList();
		System.out.println("-----------");
		stack.pop();
		stack.printList();
		System.out.println("-----------");
		System.out.println("the list is: " + stack.isEmpty());
		stack.emptyList();
		
		//Queue
		Queue queue = new Queue();
		queue.push(10);
		queue.push(-87);
		queue.push(48);
		queue.printList();
		System.out.println("-----------");
		queue.pop();
		queue.push(5);
		queue.push(1);
		queue.printList();
		System.out.println("-----------");
		queue.pop();
		queue.printList();
		System.out.println("-----------");
		System.out.println("the list is: " + queue.isEmpty());
		queue.emptyList();
		
		//LinkedList
		LinkedList linkedlist = new LinkedList();
		linkedlist.addFirst(10);
		linkedlist.addLast(20);
		linkedlist.add(30);
		linkedlist.remove();
		linkedlist.removeFirst();
		linkedlist.removeLast();
		linkedlist.clear();
	}
}
