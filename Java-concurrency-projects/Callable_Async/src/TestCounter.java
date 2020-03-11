
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCounter {

	private static final int NTHREDS = 4;

	// use the non-blocking counter
	public static void main(String[] args) {
		final Counter counter = new Counter();
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		
//      //The Executors class contains utility methods to convert from 
		//other common forms to Callable classes. 
		
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		//anonymous impl of Callable
		for (int i = 0; i < 10; i++) {
			Callable<Integer> worker = new Callable<Integer>() {
				// implement the call method
				public Integer call() throws Exception {
					int number = counter.increment();
					Thread.sleep(1000);
					System.out.println("The Counter is "+number);
					return number;
				}
			};
			Future<Integer> submitFuture = executor.submit(worker);
			list.add(submitFuture);
			

		}

		// This will make the executor accept no new threads
		// and finish all existing threads in the queue
		executor.shutdown();//no more new tasks to be added aftre this
		
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
		}
		Set<Integer> set = new HashSet<Integer>();
		for (Future<Integer> future : list) {
			try {
				System.out.println("The Future is done "+future.isDone());
				System.out.println("The Future is cancelled "+future.isCancelled());
				System.out.println("The Future output  "+future.get());
				set.add(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		if (list.size() != set.size()) {
			throw new RuntimeException("Double-entries!!!");
		}

	}

}
