package adapter;

public class Adapter implements Vehicule{
	private Bicyclette byc;
	
	public Adapter(Bicyclette byc) {
		this.byc = byc;
	}
	
	@Override
	public void moteur() {
		System.out.println("moteur b " + byc.getA());
	}

	@Override
	public void accelerate() {
		System.out.println("accelerate b " + byc.getA());
	}

	@Override
	public void vitesse() {
		System.out.println("vitesse b " + byc.getA());
	}

}
