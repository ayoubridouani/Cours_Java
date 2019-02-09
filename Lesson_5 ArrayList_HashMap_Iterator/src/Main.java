import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		int x = 0 ;
		Integer y = null ;
		try {
			System.out.println(5/x);
			x = y ;
		}catch(ArithmeticException e){
			System.out.println("catch1 "+e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("catch2 "+e.getMessage());
		}
		
		catch (Exception e) {
			System.out.println("catch "+e.getMessage());
		}
		
		//ArayList
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(40);
		System.out.println(a);
		a.remove(1);
		System.out.println(a);
		System.out.println(a.get(0));
		
		//HashMap
		HashMap<String,String> b = new HashMap<String,String>();
		b.put("hi1", "value1");
		b.put("hi2","value2");
		System.out.println(b);
		System.out.println(b.get("hi1"));
		if(b.containsKey("hi1")) {
			System.out.println("good !!");
		}
		b.remove("hi1");
		
		//Iterator ArrayList
		Iterator<Integer> c = a.iterator();
		while(c.hasNext()) {
			int value = c.next();
			System.out.println(value);
		}
		
		//Iterator Manual ArrayList
		int d = a.size();
		int k=0;
		while(k<d) {
			System.out.println(a.get(k));
			++k;
		}
		
		//Iterator HashMap
		Set<String> e = b.keySet();
		Iterator<String> f = e.iterator();
		while(f.hasNext()) {
			String value = f.next();
			System.out.println(value + " " + b.get(value));
		}
		
    }
}