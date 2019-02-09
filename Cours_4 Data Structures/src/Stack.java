import java.util.LinkedList;

public class Stack {
	private LinkedList<Integer> stack;
	
	Stack(){
		stack = new LinkedList<>();
	}
	
	public void push(int value) {
		stack.addFirst(value);
	}
	
	public void pop() {
		stack.removeFirst();
	}
	
	public boolean isEmpty() {
		if(stack.size() == 0) {
			return true;
		}
		return false;
	}
	
	public void emptyList() {
		while(!isEmpty())
			this.pop();
	}
	
	public void sortList() {
		stack.sort((a,b)->a.compareTo(b));
	}
	
	public void printList() {
		for(int list : stack) {
			System.out.println(list);
		}
	}
}
