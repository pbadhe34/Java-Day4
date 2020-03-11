


	import java.util.concurrent.ScheduledThreadPoolExecutor;
	import java.util.concurrent.TimeUnit;
	
	class Job1 implements Runnable {
		  public void run() {
			  
			for(int i=0;i<5;i++)
		    {
		    try {
				Thread.sleep(500);
				System.out.println("Job 1 is running");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
		  }
		}

		class Job2 implements Runnable {
		  public void run() {
		      for(int i=0;i<9;i++){
		        System.out.println("Job2 outoput "+i);
		        try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		  }
		}

	public class ThreadSchedulerTest {

	  public static void main(String args[]) {
	    ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(1);
	    
	    
	    
	    stpe.schedule(new Job1(), 1, TimeUnit.SECONDS) ;
	    stpe.schedule(new Job2(), 1, TimeUnit.SECONDS) ;
	    
	    //one shot start after the delay
	    //start periodically after initial delay
	    
	    /*stpe.scheduleAtFixedRate(new Job1(), 0, 5, TimeUnit.SECONDS);
	    stpe.scheduleAtFixedRate(new Job2(), 1, 2, TimeUnit.SECONDS);*/
	    
	    int num = stpe.getActiveCount();
	    System.out.println("The runninhg threads are "+num);
	    
	    //stpe.getCompletedTaskCount();   
	    
	    
	    while (!stpe.isTerminated()) {
			//System.out.println("The scehduler is waiting for  threads");
		}
	    
	    try {
			stpe.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}

	