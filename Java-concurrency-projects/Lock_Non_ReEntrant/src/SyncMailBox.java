import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


   //Non re-entrant locking
  
 public class SyncMailBox  extends MailBox
 {
	 int letter = 0;
		boolean empty = false;

		public synchronized int getLetter() {
			current = Thread.currentThread();
			   
			if (!(empty)) {
				try {
					System.out.println("The thread  "+current.getName()+ "  is waiting to get letters..");
					   
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Got the letter by the thread  "+current.getName() +"  " + letter);
			empty = false;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// What happens if following line is commented ?
			notify();
			return letter;
		}

		public synchronized void putLetter(int n) {
			current = Thread.currentThread();
			if (empty) {
				try {
				System.out.println("The thread  "+current.getName()+ "  is waiting to put letters..");
					
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.letter = n;
			 
			
			System.out.println("Put the letter number by thread  "+current.getName()+ "   "+letter);
		       
		       System.out.println("Entering into get Letter by the postMan ");
		       	       
		       int no = getLetter();
		       System.out.println("Got Letter by the postMan "+no);
		       empty = true;	
		       
		       try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
			// What happens if following line is commented ?
				System.out.println("The post man is notifying..");
			notify();

		}
 }