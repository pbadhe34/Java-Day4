import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyService {
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    //The threads in a thread pool service incoming requests
    public MyService(int port, int poolSize) throws IOException {
      serverSocket = new ServerSocket(port);
      pool = Executors.newFixedThreadPool(poolSize);
    }
 
    public void startWork() {
      try {
        for (;;) {
        	//make and run a new thread for each new client request
          System.out.println("Running the pool threads ");
          pool.execute(new ServiceHandler(serverSocket.accept()));
        }
      } catch (IOException ex) {
        pool.shutdown();
      }
    }
  }
class ServiceHandler implements Runnable {
    private final Socket socket;
    ServiceHandler(Socket socket) { this.socket = socket; }
    public void run() {
      // read  request and service the clients
    	System.out.println("Running the ServiceHandler thread  ");
    }
 }

 
public class ExecutorServerService {

	/**
	 * The ExecutorService An Executor that provides methods to manage termination and methods 
	 * that can produce a Future for tracking progress of one or more asynchronous tasks. 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		MyService service = new MyService(1080,10);
		service.startWork();

	}

}

