
  
  
 public class CallMe  
 {   
    MyLock lockObj = new MyLock();

  public void call(String msg)throws InterruptedException
    {
	  lockObj.lock();
	  
	  //safely do the critical work here 
        System.out.print("[");
        Thread.sleep(2000);

        System.out.print(msg);

        System.out.println("]"); 
        
        lockObj.unlock();

    
    }
}