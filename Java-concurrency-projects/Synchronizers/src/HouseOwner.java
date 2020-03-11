
  
  
 public class HouseOwner extends Thread
 {
    MailBox mailbox;
  public HouseOwner(MailBox m,String name)
  {
   this.mailbox = m;
   this.setName(name);
   }

  public void run()
  {
    int letters = 0;
    
    while(true)
     mailbox.getLetter();

  }
}
   