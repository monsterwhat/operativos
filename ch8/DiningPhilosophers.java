package ProyectoConcurrent.DinningPhilosofer;

public class DiningPhilosophers {
    public static void main(String[] args) throws Exception {
 
        Philosopher[] philosophers = new Philosopher[5];
        Palillo[] forks = new Palillo[philosophers.length];
 
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Palillo();
        }
 
        for (int i = 0; i < philosophers.length; i++) {
            Palillo leftFork = forks[i];
            Palillo rightFork = forks[(i + 1) % forks.length];
 
            philosophers[i] = new Philosopher(leftFork, rightFork);
            
            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
