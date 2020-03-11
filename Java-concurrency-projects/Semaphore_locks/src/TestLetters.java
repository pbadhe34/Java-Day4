import java.util.concurrent.Semaphore;


public class TestLetters {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Starting here..");
		Semaphore sema = new Semaphore(1);//permits count
		int count = sema.availablePermits();
		
		System.out.println("Starting the Threads with permits .."+count);

		MailBox m = new MailBox(sema);
		PostMan p = new PostMan(m);
		PostMan p2 = new PostMan(m);
		HouseOwner h = new HouseOwner(m);
		h.start();
		Thread.sleep(3000);
		p.start();
		p2.start();

	}
}