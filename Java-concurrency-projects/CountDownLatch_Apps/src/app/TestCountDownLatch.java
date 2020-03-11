package app;

// The CountDownLatch, used 
// when a thread needs to wait for other 
// threads before starting its work. 

import java.util.concurrent.CountDownLatch; 

//A class to represent threads for which the main thread waits. 
class Worker extends Thread 
{ 
	private int delay; 
	private CountDownLatch latch; 
	
	private int numOfCounts;

	public int getNumOfCounts() {
		return numOfCounts;
	}

	public Worker(int delay, CountDownLatch latch, 
									String name, int steps) 
	{ 
		super(name); 
		this.delay = delay; 
		this.latch = latch; 
		numOfCounts = steps;
	} 

	@Override
	public void run() 
	{ 
		try
		{ 
			Thread.sleep(delay); 
			numOfCounts= (numOfCounts * 101);			
			latch.countDown(); 
			System.out.println(Thread.currentThread().getName() 
							+ " finished with latch "+latch.getCount() +" and result as  "+numOfCounts); 
			 
		} 
		catch (InterruptedException e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
} 

public class TestCountDownLatch 
{ 
	public static void main(String args[]) 
				throws InterruptedException 
	{ 
		// Let us create task that is going to 
		// wait for four threads before it starts 
		CountDownLatch latch = new CountDownLatch(4); 

		// Let us create four worker 
		// threads and start them. 
		Worker first = new Worker(1000, latch, 
								"WORKER-1",100); 
		Worker second = new Worker(2000, latch, 
								"WORKER-2",123); 
		Worker third = new Worker(3000, latch, 
								"WORKER-3",467); 
		Worker fourth = new Worker(4000, latch, 
								"WORKER-4",678); 
		first.start(); 
		second.start(); 
		third.start(); 
		fourth.start(); 

		// The main task waits for four threads insetad of waiting on all four indivifually with join()
		//Causes the current thread to wait until the latch has counted down to zero, unless the thread is interrupted.
		latch.await(); 
		
		int sum = first.getNumOfCounts() + second.getNumOfCounts() + third.getNumOfCounts() + fourth.getNumOfCounts();
		
		
		//Now process the results from other threads

		// Main thread has started 
		System.out.println(Thread.currentThread().getName() + 
						" has finished with workesrs and  the result is  "+sum); 
	} 
} 


