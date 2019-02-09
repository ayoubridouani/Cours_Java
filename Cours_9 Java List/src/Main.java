import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) {
		LinkedList<Integer> linked = new LinkedList<>();
		ArrayList<Integer> array = new ArrayList<>();
		
		linked.add(100);
		linked.addFirst(50);
		linked.addLast(12);
		linked.add(40);
		linked.removeLast();
		
		array.add(100);
		array.add(40);
		array.remove(0);
		array.clear();
		
		linked.sort((a,b)->a.compareTo(b));
		array.sort((a,b)->a.compareTo(b));
		
		for(int list : linked) {
			System.out.printf("%d\n",list);
		}
		
		System.out.println("------------------------------------");
		
		for(int list : array) {
			System.out.printf("%d\n",list);
		}
	}
}
