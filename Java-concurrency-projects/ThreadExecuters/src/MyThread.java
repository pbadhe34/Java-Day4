public class MyThread implements Runnable {
	private final long countUntil;

	MyThread(long countUntil) {
		this.countUntil = countUntil;
	}

	public void run() {
		System.out.println("Starting  "+Thread.currentThread().getName());
		long sum = 0;
		for (long i = 1; i < countUntil; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sum += i;
		}
		System.out.println("MyThread result number  is  "+sum);

	}

}
