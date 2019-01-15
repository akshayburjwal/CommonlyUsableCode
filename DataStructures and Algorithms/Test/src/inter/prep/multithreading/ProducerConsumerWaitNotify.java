package inter.prep.multithreading;

class Processor {
	void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("produce");
			wait(10000);
			System.out.println("Re produce");

		}
	}

	void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("Consume");
			notify();
		}
	}

}

public class ProducerConsumerWaitNotify {

	public static void main(String[] args) throws InterruptedException {
		Processor p = new Processor();
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
