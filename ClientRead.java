import java.io.*;
import java.net.*;

public class ClientRead implements Runnable
{

    Socket clientSocket = null;
    PrintWriter out = null;
    String inString;
	String userInput;


    public ClientRead(Socket aSocket)
    {
        clientSocket = aSocket;
        try
        {
           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }
    }

    public void writeToServer()
    {
        try
        {
            while(!(userInput = in.readLine()) != null) 
            {
                //Do something
                System.out.println(userInput);
				System.out.println("echo: " + in.readLine());
            }
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }
    }



    public void run()
    {
        System.out.println("DEBUG 1");
        while(true)
        {
            writeToServer();        
        }
    }

}



