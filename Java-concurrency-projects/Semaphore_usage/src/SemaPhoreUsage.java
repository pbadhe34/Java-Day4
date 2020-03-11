 

import java.util.concurrent.Semaphore;

public class SemaPhoreUsage {

	static Semaphore semaphore = new Semaphore(10);
	
	
	public static void main(String args[]) throws InterruptedException   {
		
	   System.out.println("SemaPhoreUsage main");
	   execute();
	   
	}
	public static void execute() throws InterruptedException {

		System.out.println("Available permit : " + semaphore.availablePermits());
		System.out.println("Number of threads waiting to acquire: " + semaphore.getQueueLength());

		if (semaphore.tryAcquire()) {
			try {		
			// perform some critical operations
				 System.out.println("Acquireing the locks..");
			} finally {
				 System.out.println("Releasing the locks..");
				semaphore.release();
			}
		}

	}

}
