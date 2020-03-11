import java.util.concurrent.Semaphore;


public class TestSignalling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Semaphore sema = new Semaphore(1);//permits count
		int count = sema.availablePermits();
		
		System.out.println("Starting the Threads with permits .."+count);
		ReceiverThread thread2 = new ReceiverThread(sema);		 
		
		
		Sender thread1 = new Sender(sema);
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//int no = sema.drainPermits();
		
		//System.out.println("Permits drained "+no);
		
		
		

	}

}
