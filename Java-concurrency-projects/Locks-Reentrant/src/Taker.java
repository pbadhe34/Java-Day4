
  
  
 public class Taker extends Thread
 {
  MyBuffer buffer;
  public Taker(MyBuffer m,String name)
  {
   this.buffer = m;
   this.setName(name);
   }

  public void run()
  {
    int count = 0;
    
    while(true){
     try {
		Object obj = buffer.take() ;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		 System.out.println("The Taker  "+this.getName()+ " interrupted..");
		    
	}
     count++;
     System.out.println("Object count is  "+count +" in Taker  "+this.getName());
     if(count > 100)
    	 break;
    }
    
    

  }
}
   