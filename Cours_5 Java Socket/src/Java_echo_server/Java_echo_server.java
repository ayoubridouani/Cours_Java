package Java_echo_server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Java_echo_server {
	public static void runServer() {
		ServerSocket sock = null;
		try {
			//1: Server Creates Connection and Listening at A specific Prot=5000
			sock = new ServerSocket(5000);
			//2: this Socket is Reversed for The Client that already Connect With //Server
			Socket clientSock = sock.accept();
			//3: Get input Stream
			InputStream input = clientSock.getInputStream();
			//4: Get outPut Stream
			OutputStream output = clientSock.getOutputStream();
			//To Read Primitive Data Type
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			//To Write Primitive Data Type
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));
			String s = "";
			try {
				s = br.readLine(); // Read the String form Client
				System.out.println(s + "From Client");//Reversing Word
				String rs = "";
				StringBuffer sb = new StringBuffer(s);
				rs = sb.reverse().toString();
				// "\n" is important Because the Client uses Readline Method
				bw.write(rs + " \n");
				//Wtithout this Statment the bw Does not Send Data into Stream
				bw.flush();//Very important
			} catch (IOException e) {
			System.out.println(e.getMessage());
			} finally {
			sock.close();
			clientSock.close();
			bw.close();
			br.close();
			input.close();
			output.close();
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void main(String[] args) {
		runServer();
	}
}