package inter.prep.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
	BlockingQueue<Integer> blockingQueue;
	Integer counter = 0;

	Consumer(BlockingQueue<Integer> bQ) {
		this.blockingQueue = bQ;
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.blockingQueue.put(counter);
				counter++;
				System.out.println("PUT" + counter);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Producer implements Runnable {
	BlockingQueue<Integer> blockingQueue;

	Producer(BlockingQueue<Integer> bQ) {
		this.blockingQueue = bQ;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Integer take = this.blockingQueue.take();
				System.out.println("GET" + take);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> bQ = new ArrayBlockingQueue<Integer>(10);
		Thread t1 = new Thread(new Producer(bQ));
		Thread t2 = new Thread(new Consumer(bQ));
		t1.start();
		t2.start();
	}

}
