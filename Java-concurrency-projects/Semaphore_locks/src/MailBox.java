import java.util.concurrent.Semaphore;


  
  
 public class MailBox  
 {
    String msg;
    public Semaphore sema = null;

	public MailBox(Semaphore semaphore) {
		this.sema = semaphore;
	}
    /*
     * Since only one thread is allowed to acquire the permit from semaphore,
     * all other threads calling acquire() will be blocked until release() is called. 
     * The call to release() will never block since there has always been a call to acquire() first. 
     */

  public  void getMessage()  
    {
	  
        try {
        	Thread.sleep(6700);
			System.out.println("Got the new message  "+msg);
			sema.release();//release it so another thread will use it
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         
    }
   public  void putMessage(String data) 
    {
	  
         try {
        sema.acquire();//obtain the lock
		Thread.sleep(2000);
		this.msg = data;
	       System.out.println("Put the new message  "+data);
	      // System.out.println("Permits avilable are  "+sema.availablePermits());
	  	 
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
        
    }

   }