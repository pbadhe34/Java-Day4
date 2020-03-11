
  
  
 public class Caller implements Runnable
 {
   String msg;
   CallMe target;
   Thread t;    
    
    public Caller(CallMe c,String s,String name)
    {
   
     target = c;
     msg = s;
     t = new Thread(this);
     t.setName(name);
     t.start();
    

    }
     
   public void run()
    {
   try
     {
     target.call(msg);      
     }
     catch(InterruptedException e)
     {
     System.out.println("Exception in Caller  :"+e);
      }
  }
}

  