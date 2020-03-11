


	import java.util.concurrent.Callable;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	import java.util.concurrent.Future;
	
	class Task1 implements Callable<Double> {
		  Task1() {
		  }

		  public Double call() throws InterruptedException {
			  System.out.println("task1 is running");
			  Thread.sleep(1000);
		     return 100.45;
		  }
		}
	
	class Task2 implements Callable<Integer> {
		  Task2() {
		  }

		  public Integer call() throws InterruptedException {
			  System.out.println("task2 is running");
			  Thread.sleep(2000);
		    return 101;
		  }
		}


	public class ThreadReturn_Callable {
	  public static void main(String args[]) throws Exception{
	    ExecutorService es = Executors.newFixedThreadPool(2);
	    //start the thraeds with tasks
	    Future<Double> f = es.submit(new Task1());
	    Future<Integer> f2 = es.submit(new Task2());
	    
System.out.println("The task are running and status is ");
System.out.println("Task1 done is "+f.isDone());
System.out.println("Task2 done is "+f2.isDone());

      //blocking call to get() to return the output

      // if(f.isDone())
	    System.out.println("Task1 output is "+f.get());
      // if(f2.isDone())
	    System.out.println("Task2 output is "+f2.get());
       
       System.out.println("Shutting down the executor");
	    es.shutdown();
	  }
	}

	