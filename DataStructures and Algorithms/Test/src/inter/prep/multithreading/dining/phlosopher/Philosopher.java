package inter.prep.multithreading.dining.phlosopher;

import java.util.Random;

public class Philosopher implements Runnable {
	Integer id;
	Chopstick left;
	Chopstick right;
	Random random;
	Integer eatcount = 0;

	private volatile boolean IsFull;

	public Philosopher(Integer id, Chopstick left, Chopstick right) {
		super();
		this.id = id;
		this.left = left;
		this.random = new Random();
	}

	@Override
	public void run() {
		while (!isIsFull()) {
			try {
				think();
				if (left.pickup(this, State.LEFT)) {
					if (book.pickup(this, State.RIGHT)) {
						eating();
						Thread.sleep(random.nextInt(1000));
						book.putDown(this, State.RIGHT);
					}
					left.putDown(this, State.LEFT);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void eating() throws InterruptedException {
		System.out.println(this + "Eating");
		eatcount++;
	}

	private void think() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(this + "thinking");
	}

	@Override
	public String toString() {
		return "Philosopher [id=" + id + "]";
	}

	public boolean isIsFull() {
		return IsFull;
	}

	public void setIsFull(boolean isFull) {
		IsFull = isFull;
	}

}
