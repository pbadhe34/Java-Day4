
  
  
 public class PostMan extends Thread
 {
    MailBox mailbox;
  public PostMan(MailBox m,String name)
  {
   this.mailbox = m;
   this.setName(name);
   }

  public void run()
  {
    int letters = 0;
    
    while(true)
     mailbox.putLetter(++letters);

  }
}
   