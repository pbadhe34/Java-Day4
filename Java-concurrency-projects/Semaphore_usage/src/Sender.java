import java.util.concurrent.Semaphore;

public class Sender extends Thread {

	Semaphore semaphore = null;

	public Sender(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
//Acquire a permit from this semaphore, blocking until one is available,
//or the thread is interrupted
	public void run() {
		while (true) {
			// do something, then signal
			try {				
				Thread.sleep(1000);
				System.out.println("The Sender Thread is waiting");
				this.semaphore.acquire();//request permit from semaphore
				System.out.println("The Sender acquired the permit..");
				 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
