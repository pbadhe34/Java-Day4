import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimeOutCall extends CallMe {
	// Lock lockObj = new ReentrantLock();

	Lock lockObj;

	public TimeOutCall(Lock lockObject) {

		lockObj = lockObject;
	}

	public void call(String msg) {
		Thread current = Thread.currentThread();

		try {
			ReentrantLock lock1 = (ReentrantLock) lockObj;

			// lock within the time or else time out
			if (lockObj.tryLock(1500, TimeUnit.MILLISECONDS)) {

				// update protected state

				Thread.sleep(1000);
				System.out.println("Now waiting threads are  "
						+ lock1.getQueueLength());

				System.out.print("[");
				System.out.print(msg);

				System.out.println("]");

				lockObj.unlock();
			} else {
				// execute alternative actions
				// Thread.sleep(1500);

				System.out
						.println("No Lock could be aquired within time for  .."
								+ current.getName());

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("The Thread   " + current.getName()
					+ "  got interruputed");

		}

	}
}