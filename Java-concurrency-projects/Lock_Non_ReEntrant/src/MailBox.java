import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


  /*
   * Reentrant means that a thread that already holds a lock can retake it.
   * Java's synchronized blocks are reentrant. 
   * If a thread already holds the lock on a monitor object, it has access to all 
   * blocks synchronized on the same monitor object. 
   * This is  re-entrance. 
   * The thread can reenter any block of code for which it already holds the lock.    
   */
  
 public class MailBox  
 {
    int letter = 0;     
    

    public MailBox(){}
    Thread current;

  public synchronized int getLetter() 
    {
	  current = Thread.currentThread();
	   System.out.println("Got the letter number by thread  "+current.getName()+ "   "+letter);
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
        return letter;
    }
   public synchronized void putLetter(int n) 
    {
	   current = Thread.currentThread();
       this.letter = n;       
       
       try {
		Thread.sleep(3500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
       System.out.println("Put the letter number by thread  "+current.getName()+ "   "+letter);
       
       System.out.println("Entering into get Letter by the postMan ");
       
       int no = getLetter();
       System.out.println("Got Letter by the postMan "+no);
        
        
    }
   

   }