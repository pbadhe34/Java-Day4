import java.util.concurrent.Semaphore;

public class ReceiverThread extends Thread {

	Semaphore semaphore = null;

	public ReceiverThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	// Release a permit, returning it to the semaphore.
	public void run() {
		int count =1;
		while (true) {
			
			try {
				System.out.println("The receiver Thread starts.."+count);
				Thread.sleep(5000);
				count++;
				if(count < 5)
				{
				 this.semaphore.release();
				 // receive signal, then do something...
				 System.out.println("The receiver Thread released the permit..");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
