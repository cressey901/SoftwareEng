import java.io.*;
import java.net.*;

public class ClientWrite implements Runnable
{

    Socket clientSocket = null;
    BufferedReader in = null;
    String inString;

    public ClientWrite(Socket aSocket)
    {
        clientSocket = aSocket;
        try
        {
            in = new BufferedReader(new OutputStreamWriter(clientSocket.getInputStream()));
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
           while ((userInput= in.readLine()) != null) {
			   out.println(userInput);
			   System.out.println("echo " + in.readLine());
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
            readFromServer();        
        }
    }

}