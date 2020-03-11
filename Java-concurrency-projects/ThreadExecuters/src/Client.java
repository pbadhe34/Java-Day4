

import java.io.*;
import java.net.*;
class Client implements Runnable
{ 
   int ServerPort;	
   Client(int port)
   {
	   ServerPort = port;
   }
  public  void run()
   {
   try
      {
       InetAddress local = InetAddress.getLocalHost();
       System.out.println("Starting the Client thread ");
       Socket client = new Socket(local,ServerPort);
       System.out.println("New Client is connected");  
       DataOutputStream sockout = new DataOutputStream(client.getOutputStream());
                
       sockout.writeBytes("Hello My Dear"+ "\n");
       Thread.sleep(1000);
        
       client.close();   
      }
    catch(IOException ioe)
      {
        System.out.println("Error in Client program is  "+ioe);
      } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    finally
       {         
        
        System.out.println("Client End of communication ");
      }
  }
}