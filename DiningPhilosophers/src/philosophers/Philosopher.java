package philosophers;
import diningroom.Fork;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable{

	private int eatingTimeInSeconds;
	private String name;
	private Fork leftFork;
	private Fork rightFork;

	public Philosopher(String name, int eatingTimeInSeconds, Fork leftForkRef, Fork rightForkRef){
		this.name = name;
		this.eatingTimeInSeconds = eatingTimeInSeconds;
		this.leftFork = leftForkRef;
		this.rightFork = rightForkRef;
	}
	
	private void Think() {
		System.out.println("Now I " + this.name + " must think long and hard.");
	}
	
	private void Eat() {
		while(true){
			System.out.println("Hello, I am the philospher: " + this.name);
			System.out.println("Time to eat!");
			try {
				TimeUnit.SECONDS.sleep(this.eatingTimeInSeconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("I " + this.name + " am done eating. Finito.");
		}
	}

	@Override
	public void run() {
		this.Eat();
		this.Think();
	}
	
	public static void main(String[] args){
		Thread socratesThread = new Thread(new Philosopher("Socrates", 1));
		Thread platoThread = new Thread(new Philosopher("Plato", 2));
		Thread aristotleThread = new Thread(new Philosopher("Aristotle", 3));
		socratesThread.start();
		platoThread.start();
	}
	
	
}
