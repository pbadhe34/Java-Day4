
public class TestMultipleSignalling {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Starting Multiple Thraed Signalling here..");

		MyBuffer m = new MyBuffer();
		Putter p1 = new Putter(m,"First");
		Putter p2 = new Putter(m,"Second");
		Putter p3 = new Putter(m,"Third");
		
		Taker t1 = new Taker(m,"Taker1");
		Taker t2 = new Taker(m,"Taker2");
		//Taker t3 = new Taker(m,"Taker3");
		
		t1.start();
		p1.start();
		p2.start();
		p3.start();
		
		t2.start();
		
		
		 
		Thread.sleep(1000);
		
		

	}
}