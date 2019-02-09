import java.util.LinkedList;

public class Queue {
	private LinkedList<Integer> queue;
	
	Queue(){
		queue = new LinkedList<>();
	}
	
	public void push(int value) {
		queue.addLast(value);
	}
	
	public void pop() {
		queue.removeFirst();
	}
	
	public boolean isEmpty() {
		if(queue.size() == 0) {
			return true;
		}
		return false;
	}
	
	public void emptyList() {
		while(!isEmpty())
			this.pop();
	}
	
	public void sortList() {
		queue.sort((a,b)->a.compareTo(b));
	}
	
	public void printList() {
		for(int list : queue) {
			System.out.println(list);
		}
	}
}
