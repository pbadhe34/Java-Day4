
public class TestCaller {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Starting callers here...");
		System.out.println(" ");
		CallMe target = new CallMe();
		Caller thread1 = new Caller(target, "Hello","First");
		Caller thread2 = new Caller(target, "Lock- Synchronized","Second");
		Caller thread3 = new Caller(target, "World","Third");
		target.call("");
		 
	 	thread1.t.join();
		thread2.t.join();
		thread3.t.join();

		System.out.println("This is the End ");

	}
}