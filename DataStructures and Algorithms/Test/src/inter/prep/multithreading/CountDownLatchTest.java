package inter.prep.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CDWorker implements Runnable {
	Integer id;
	java.util.concurrent.CountDownLatch latch;

	public CDWorker(Integer id, CountDownLatch latch) {
		this.id = id;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(id);
			this.latch.countDown();
			Thread.sleep(1000);
			System.out.println("Hello");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService eS = Executors.newFixedThreadPool(2);
		CountDownLatch cdL = new CountDownLatch(5);
		for (int i = 0; i < 5; i++) {
			eS.submit(new CDWorker(i, cdL));
		}
		System.out.println("bef await");
		cdL.await();
		System.out.println("After await");
		eS.shutdown();
	}
}
