
  
  
 public class HouseOwner extends Thread
 {
    MailBox mailbox;
  public HouseOwner(MailBox m)
  {
   this.mailbox = m;
   }

  public void run()
  {
     
    
    while(true)
     mailbox.getMessage();

  }
}
   