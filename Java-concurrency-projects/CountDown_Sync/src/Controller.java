import java.util.concurrent.CountDownLatch;

public class Controller {
	public static void main(String arg[]) throws InterruptedException {
		int count = 5;
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(count);

		for (int i = 0; i < count; ++i)
			// create and start threads
			new Thread(new Worker(startSignal, doneSignal)).start();

		someWork(); // don't let workers run yet
		startSignal.countDown(); // let all workers threads proceed
		// startSignal.countDown();

		doneSignal.await(); // wait for all workers to finish
		checkWork();
	}

	private static void someWork() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The Controller Work is here..");

	}

	private static void checkWork() {

		System.out.println("The Controller is updated ..");

	}
}
