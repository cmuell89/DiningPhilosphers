import diningroom.Fork;
import philosophers.Philosopher;

import java.util.ArrayList;


/**
 * Created by carl on 3/25/17.
 */
public class Main {
    public static void main(String[] args) {

        Fork[] tableForks = {new Fork(), new Fork(), new Fork(), new Fork()};
        ArrayList<Thread> philosopherThreads = new ArrayList<>();

        philosopherThreads.add(new Thread(new Philosopher("Socrates", 2, tableForks[0], tableForks[1])));
        philosopherThreads.add(new Thread(new Philosopher("Plato", 1, tableForks[1], tableForks[2])));
        philosopherThreads.add(new Thread(new Philosopher("Aristotle", 1, tableForks[2], tableForks[3])));
        philosopherThreads.add(new Thread(new Philosopher("Epicurus", 1, tableForks[3], tableForks[0])));

        for (Thread thread : philosopherThreads) {
            thread.start();
        }

    }
}
