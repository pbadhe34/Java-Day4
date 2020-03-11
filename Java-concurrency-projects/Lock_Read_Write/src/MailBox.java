import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

 

public class MailBox {
	 
	
	private final Map<String, MessageData>  map = new TreeMap<String, MessageData>();
    private final ReentrantReadWriteLock rwl ;
    private final Lock readLock ;
    private final Lock writeLock ;


	public MailBox(ReentrantReadWriteLock lockObject) {
		rwl = lockObject;
		readLock = rwl.readLock();
		writeLock = rwl.writeLock();
		
	}

	 

	public MessageData  getMessage(String key) {
		Thread current = Thread.currentThread();
		System.out.println("The thread  " + current.getName()
				+ " is waiting in getMessage ");

		MessageData data = null;
		/*//check if current thread can release the write lock ..
		if(rwl.isWriteLocked())
		{
			System.out.println("The current lock is write locked by another thread..trying to " +
					"unlock it from current thread..");
			rwl.writeLock().unlock();
			
		}*/
		
		readLock.lock();//acquire read lock
		 
		try {
			Thread.sleep(600);
			data = map.get(key);
			
			///readLock.unlock();//must first release the read lock before acqiring write lock
			
			/*System.out.println("Trying to call putMessage..from getMessage..");
			key = "newKey";
			putMessage(key, data);*/
			///Dead Lock : trying to get write lock from within read lock
			
			//Reacquire bthe lock if coming from putMessage write lock
			//readLock.lock();
			
			} 
		catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
		finally {
			readLock.unlock(); 
		}
		 
		System.out.println("The thread  " + current.getName()
				+ " is exiting the getMessage ");
		 
		return data;
	}

	public void putMessage(String key,MessageData data,long sleepTime) {

		Thread current = Thread.currentThread();
		System.out.println("The thread  " + current.getName()
				+ " is waiting in putMessage ");
		
		//check if current thread can release the read lock from another thraed ..
		//if(sleepTime > 4000)
		{			
			System.out.println("The thread  " + current.getName()+" is relesing the write lock ");
			 
			if(rwl.isWriteLocked())
			 // if(rwl.isWriteLockedByCurrentThread())
				{
				/*
				 * Only the owner therad can release the lock
				 */
					System.out.println("The current lock is write locked by another thread..trying to " +
							"unlock it from current thread..");
					rwl.writeLock().unlock();
					
				}
		}

		writeLock.lock();//acquire write lock
		 

		try {
			Thread.sleep(sleepTime);
			map.put(key, data);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		System.out.println("Put the message data  here by thread  "
				+ current.getName() + " for  " + key);

		/*System.out.println("Entering into getMessage by  "+current.getName());
		//The read lock can be acquired without releasing he write Lock 

		MessageData dataNext = getMessage(key);
		
		System.out.println("Got Message by the " +current.getName()+"  "+dataNext.getMessage());
*/
		System.out.println("The thread  " + current.getName()
				+ " is exiting the putMessage ");

		writeLock.unlock(); 

	}

}