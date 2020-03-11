package app;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class completedFutureTest {

	public static void main(String[] args) {
		 
		completedFutureCompletionTest();
		
		System.out.println("\n");
		
		runAsyncStage();
		System.out.println("\n");
		
		thenFunctionToProcess();
		
		System.out.println("\n");
		thenApplyAsync();
		
		System.out.println("\n");
		
		thenApplyAsyncWithExecutor();
		System.out.println("\n");
		
		thenAcceptConsume();
		System.out.println("\n");
		
	 
	}
	
	//Creating a Completed CompletableFuture
	static void completedFutureCompletionTest() {
	    CompletableFuture<String> cf = CompletableFuture.completedFuture("MyData");
	    System.out.println("Is Done "+cf.isDone());
	    System.out.println("Is it out ? "+cf.getNow(null));
	}
	
	//Executes a Runnable asynchronously
	//A CompletableFuture is executed asynchronously when the method typically ends with the keyword Async
	//uses daemon threads to execute the Runnable tasks
	static void runAsyncStage() {
	    CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
	        System.out.println("Is daemon : "+Thread.currentThread().isDaemon());
	        randomWork(1000);
	       
	    });
	    System.out.println("Is Done "+cf.isDone());
	    randomWork(5000);
	    System.out.println("Is Done Now"+cf.isDone());
	    try {
			System.out.println("Is Output "+cf.get());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
	//Apply a Function on the Previous Stage
	
	/*then, which means that the action of this stage happens when the current stage completes 
	normally (without an exception). 
	In this , the current stage is already completed with the value “message”.
	
	
	Apply, which means the returned stage will apply a Function on the result of the previous stage
	The execution of the Function will be blocking, which means that getNow() will only be reached when 
	the uppercase operation is done.
	*/
	
	static void thenFunctionToProcess() {
	    CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
	       System.out.println("Is daemon "+Thread.currentThread().isDaemon());
	       randomWork(4500);
	       return s.toUpperCase();
	    });
	    System.out.println("The cf output is "+cf.getNow(null));
	    //getNow() is only  reached when the uppercase operation is done.
	}

	static void randomWork(int timetoSleep) {
		System.out.println("random Work going on..");
		try {
			Thread.sleep(timetoSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Asynchronously Applying a Function on a Previous Stage
	//THe chained CompletableFuture would execute asynchronously
	
	static void thenApplyAsync() {
	    CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
	        System.out.println("Is it a deamon "+Thread.currentThread().isDaemon());
	        randomWork(2300);
	        return s.toUpperCase();
	    });
	    System.out.println(cf.getNow(null));
	    System.out.println("MESSAGE"); 
	    cf.join();
	    
	}
	
	//Asynchronously Apply a Function on  a Previous Stage Using a Custom Executor
	//Provide an Executor to use it to execute the desired CompletableFuture
	
	static ThreadFactory tfactory = new ThreadFactory() {
	    int count = 1;
	    @Override
	    public Thread newThread(Runnable runnable) {
	        return new Thread(runnable, "custom-executor-" + count++);
	    }
	};
	
	static ExecutorService executor = Executors.newFixedThreadPool(3, tfactory);
	
	static void thenApplyAsyncWithExecutor() {
	    CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
	        System.out.println(Thread.currentThread().getName()); //.startsWith("custom-executor-"));
	        System.out.println(Thread.currentThread().isDaemon()); //false
	        randomWork(5000);
	        return s.toUpperCase();
	    }, executor);
	    System.out.println("The output is "+cf.getNow(null));
	    System.out.println("The message is "+ cf.join());
	}
	
	//Consume the Result of the Previous Stage
	//next stage accepts the result of the current stage but does not need to return a value in the computation 
	//(i.e. its return type is void), then instead of applying a Function, it can accept a Consumer, 
	//hence the method thenAccept:
	
	static void thenAcceptConsume() {
	    StringBuilder result = new StringBuilder();
	    CompletableFuture.completedFuture("thenAccept message")
	            .thenAccept(s -> result.append(s));
	    System.out.println("Result is   : "+result);
	}
}
