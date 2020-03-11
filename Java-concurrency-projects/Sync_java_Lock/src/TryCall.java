import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryCall extends CallMe {
	//Lock lockObj = new ReentrantLock();
	
	Lock lockObj;
	
	public TryCall(Lock lockObject){
		
		lockObj = lockObject;
	}

	public void call(String msg) throws InterruptedException {
//       //Acquires the lock if it is available and returns immediately 
		//with the value true. If the lock is not available then 
		//this method will return immediately with the value false. 
		
		lockObj.lock();
		//if (lockObj.lock()) 
		{
			try {
				// update protected state
				System.out.print("[");
				Thread.sleep(2000);

				System.out.print(msg);

				System.out.println("]");
				
				ReentrantLock lock1 = (ReentrantLock) lockObj;
				System.out.println("Now waiting threads are  "
						+ lock1.getQueueLength());

			} 
			finally 
			{
				lockObj.unlock();
			}
		} 
		//else {
			// execute alternative actions
			Thread.sleep(2000);
			Thread current = Thread.currentThread();
			System.out.println("No Lock could be aquired for .."+current.getName());

		}

	}
