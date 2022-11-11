package ProyectoConcurrent.DinningPhilosofer;

public class Philosopher implements Runnable {
 
    // Member variables, standard constructor
    // The forks on either side of this Philosopher 
    private Palillo leftFork;
    private Palillo rightFork;
 
    public Philosopher(Palillo leftFork, Palillo rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }
 
    private void doAction(String action) throws InterruptedException {
        System.out.println(
          Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }
 
   // Member variables, methods defined earlier
 
    @Override
    public void run() {
        try {
            while (true) {
                
                // thinking
                doAction(System.nanoTime() + ": Thinking");
                synchronized (leftFork) {
                    doAction(
                      System.nanoTime() 
                        + ": Picked up left fork");
                    synchronized (rightFork) {
                        // eating
                        doAction(
                          System.nanoTime() 
                            + ": Picked up right fork - eating"); 
                        
                        doAction(
                          System.nanoTime() 
                            + ": Put down right fork");
                    }
                    
                    // Back to thinking
                    doAction(
                      System.nanoTime() 
                        + ": Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}