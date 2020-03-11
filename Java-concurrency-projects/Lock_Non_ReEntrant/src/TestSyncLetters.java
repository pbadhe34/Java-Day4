import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TestSyncLetters {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Starting here..");
		 
		 Lock lockObj = new ReentrantLock();
	    //SyncMailBox m = new SyncMailBox();
	    SynMailBox m = new SynMailBox(lockObj);
		PostMan p = new PostMan(m,"PostMan");
		HouseOwner h = new HouseOwner(m,"HouseOwner");
		
		h.start();//get the letter first
		
		Thread.sleep(3000);
		p.start();
		

	}
}