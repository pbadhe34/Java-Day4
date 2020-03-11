

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ExecutorClientService 
{ 
   
  public static void main(String [] ar)
   {
	  ExecutorService clientService = Executors.newFixedThreadPool(15);
   try
      {
	   for(int i =0; i < 10; i++)	 {
		   
		   clientService.execute(new Client(1080));
		   Thread.sleep(1000);
	   }
		  
      }
    catch(Exception ioe)
      {
        System.out.println("Error in ClientService program is  "+ioe);
      }
    finally
       {         
        
        System.out.println("Executor Client End of communication ");
      }
   clientService.shutdown();//Stop the process  stop  to reject new tasks
  }
}