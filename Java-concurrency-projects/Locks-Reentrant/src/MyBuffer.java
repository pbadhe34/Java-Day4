import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Want to keep waiting 'putter' threads and 'taker' threads in separate 
 * wait-sets so that we can use the optimization of only notifying a 
 * single thread at a time when items or spaces become available in the buffer.
 * This can be achieved using two Condition instances. 
 */
public class MyBuffer {

	final Lock lock = new ReentrantLock();
	   final Condition notFull  = lock.newCondition(); 
	   final Condition notEmpty = lock.newCondition(); 

	   final Object[] items = new Object[100];
	   int putptr, takeptr, count;

	   public void put(Object x) throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == items.length) 
	         notFull.await();//wait if items is full for putter threads
	       System.out.println("Putting the items by..."+Thread.currentThread().getName());
	       items[putptr] = x; 
	       if (++putptr == items.length) putptr = 0;
	       ++count;
	       notEmpty.signal();//signal the Emptier taker threads
	     } finally {
	       lock.unlock();
	     }
	   }

	   public Object take() throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == 0) 
	         notEmpty.await();//wait for Emptier threads
	       
	       System.out.println("Emtying the items by   "+Thread.currentThread().getName()); 
	       Object x = items[takeptr]; 
	       if (++takeptr == items.length) takeptr = 0;
	       --count;
	       notFull.signal();//Single the Putter threads
	       return x;
	     } finally {
	       lock.unlock();
	     }
	   } 
	 }
	 
