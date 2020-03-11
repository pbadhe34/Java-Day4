
  
  
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
    String key = ""+1;
    
    while(true)
    {
    	MessageData data = mailbox.getMessage(key);
    	int i = Integer.parseInt(key);
    	i++;
    	key = ""+i;
    	if(data !=null)
    	  System.out.println("The message read by HouseOwner is "+data.getMessage());
    	else
    		System.out.println("The message read is null data ");
    }     

  }
}
   