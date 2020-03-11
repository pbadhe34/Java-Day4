import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TryCaller {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Starting TryCaller here...");
		System.out.println(" ");
		ReentrantLock lockObject = new ReentrantLock();

		TryCall target = new TryCall(lockObject);
		Caller thread1 = new Caller(target, "Hello","First");
		Caller thread2 = new Caller(target, "JavaLocks- Synchronized","Second");
		Caller thread3 = new Caller(target, "World","Third");
		
		

		System.out.println(" ");
		thread1.t.join();
		thread2.t.join();
		thread3.t.join();

		System.out.println("This is the End ");

	}
}