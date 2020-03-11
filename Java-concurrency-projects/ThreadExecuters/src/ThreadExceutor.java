import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExceutor {
	private static final int NTHREDS = 10;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new MyThread(20 + i);
			executor.execute(worker);
		}
		// This will make the executor accept no new threads
		// and finish all existing threads in the queue
		executor.shutdown();
		// Wait until all threads are finish
		System.out.println("The executror iwa waiting for all threads to finish");
		while (!executor.isTerminated()) {
			//System.out.println("Executor is waiting for  threads");
		}
		System.out.println("Finished all threads");
	}
}
