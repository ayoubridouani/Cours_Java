class CheckClassThread extends Thread{
	private String texte;
	private int nbr;
	
	public CheckClassThread(String texte, int nbr) {
		super();
		this.texte = texte;
		this.nbr = nbr;
	}

	public void run() {
		for(int i=0;i<nbr;i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(texte);
		}
	}	
}

//or we implements interface Runnable + define method run
class CheckInterfaceThread implements Runnable{
	private String texte;
	private int nbr;
	
	public CheckInterfaceThread(String texte, int nbr) {
		super();
		this.texte = texte;
		this.nbr = nbr;
	}

	public void run() {
		for(int i=0;i<nbr;i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(texte);
		}
	}	
}

public class Main{

	public static void main(String[] args) {
		/*
		CheckClassThread main1 = new CheckClassThread("Bonjour",15);
		CheckClassThread main2 = new CheckClassThread("Salut",10);
		CheckClassThread main3 = new CheckClassThread("\n",10);
		
		main1.start();
		main2.start();
		main3.start();
		*/
		
		CheckInterfaceThread main1 = new CheckInterfaceThread("Bonjour",15);
		CheckInterfaceThread main2 = new CheckInterfaceThread("Salut",10);
		CheckInterfaceThread main3 = new CheckInterfaceThread("\n",10);
		
		Thread t1 = new Thread(main1);
		t1.start();
		Thread t2 = new Thread(main2);
		t2.start();
		Thread t3 = new Thread(main3);
		t3.start();
		
	}

}
