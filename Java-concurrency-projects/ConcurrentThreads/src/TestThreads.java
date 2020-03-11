import java.util.ArrayList;
import java.util.List;

public class TestThreads {

	public static void main(String[] args) {
		// We will store the threads so that we can check if they are done
		List<Thread> threads = new ArrayList<Thread>();
		// Create 50 threads
		for (int i = 0; i < 50; i++) {
			Runnable task = new MyThread(1000L + i, "Thread " + i);// pass the
																	// count
																	// value
			Thread worker = new Thread(task);
			// We can set the name of the thread
			worker.setName(String.valueOf(i));
			// Start the thread, never call method run() direct
			worker.start();
			// Remember the thread for later usage
			threads.add(worker);
		}
		int running = 0;
		do {
			running = 0;
			for (Thread thread : threads) {
				if (thread.isAlive()) {
					running++;
				}
			}
			System.out.println("We have " + running + " running threads. ");
		} while (running > 0);

	}
}
