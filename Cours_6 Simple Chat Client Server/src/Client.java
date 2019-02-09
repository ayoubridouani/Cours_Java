import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client implements ActionListener{
	private Socket sock;
	private JFrame frame;
	private JPanel panel;
	private JLabel label1,label2,label3;
	private JTextField text1,text2;
	private JComboBox<String> operation;
	private JButton result;
	
	Client(){
		System.out.println("Connecting ...");
		try {
			sock = new Socket("127.0.0.1", 2000);
		} catch (Exception e) {}
		
		frame = new JFrame("Calculatrice");
		frame.setSize(200, 160);
		
		label1 = new JLabel("number 1:");
		label1.setBounds(5, 5, 80, 25);
		
		label2 = new JLabel("operation :");
		label2.setBounds(5, 35, 80, 25);
		
		label3 = new JLabel("number 2:");
		label3.setBounds(5, 65, 80, 25);
		
		text1 = new JTextField();
		text1.setBounds(95, 5, 90, 25);
		
		operation = new JComboBox<String>();
		operation.addItem("+");
		operation.addItem("-");
		operation.addItem("*");
		operation.addItem("/");
		operation.setBounds(95, 35, 90, 25);
		
		text2 = new JTextField();
		text2.setBounds(95, 65, 90, 25);
		
		result = new JButton("Calculer");
		result.setBounds(50, 100, 100, 25);
		result.addActionListener(this);
		
		panel = new JPanel();
		panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
		panel.setLayout(null);
		panel.add(label1);panel.add(label2);panel.add(label3);
		panel.add(text1);panel.add(text2);
		panel.add(operation);
		panel.add(result);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			PrintWriter num1 = new PrintWriter(sock.getOutputStream());
	        num1.println(text1.getText());
	        num1.flush();
	        PrintWriter oper = new PrintWriter(sock.getOutputStream());
	        oper.println(operation.getSelectedItem());
	        oper.flush();
	        PrintWriter num2 = new PrintWriter(sock.getOutputStream());
	        num2.println(text2.getText());
	        num2.flush();
	        
	        InputStreamReader in = new InputStreamReader(sock.getInputStream());
	        BufferedReader res = new BufferedReader(in);
			System.out.println(res.readLine());
		} catch (IOException e1) {}
	}
}
