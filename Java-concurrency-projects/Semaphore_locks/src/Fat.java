 
// Objects that are expensive to create.
//Custom Types 
public class Fat {
  private volatile double d; // Prevent optimization
  private static int counter = 0;
  private final int id = counter++;
  public Fat() {
    // Expensive, interruptible operation:
    for(int i = 1; i < 1000; i++) {
      d += (Math.PI + Math.E) / (double)i;
    }
  }
  public void operation() { System.out.println(this); }
  public String toString() { return "Fat id: " + id; }
}  
