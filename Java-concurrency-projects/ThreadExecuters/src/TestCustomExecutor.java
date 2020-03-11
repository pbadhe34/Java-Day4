import java.util.concurrent.Executor;

/*
 * Executor is an object that executes submitted Runnable tasks. 
 * This interface provides a way of decoupling task submission from the mechanics 
 * of how each task will be run, including details of thread use, scheduling, etc. 
 * An Executor is normally used instead of explicitly creating and running the threads.
 *  For example, rather than invoking new Thread(new(RunnableTask())).start() 
 *  for each of a set of tasks, use: 
 *  Executor executor = new Executor();
 *  executor.execute(new RunnableObject());

 */
class MyExecutor implements Executor 
{
	
	public void execute(Runnable thread) {
        thread.run();
    }

}
//spawn a new thread while executing
class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r) {
        new Thread(r).start();
    }
}

public class TestCustomExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Executor executor = new MyExecutor();
		executor.execute(new MyRunnable(10000));
		executor.execute(new MyRunnable(20000));

	}

}
