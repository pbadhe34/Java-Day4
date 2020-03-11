import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;

	Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	public void run() {
		try {
			System.out.println("The worker is waiting to start..");
			startSignal.await();
			WorkItOut();
			doneSignal.countDown();
		} catch (InterruptedException ex) {
		}
	}

	void WorkItOut() {
		System.out.println("The Worker work here..");
		try {
			Thread.sleep(1400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
