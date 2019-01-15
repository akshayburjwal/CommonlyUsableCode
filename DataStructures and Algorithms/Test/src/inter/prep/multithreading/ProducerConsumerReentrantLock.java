package inter.prep.multithreading;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProcessorReEntrant {
	ArrayList<Integer> bucket = new ArrayList<>();
	int maxSize = 5;
	int minSize = 0;
	Lock l = new ReentrantLock(true);
	Condition c = l.newCondition();

	void produce() throws InterruptedException {
		l.lock();
		try {
			Thread.sleep(1000);
			if (bucket.size() < maxSize) {
				System.out.println("produce");
				bucket.add(bucket.size());
				c.await();
			} else {
				System.out.println("bucket full");
			}
		} finally {
			l.unlock();
		}

	}

	void consume() throws InterruptedException {
		l.lock();
		try {
			if (bucket.size() > minSize) {
				System.out.println("consume");
				bucket.remove(bucket.size() - 1);
				c.signal();
			} else {
				System.out.println("bucket Empty!! wait to produce");
			}
		} finally {
			l.unlock();
		}

	}
}

public class ProducerConsumerReentrantLock {

	public static void main(String[] args) throws InterruptedException {
		ProcessorReEntrant p = new ProcessorReEntrant();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						p.produce();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						p.consume();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
