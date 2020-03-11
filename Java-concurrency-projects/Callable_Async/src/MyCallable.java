import java.util.concurrent.Callable;

/*
 * The Callable interface is similar to Runnable,
 *  in that both are designed for classes whose instances are potentially executed 
 *  by another thread. 
 *  A Runnable, does not return a result and cannot throw a checked exception. 
 */
public class MyCallable implements Callable<Long> {

	public Long call() throws Exception {
		long sum = 0;
		for (long i = 0; i <= 10; i++) {
			Thread.sleep(1000);
			System.out.println("The callable processing is "+i);
			sum += i;
		}
		System.out.println("The callable returning with  "+sum);
		return sum;
	}
}
