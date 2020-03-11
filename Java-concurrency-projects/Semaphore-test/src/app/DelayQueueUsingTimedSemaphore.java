package app;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.TimedSemaphore;
 

class DelayQueueUsingTimedSemaphore {

    private final org.apache.commons.lang3.concurrent.TimedSemaphore semaphore;

    DelayQueueUsingTimedSemaphore(long period, int slotLimit) {
        semaphore = new TimedSemaphore(period, TimeUnit.SECONDS, slotLimit);
    }

    boolean tryAdd() {       
         try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return true;
        
    }

    int availableSlots() {
        return semaphore.getAvailablePermits();
    }

}
