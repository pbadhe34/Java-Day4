import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FastTimeOutCall extends CallMe {
	Lock lockObj = new ReentrantLock();

	public void call(String msg)   {
		Thread current = Thread.currentThread();

	try {
		  //lock within the time or else  time out 
		if (lockObj.tryLock(1200, TimeUnit.MILLISECONDS) )
				
		  //lockObj.lockInterruptibly();
			{
				 
					// update protected state
					
					Thread.sleep(1000);
					System.out.print("[");
					System.out.print(msg);

					System.out.println("]");

				 
					lockObj.unlock();
			}
			// execute alternative actions
			else  			 
				System.out.println("No Lock could be aquired within time for  .."+current.getName());

			 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("The Thread   "+current.getName()+"  got interruputed");

		}

	}
}