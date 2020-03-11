
  
  
 public class LazyMan extends Thread
 {
    MailBox mailbox;
  public LazyMan(MailBox m,String name)
  {
   this.mailbox = m;
   this.setName(name);
   }

  public void run()
  {
    String  key =""+1;
    String message = "Message "+key;
    MessageData data = new MessageData();
    data.setHeader(key);
    data.setMessage(message);
    
    while(true)
    {
    	mailbox.putMessage(key, data,10000);
    	int i = Integer.parseInt(key);
    	i++;
    	key = ""+i;
    	message = "Message "+key; //set new values
    	data.setHeader(key);
    	data.setMessage(message);
    	
    }
     
  }
}
   