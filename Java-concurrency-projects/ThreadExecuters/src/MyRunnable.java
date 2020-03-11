/**
 *MyRunnable will count the sum of the number from 1 to the parameter
 * countUntil and then write the result to the console. *
 * 
 * */

public class MyRunnable implements Runnable {
	private final long countUntil;

	MyRunnable(long countUntil) {
		this.countUntil = countUntil;
	}

	public void run() {
		long sum = 0;
		System.out.println("MyRunnable is running with .."+countUntil);
		for (long i = 1; i < countUntil; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sum += i;
		}
		System.out.println("The output of MyRunnable is "+sum);
	}
}