import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//This demonstartes creating a thread pool and executing them
public class TestThreadExecutor {

	private static final int NTHREDS = 10;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		for (int i = 0; i < 50; i++) {
			Runnable worker = new MyThread(10000L + i, "Thread" + i);
			executor.execute(worker);
		}
		// This will make the executor accept no new threads
		// and finish all existing threads in the queue
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {

		}
		System.out.println("Finished running all threads");
	}

}
