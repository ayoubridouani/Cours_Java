/*
//Exercice 1: Singleton Pattern
//Problem: comment instancier une seule fois une class, tel que la deuxieme et la troisieme et les autres instances va partagé la meme espace memoire de la premier objet instancié.
class Exo1{
	private static Exo1 instance;
	
	private Exo1() {
		System.out.println("an object was created");
	}
	
	public synchronized static Exo1 getInstance() { //synchronized ==>  pour resolue le problem lors de deux threads ou plus va utiliser la fonction en meme temps
		if(instance == null) {
			instance = new Exo1();
		}
		return instance;
	}
}
*/

/*
//Exercice 2: Composite Pattern
//Problem: patron permet de concevoir une structure d'arbre, par exemple un dossier contient des fichiers et sous dossiers (arbre)
interface Exo2_composant{
	public void operation();
}

class Exo2_composite implements Exo2_composant{
	private ArrayList<Exo2_composant> component;
	public Exo2_composite() {
		this.component = new ArrayList<>();
	}
	public void operation() {}
	public void add(Exo2_composant component) {
		this.component.add(component);
	}
	public void remove() {
		this.component.remove(this.component.size() - 1);
	}
	public int size() {
		return this.component.size();
	}
}

class Exo2_element implements Exo2_composant{
	public Exo2_element() {}
	public void operation() {}
}
*/

//Exercice 3: Observer Pattern
//Problem: 

public class Main {

	public static void main(String[] args) {
		/*
		Exo1 obj1 = Exo1.getInstance();
		Exo1 obj2 = Exo1.getInstance();
		*/
		/*
		Exo2_composite obj1 = new Exo2_composite();
		Exo2_element obj2 = new Exo2_element();
		Exo2_composite obj3 = new Exo2_composite();
		obj1.add(obj2);
		System.out.println(obj1.size());
		obj1.add(obj3);
		System.out.println(obj1.size());
		obj1.remove();
		System.out.println(obj1.size());
		*/
		/*
		//implement Iterator
	    Collection<String> col = new ArrayList<>();
	    col.add("Ayoub1");
	    col.add("Ayoub2");
	    col.add("Ayoub3");
	    col.add("Ayoub4");
	    
	    Iterator<String> it = col.iterator();
	    while(it.hasNext()){
	        System.out.println(it.next());
	    }
	    */
	}

}
