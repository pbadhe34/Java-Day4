
/**
 * MyThread will count the sum of the number from 1 to the parameter
 * countUntil and then write the result to the console.   
 */
public class MyThread implements Runnable {
	private final long countUntil;
	private String threadName="";

	MyThread(long countUntil,String name) {
		this.countUntil = countUntil;
		threadName = name;
	}

	 
	public void run() {
		long sum = 0;
		for (long i = 1; i < countUntil; i++) {
			sum += i;
		}
		 
		System.out.println("The sum from MyThread named  "+threadName +" is "+ sum);
	}
}
