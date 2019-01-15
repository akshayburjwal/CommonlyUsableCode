package inter.prep.multithreading.dining.phlosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	Integer id;

	Lock lock;

	public Chopstick(Integer id) {
		super();
		this.id = id;
		this.lock = new ReentrantLock();
	}

	boolean pickup(Philosopher p, State s) {
		try {
			if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
				System.out.println(p + " picked up" + this + "in its " + s);
				return true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	void putDown(Philosopher p, State s) {
		System.out.println(p + " putdown" + this + "in its " + s);
		lock.unlock();

	}

	@Override
	public String toString() {
		return " Chopstick [id=" + id + "]";
	}

}
