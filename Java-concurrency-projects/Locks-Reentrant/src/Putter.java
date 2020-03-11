
  
  
 public class Putter extends Thread
 {
  MyBuffer buffer;
  public Putter(MyBuffer m,String name)
  {
   this.buffer = m;
   this.setName(name);
   }

  public void run()
  {
    int count = 0;
    
    while(true){
     try {
		buffer.put(new Object());
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		 System.out.println("The putter  "+this.getName()+" interrupted..");
		    
	}
     count++;
     System.out.println("Object count is  "+count +" in putter  "+this.getName());
     if(count > 100)
    	 break;
    }
    
    

  }
}
   