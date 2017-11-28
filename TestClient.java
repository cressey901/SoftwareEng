import java.io.*;
import java.net.*;

public class TestClient
{
    Socket clientSocket = null;
    PrintWriter out = null;
    BufferedReader stdIn = null;
    String outString;

    ClientRead myRead;
    ClientWrite myWrite;


    public TestClient()
    {
        try
        {
            clientSocket = new Socket("10.5.38.157", 5000);
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            stdIn = new BufferedReader(new InputStreamReader(System.in));

        }
        catch(IOException e)
        {
            System.out.println("Some Error: " + e);
        }

        myRead = new ClientRead(clientSocket);
    }

    public void writeToServer()
    {
        String aString;
        try
        {
            aString = stdIn.readLine();
            out.println(aString);
        }
        catch(IOException e)
        {
            System.out.println("Something went wrong: " + e);
        }
    }

    public void StartThreads()
    {
        Thread t1 = new Thread(myRead);
		Thread t2 = new Thread(myWrite);
		
        t1.start();
		t2.Start();
		
    }
	

    public static void main(String [] args)
    {
        TestClient myTest = new TestClient();
		ClientRead myRead = new ClientRead();

        myTest.StartThreads();
        while(true)
        {
            System.out.print("CMD: ");
            myTest.writeToServer();
        }
    }
}











