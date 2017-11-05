
import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;




public class StocksConnect {
	
	  public static void main(String[] args)
	  {
		 //constructor creates StocksConnect 
	    new StocksConnect();
	  }

	public StocksConnect ()
	{
		// TODO Auto-generated method stub
		try {
			//create socket
		Socket clientSocket = new Socket("192.168.0.109", 5000);
		 String result = writeToReadFrom(clientSocket, "GET /\n\n"); // call method to read/write to socket
		 System.out.println(result); //print result(whatever is received from server

		}
		catch (Exception e)
		{
			e.printStackTrace(); // print stack trace
		}
		
		
		
		 
		  
		System.exit(0);
		

	}
	
	 private String writeToReadFrom(Socket clientSocket, String writeTo) throws Exception //read to/write from server 
	 {
		 try {
		 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //output to server
		 out.write(writeTo); //write to server
		 out.flush();
		 
		 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//input from server
		 StringBuilder sb = new StringBuilder(); //create string 
	      String str;
	      while ((str = input.readLine()) != null)
	      {
	        sb.append(str + "\n"); //while input is null append string
	      }
	      
	      // close the reader, and return the results as a String
	      input.close();
	      return sb.toString();//return appended string
	    } 
	    catch (IOException e) 
	    {
	      e.printStackTrace();
	      throw e;
	    }
		 
		 
	 }
	 
}
	
	
	


