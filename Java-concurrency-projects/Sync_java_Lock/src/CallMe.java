import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallMe {
	Lock lockObj = new ReentrantLock();

	public void call(String msg) throws InterruptedException {

		lockObj.lock();

		System.out.print("[");
		Thread.sleep(2000);

		System.out.print(msg);

		System.out.println("]");

		lockObj.unlock();

	}
}