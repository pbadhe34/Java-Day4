import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class TestMessages {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Starting Mutex sync here..");
		 
		ReentrantReadWriteLock readWriteLock = new  ReentrantReadWriteLock();
		
		MailBox m = new MailBox(readWriteLock);
		PostMan p = new PostMan(m,"PostMan");
		HouseOwner h = new HouseOwner(m,"HouseOwner");
		//another long time wtite locking thread
		LazyMan slowMan = new LazyMan(m,"Lazier");
		
		p.start();//pet the message first	
		h.start();
		
		slowMan.start();
		 
		
		

	}
}