package app;

import java.util.concurrent.CountDownLatch;

public class CountDownSignals {  
	private static int numTasks= 5;
	
	  public static  void main(String [] args) throws InterruptedException {
	     CountDownLatch startSignal = new CountDownLatch(1);
	     CountDownLatch doneSignal = new CountDownLatch(numTasks);

	     for (int i = 0; i < numTasks; ++i) // create and start threads
	       new Thread(new ProcessWorker(startSignal, doneSignal)).start();

	     System.out.println("Main Doing some job");           
	     startSignal.countDown();      // let all threads proceed
	     System.out.println("Main Doing one more job");   
	     doneSignal.await();           // wait for all to finish
	     System.out.println("Now main is healthy and fine with Workers");
	   }
	 }

	 class ProcessWorker implements Runnable {
	   private final CountDownLatch startSignal;
	   private final CountDownLatch doneSignal;
	   ProcessWorker(CountDownLatch startSignal, CountDownLatch doneSignal) {
	      this.startSignal = startSignal;
	      this.doneSignal = doneSignal;
	   }
	   public void run() {
	      try {
	        startSignal.await();
	        doWork();
	        doneSignal.countDown();
	      } catch (InterruptedException ex) {} 
	   }

	   void doWork() throws InterruptedException { 
		   System.out.println("Worker doWork..");
		   Thread.sleep(4000);
		    }
	 }
