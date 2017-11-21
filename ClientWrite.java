import java.io.*;
import java.net.*;

public class ClientWrite implements Runnable
{

    Socket clientSocket = null;
    BufferedReader in = null;
    String inString;

    public ClientRead(Socket aSocket)
    {
        clientSocket = aSocket;
        try
        {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }
    }

    public void readFromServer()
    {
        try
        {
            while(!(inString = in.readLine()).equals(""))
            {
                //Do something
                System.out.println(inString);
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