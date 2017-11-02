
import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;


public class StocksConnect {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Socket s = new Socket("192.168.0.109", 5000);
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String answer = input.readLine();
		JOptionPane.showMessageDialog(null, answer);
		System.exit(0);
		

	}
	
	

}
