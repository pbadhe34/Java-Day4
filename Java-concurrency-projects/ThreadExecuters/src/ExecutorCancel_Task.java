 import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
 

class Task implements Callable<String> 
{
    private final String name;
 
    public Task(String name) {
        this.name = name;
    }

	public String call() throws Exception {
		 System.out.println("Task [" + name + "] executing on : " + LocalDateTime.now().toString());
		 Thread.sleep(10000);
		 return "Message for Success";
	}
 
     
}
public class ExecutorCancel_Task 
{
    public static void main(String[] args) throws InterruptedException, ExecutionException 
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
         
        LocalDateTime now = LocalDateTime.now();
            LocalDateTime afterOneMinute = now.plusMinutes(1);
      
            Duration duration = Duration.between(now, afterOneMinute);
           // long delay = Math.abs(duration.toMillis());
            
            long delay = 1;
         
            System.out.println("Task scheduled at : "+ LocalDateTime.now()+"  "+delay);
         
            //The async type for tracking
            ScheduledFuture<String> result = executor.schedule(new Task("Task-1"), delay, TimeUnit.MILLISECONDS);
         
       
        
         Thread.sleep(2000);
         
         System.out.println("Task is done : " + result.isDone());
       
         
        if(result.isDone() == false) 
        {
            System.out.println("====Cancelling the task====");
 
            result.cancel(true);
        }
        else
        	  System.out.println("Task output is : " + result.get());
         
        System.out.println("Task is cancelled : " + result.isCancelled());
         
        System.out.println("Task is done : " + result.isDone());
         
        executor.shutdown();
    }
}
 
