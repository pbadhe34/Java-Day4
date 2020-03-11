


	import java.util.concurrent.Semaphore;
	
	class MyThread implements Runnable {
		  Semaphore sem;
		  String msg;
		  String name;
		  MyThread(Semaphore s, String message,String tName) {
		    sem = s;
		    msg = message;
		    name = tName;		    
		  }

		  public void run() {
		    try {
		      System.out.println(name + "  is waiting to get permit");
		      sem.acquire();
		      System.out.println(msg);
		      Thread.sleep(6000);
		      sem.release();
		      System.out.println(name + "  has released the permit");
		    } catch (Exception exc) {
		      System.out.println("Error Writing message");
		    }
		  }
		}

	public class TestPermits {
	  public static void main(String args[]) throws Exception {
	    Semaphore sem = new Semaphore(1);
	    //two permits to allow two threads at a time to run
	    Thread thrdA = new Thread(new MyThread(sem, "Message 1","First"));
	    Thread thrdB = new Thread(new MyThread(sem, "Message 2","Second"));
	    Thread thrdC = new Thread(new MyThread(sem, "Message 3","Third"));
	    Thread thrdD = new Thread(new SmartThread(sem, "SmartMessage","Baba"));

	    thrdA.start();
	    thrdB.start();
	    thrdC.start();
	    thrdD.start();
	    Thread.sleep(1000);
	    
	    System.out.println("Threads waiting on the semaphore here are "+sem.getQueueLength());

	    thrdA.join();
	    thrdB.join();
	    thrdC.join();
	    System.out.println("End of main");
	     

	  }
	}
	class SmartThread implements Runnable {
		  Semaphore sem;
		  String msg;
		  String name;
		  SmartThread(Semaphore s, String message,String tName) {
		    sem = s;
		    msg = message;
		    name = tName;		    
		  }

		  public void run() {
		    try {
		      System.out.println("Smart Thread  "+ name + "  is waiting to get permit");
		      if(sem.tryAcquire()==false)
		      {
		    	  System.out.println("SmartThread has not received lock hence trying to get it..");
		    	  sem.release();
		      }
		      sem.tryAcquire();//try it again..	
		      System.out.println(msg);
		      Thread.sleep(6000);
		      sem.release();
		      System.out.println("Smart Thread  "+name + "  has released the permit");
		    } catch (Exception exc) {
		      System.out.println("Error Writing message");
		    }
		  }
		}

	