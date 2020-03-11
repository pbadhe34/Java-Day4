
  
  
 public class PostMan extends Thread
 {
    MailBox mailbox;
  public PostMan(MailBox m)
  {
   this.mailbox = m;
   }

  public void run()
  {
    int msgNo = 0;
    
    while(true){
    	msgNo++;
    	mailbox.putMessage("Message Number  "+msgNo);
    	if(msgNo > 10)
    		mailbox.sema.drainPermits();
    	
    }
     

  }
}
   