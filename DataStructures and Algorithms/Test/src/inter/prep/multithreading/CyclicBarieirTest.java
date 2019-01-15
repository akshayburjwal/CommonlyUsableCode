package inter.prep.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CBWorker implements Runnable {
	Integer id;
	CyclicBarrier bc;

	public CBWorker(Integer id, CyclicBarrier bc) {
		this.id = id;
		this.bc = bc;
	}

	@Override
	public void run() {
		try {
			System.out.println("strt Executing");
			Thread.sleep(1000);
			System.out.println("ending Executing");
			this.bc.await();
			System.out.println("after Await");
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

public class CyclicBarieirTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService eS = Executors.newFixedThreadPool(1);
		CyclicBarrier cB = new CyclicBarrier(5, new Runnable() {

			@Override
			public void run() {
				System.out.println("all Finished");

			}
		});
		for (int i = 0; i < 5; i++) {
			eS.submit(new CBWorker(i, cB));
		}
		eS.shutdown();
	}
}
