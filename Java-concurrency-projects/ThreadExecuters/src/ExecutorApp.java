import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorApp {

	public static void main(String[] args) {
		// ExecutorService pool = Executors.newSingleThreadExecutor();

		ExecutorService executorThreadPool = Executors.newFixedThreadPool(2);

		Runnable task1 = new Runnable() {

			public void run() {
				boolean flag = true;
				while (flag) {
					System.out.println(Thread.currentThread().getName() + " is running");

					// System.out.println(Thread.currentThread().getName()+ " :
					// "+Thread.currentThread().isInterrupted());

					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Thread 1 is interuupted by executor  and hence exiting");
						flag = false;
					}
				}
			}
		};

		Runnable task2 = new Runnable() {
			public void run() {
				boolean flag = true;
				while (flag) {
					System.out.println(Thread.currentThread().getName() + " is running");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Thread 2 is interuupted  by executor  and hence exiting");
						flag = false;
					}
				}
			}
		};

		Runnable task3 = new Runnable() {
			public void run() {
				boolean flag = true;
				while (flag) {
					System.out.println(Thread.currentThread().getName() + " is running");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Task3 3 is interuupted  by executor  and hence exiting");
						flag = false;
					}
				}
			}
		};

		/*
		 * executorThreadPool.execute(task1); executorThreadPool.execute(task2);
		 */

		executorThreadPool.submit(task1);
		executorThreadPool.submit(task2);

		executorThreadPool.submit(task3);

		// executorThreadPool.invokeAny(task1);

		System.out.println("Executor is running the tasks.");

		// java.util.concurrent.RejectedExecutionException:
		// executorThreadPool.execute(task2);

		// waits for previously submitted tasks to execute, and then terminates the
		// executor.

		executorThreadPool.shutdown(); // No further tasks to be added after this call

		try {

			// blocks until all of the started tasks have completed. provide a timeout to
			// prevent waiting forever.
			// executorThreadPool.awaitTermination(timeout, unit)
			boolean flag = executorThreadPool.awaitTermination(5, TimeUnit.SECONDS);
			// The result us true if succesfilly terminated the tasks.
			if (flag == false) {
				System.out.println("The executoer terminated beacuse of timout  ");
				List<Runnable> notExecutedTasks = executorThreadPool.shutdownNow();

				System.out.println("The pending tasks are " + notExecutedTasks.size());
				System.out.println("The pending task is " + notExecutedTasks.get(0));
				// notExecutedTasks.get(0).toString()

			}

		} catch (Exception e) {

			System.out.println("The executoer is finishing ");
		}

	}

}
