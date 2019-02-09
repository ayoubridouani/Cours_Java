import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private Socket sock;
	private ServerSocket listener;
	Server() throws IOException{
		try {
			listener = new ServerSocket(2000);
			System.out.println("[+] server created ...");
			System.out.println("[+] waiting a client");
			sock = listener.accept();
			System.out.println("[+] client " + sock.getPort() + " accepted");
			
			while(true) {
				InputStreamReader in = new InputStreamReader(sock.getInputStream());
				BufferedReader num = new BufferedReader(in);
				int value1 = Integer.parseInt(num.readLine());
				String operation = num.readLine();
				int value2 = Integer.parseInt(num.readLine());
				int sum = 0;
				int error = 0;
				switch(operation) {
					case "+":
						sum = value1 + value2;
						break;
					case "-":
						sum = value1 - value2;
						break;
					case "*":
						sum = value1 * value2;
						break;
					case "/":
						if(value2 == 0) error = -1;
						else sum = value1 / value2;
						break;
				}
				PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
	            if(error == -1) out.println("Error!! div to zero");
	            else out.println(sum);
			}
		}catch(Exception e) {
			
		}finally {
			sock.close();
		}
	}
	/*public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {}
	}*/
}