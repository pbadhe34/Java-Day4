import java.util.concurrent.locks.ReentrantLock;

public class TimeOutCaller {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Starting callers here...");
		System.out.println(" ");

		ReentrantLock lockObject = new ReentrantLock();

		TimeOutCall target = new TimeOutCall(lockObject);
		Caller thread1 = new Caller(target, "Hello", "First");
		Caller thread2 = new Caller(target, "JavaLocks- Synchronized", "Second");
		Caller thread3 = new Caller(target, "World", "Third");

		System.out.println(" ");
		// thread1.t.interrupt();

		// thread2.t.interrupt();
		thread1.t.join();

		System.out.println("This is the End ");

	}
}