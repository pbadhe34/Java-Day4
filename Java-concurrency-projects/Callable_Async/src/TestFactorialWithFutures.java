import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import app.FactorialTask;

public class TestFactorialWithFutures {

	private static final int NTHREDS = 10;

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		
	 	
		 int num = 3;
		 
		FactorialTask worker = new FactorialTask(num);
			Future<Integer> intFuture = executor.submit(worker);
			
			 
			while(intFuture.isDone()==false) {
				
			}		 
		 
		System.out.println("The factorial process done ?  :  "+intFuture.isDone());
		 
		if(intFuture.isDone())
		System.out.println("The total factorial  results is " + intFuture.get());
				 
	 
	}
}
