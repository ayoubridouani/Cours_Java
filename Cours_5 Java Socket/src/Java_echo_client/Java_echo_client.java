package Java_echo_client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
public class Java_echo_client {
	public static void runClient() {
		try {
			//1: Connect With Server at a Specific Prot=500
			Socket clientSocket = new Socket("localhost", 5000);
			//2: Get input Stream
			InputStream input =clientSocket.getInputStream();
			//3: Get output Stream
			OutputStream output=clientSocket.getOutputStream();
			//To Read Primitive Data Type
			BufferedReader br=new BufferedReader(new InputStreamReader(input));
			//To Write Primitive Data Type
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(output));
			//Reading String From Keyboard By Scanner Class
			@SuppressWarnings("resource")
			Scanner scan=new Scanner(System.in);
			String Word=scan.next();
			// "\n" is important Because the Server uses Readline Method
			bw.write(Word+" \n");
			//Wtithout this Statment the bw Does not Send Data into Stream
			bw.flush();//Very important
			//Waiting for Reading The Reverse word from Server
			String s= br.readLine();
			System.out.println(s+"From Server");
			//Release The Resources
			clientSocket.close();
			br.close();
			bw.close();
			input.close();
			output.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void main(String[] args) {
		runClient();
	}
}