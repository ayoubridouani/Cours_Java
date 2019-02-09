package observer;

public class Exec {

    public static void main(String[] args) {
        //Instnace of the product
        Product phone = new Product("Banana Phone");

        //Person Observable
        Person khalid = new Person("khalid");
        Person sami = new Person("sami");
        Person busrha = new Person("busrha");

        //Add the observers
        phone.addObserver(khalid);
        phone.addObserver(sami);
        phone.addObserver(busrha);

        for(int i = 0; i < 5; i++) {
            if (i == 2) {
                phone.removeObserver(sami);
            }
            boolean avaiable = i % 2 == 0;
            phone.setAvailablity(avaiable);

            //Simple delay for printing out the data.
            try { Thread.sleep(1000); } catch (InterruptedException ie){}

            System.out.println("--------------------------------");
        }

    }
}
