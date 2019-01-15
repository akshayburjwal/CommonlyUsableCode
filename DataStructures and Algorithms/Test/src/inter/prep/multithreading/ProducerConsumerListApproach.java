package inter.prep.multithreading;

import java.util.ArrayList;

class Processor2 {
	ArrayList<Integer> bucket = new ArrayList<>();
	int maxSize = 5;
	int minSize = 0;

	void produce() throws InterruptedException {
		synchronized (this) {
			while (true) {
				if (bucket.size() < maxSize) {
					System.out.println("produce");
					bucket.add(bucket.size());
					notify();
				} else {
					System.out.println("bucket full");
					wait(10000);
				}
				Thread.sleep(100);
			}
		}
	}

	void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			if (bucket.size() > minSize) {
				System.out.println("consume");
				bucket.remove(bucket.size() - 1);
				notify();
			} else {
				System.out.println("bucket Empty!! wait to produce");
				wait(10000);
			}
		}
	}

}

public class ProducerConsumerListApproach {

	public static void main(String[] args) throws InterruptedException {
		Processor2 p = new Processor2();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true)
						p.produce();
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
					while (true)
						p.consume();
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
