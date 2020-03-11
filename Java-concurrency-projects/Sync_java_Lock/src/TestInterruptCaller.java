
public class TestInterruptCaller {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Starting TestInterruptCaller here...");
		System.out.println(" ");
		FastTimeOutCall target = new FastTimeOutCall();
		Caller thread1 = new Caller(target, "Hello","First");
		Caller thread2 = new Caller(target, "Java-Lock- Synchronized","Second");
		Caller thread3 = new Caller(target, "World","Third");
		target.call("");
		 
		//thread1.t.interrupt();
	 	 
		thread2.t.interrupt();
		thread3.t.join();

		System.out.println("This is the End ");

	}
}