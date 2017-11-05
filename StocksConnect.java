
import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;


public class StocksConnect {
	
	  public static void main(String[] args)
	  {
	    new StocksConnect();
	  }

	public StocksConnect ()
	{
		// TODO Auto-generated method stub
		try {
		Socket clientSocket = new Socket("192.168.0.109", 5000);
		 String result = writeToReadFrom(clientSocket, "GET /\n\n");
		 System.out.println(result);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		 
		  
		System.exit(0);
		

	}
	
	 private String writeToReadFrom(Socket clientSocket, String writeTo) throws Exception
	 {
		 try {
		 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		 out.write(writeTo);
		 out.flush();
		 
		 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
	      String str;
	      while ((str = input.readLine()) != null)
	      {
	        sb.append(str + "\n");
	      }
	      
	      // close the reader, and return the results as a String
	      input.close();
	      return sb.toString();
	    } 
	    catch (IOException e) 
	    {
	      e.printStackTrace();
	      throw e;
	    }
		 
		 
	 }
	 
}
	
	
	


