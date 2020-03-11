package app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.MoreExecutors;

/**
 * This class demonstrates the usage of Guava's exiting executor services that keep the VM from hanging.
 * Without the exiting executor service, the task would hang indefinitely. * 
 */
public class ExitingExecutorServiceApp {

    public static void main(String... args) {

        final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        final ExecutorService executorService = MoreExecutors.getExitingExecutorService(executor, 10000, TimeUnit.MILLISECONDS);

        executorService.submit((Runnable) () -> {
            while (true) {
            	System.out.println("The exetor pool is running ");
            	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

    }

}
