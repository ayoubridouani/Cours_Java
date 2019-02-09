package adapter;

public class Main {

	public static void main(String[] args) {
		Vehicule voiture = new Voiture(1);
		Vehicule bicyclette = new Adapter(new Bicyclette(5));
		
		voiture.accelerate();
		bicyclette.accelerate();
	}
}
