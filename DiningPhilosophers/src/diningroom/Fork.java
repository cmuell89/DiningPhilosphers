package diningroom;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Fork {
    private Semaphore sem = new Semaphore(1);

    public Fork() {
    }

    public boolean pickUp() {
        try {
            return sem.tryAcquire(1, 500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void putDown() {
        sem.release();
    }

}
