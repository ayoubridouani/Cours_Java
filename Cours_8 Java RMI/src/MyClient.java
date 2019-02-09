import java.rmi.Naming;

public class MyClient{
	public static void main(String args[]){
		try{
			Adder stub=(Adder)Naming.lookup("rmi://192.168.1.2:5000/sonoo");
			System.out.println(stub.add(34,4));
		}catch(Exception e){
			e.getStackTrace();
		}  
	}
}