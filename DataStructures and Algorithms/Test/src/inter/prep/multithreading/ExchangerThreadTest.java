package inter.prep.multithreading;

import java.util.concurrent.Exchanger;

class ThreadFirst implements Runnable {
	int counter = 0;
	Exchanger<Integer> exc;

	public ThreadFirst(Exchanger<Integer> exc) {
		this.exc = exc;
	}

	@Override
	public void run() {
		try {
			counter++;
			Thread.sleep(10000);
			System.out.println("counter 1 = " + counter);
			counter = exc.exchange(counter);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ThreadSecond extends Thread {
	int counter = 0;
	Exchanger<Integer> exc;

	public ThreadSecond(Exchanger<Integer> exc) {
		this.exc = exc;
	}

	@Override
	public void run() {
		try {
			counter = exc.exchange(counter);
			counter--;
			System.out.println("counter 2 = " + counter);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class ExchangerThreadTest {

	public static void main(String[] args) {
		Exchanger<Integer> ex = new Exchanger<>();
		Thread t1 = new Thread(new ThreadFirst(ex));
		Thread t2 = new ThreadSecond(ex);
		t1.start();
		t2.start();
		System.out.println("Ended");
	}

}
