package adapter;

public class Voiture implements Vehicule{
	private int a;
	
	public Voiture(int a) {
		this.a = a;
	}
	
	public int getA() {
		return this.a;
	}
	
	@Override
	public void moteur() {
		System.out.println("moteur v " + a);
	}

	@Override
	public void accelerate() {
		System.out.println("accelerate v " + a);
	}

	@Override
	public void vitesse() {
		System.out.println("vitesse v " + a);
	}
}
