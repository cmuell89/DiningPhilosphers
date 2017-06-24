package philosophers;
import diningroom.Fork;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable{

	private String name;
	private Fork leftFork;
	private Fork rightFork;

	public Philosopher(String name, Fork leftForkRef, Fork rightForkRef){
		this.name = name;
		this.leftFork = leftForkRef;
		this.rightFork = rightForkRef;
	}
	
	private void Think() {

	    System.out.println("Now I " + this.name + " must think long and hard.");
        try {
            TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	private void Eat() {

        if (leftFork.pickUp() == true) {
            if (rightFork.pickUp() == true) {
                try {
                    System.out.println("I, " + this.name + ", am eating!");
                    TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
//            Premption
            leftFork.putDown();
            this.Eat();
        }
        leftFork.putDown();
        rightFork.putDown();
    }

	@Override
	public void run() {
	    while(true) {
            this.Eat();
            this.Think();
        }
	}




}