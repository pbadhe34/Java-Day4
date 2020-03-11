import java.util.concurrent.Executors;

/*
 * A Future represents the result of an asynchronous computation. 
 * Methods are provided to check if the computation is complete, 
 * to wait for its completion, and to retrieve the result of the computation. 
 * The result can only be retrieved using method get when the computation has completed,
 *  blocking if necessary until it is ready. 
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
public class TestAsync {
	static String target = "am";
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		final Searcher engine = new Searcher();
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		System.out.println("Starting the direct search");
		
		int numData = engine.Search(target);
		System.out.println("The result after direct seacrch  is "+numData);
		System.out.println("Now call the other work after this delayed search");
		
		work();
		
		/*Future<Integer> future = service.submit(new Callable<Integer>() {
	         public Integer call() { 
	        	 int  res = engine.Search(target);
	        	 return res;
	         }
	     });*/
		//The FutureTask class is an implementation of Future that implements 
		//Runnable, and so can be executed by an Executor. 
		
		FutureTask<Integer> future =
		       new FutureTask<Integer>(new Callable<Integer>() {
		         public Integer call() {
		           return engine.Search(target);
		       }});
		service.execute(future);

		
		while(future.isDone()==false)
		   work();//Continue with some other work here
		
		//System.out.println("Waiting for the result after serach");
		int result = future.get();//wait for the result
		System.out.println("The result after seraching is  "+result);
		service.shutdown();
		
	}
	static void work(){
		try {
			Thread.sleep(1500);
			System.out.println("Working on other task here..");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Searcher { 
	
	    private final String data = "I am living with Fox and Brothers am in the " +
	    		"caves around jungle in AD23000 by the Time we will manage with ourselves" +
	    		"and I will be moving towards another jungle and I am the king of here";
		public int Search(String key) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int num = 0;
			int res =1;
			
			res = data.indexOf(key);	
			//System.out.println("searched here "+res);
			  
			 
			while(res > 0)
			{
				//System.out.println("Searching here");				
				 
					res = data.indexOf(key,res+1);
					//System.out.println("searched next "+res);
					num++;
				}
			 
			return num;		 
				
			
			
		}
	 
}
