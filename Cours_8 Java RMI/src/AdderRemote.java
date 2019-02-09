import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class AdderRemote extends UnicastRemoteObject implements Adder{
	AdderRemote()throws RemoteException{
		super();
	}
	public int add(int x,int y){
		return x+y;
	}
}