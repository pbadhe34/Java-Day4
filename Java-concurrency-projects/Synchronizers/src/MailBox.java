import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Reentrant means that a thread that already holds a lock can retake it.
 * Non -reentant behaviour   *     
 */

public class MailBox {
	int letter = 0;
	MyMutex mutex;

	public MailBox(MyMutex mu) {
		mutex = mu;
	}

	Thread current;

	public int getLetter() {
		current = Thread.currentThread();
		System.out.println("The thread  " + current.getName()
				+ " is waiting in getletter ");

		/*if (mutex.isLocked()) {
			System.out
					.println("The object is locked hence trying to release by thread  "
							+ current.getName());
			mutex.unlock();
		}*/
		mutex.lock();
		System.out.println("Got the letter number by thread  "
				+ current.getName() + "   " + letter);
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The thread  " + current.getName()
				+ " is exiting the getletter ");

		mutex.unlock();
		return letter;
	}

	public void putLetter(int n) {

		current = Thread.currentThread();
		System.out.println("The thread  " + current.getName()
				+ " is waiting in putletter ");

		mutex.lock();
		this.letter = n;

		try {
			Thread.sleep(1600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Put the letter number here by thread  "
				+ current.getName() + "   " + letter);

		System.out.println("Entering into get Letter by the postMan ");

		int no = getLetter();
		System.out.println("Got Letter by the postMan " + no);

		System.out.println("The thread  " + current.getName()
				+ " is exiting the putletter ");

		mutex.unlock();

	}

}