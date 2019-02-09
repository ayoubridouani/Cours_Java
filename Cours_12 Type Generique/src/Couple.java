//class generique
public class Couple <T1,T2> {     
	private T1 premier;
	private T2 deuxieme;     
	
	public Couple(){         
		premier=null;         
		deuxieme=null;     
	}
	
	public Couple(T1 p1, T2 p2){         
		premier=p1;         
		deuxieme=p2;     
	}
	
	//method generique
	@SuppressWarnings("unchecked")
	public <T3> T3 afficher(){         
		return (T3) ("Premier élément: " + premier +"\nDeuxième élément: "+deuxieme);     
	}
	
	public T1 getPremier(){         
		return premier;     
	}
	
	public void setPremier(T1 valeur){         
		premier=valeur;     
	} 
	
	public static void main(String[] args) {
		Couple<String,Integer> c = new Couple<>("ayoub",20);
		System.out.println(c.<String>afficher());
		
	}
}