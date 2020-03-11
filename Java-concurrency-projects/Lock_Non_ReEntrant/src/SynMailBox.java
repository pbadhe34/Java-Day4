import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


  /*
   * Reentrant means that a thread that already holds a lock can retake it.
   * Java's synchronized blocks are reentrant.    
   */
  
 public class SynMailBox  extends MailBox
 {
    int letter = 0;     
    Lock lockObj;  // = new ReentrantLock();
    public SynMailBox(Lock lock){
    	lockObj = lock;
    }


  public  int getLetter() 
    {
	  System.out.println("Waiting for lock by the HoseOwner..");
	  lockObj.lock();
        System.out.println("Got the letter  "+letter);
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lockObj.unlock();
        return letter;
    }
   public  void putLetter(int n) 
    {
       this.letter = n;
       System.out.println("Waiting for lock by the PostMan..");
       lockObj.lock();
       try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       System.out.println("Put the letter  "+letter);
       System.out.println("POstman is trying for getLetter  "+letter);
       getLetter();
       
       lockObj.unlock();
        
    }
   

   }