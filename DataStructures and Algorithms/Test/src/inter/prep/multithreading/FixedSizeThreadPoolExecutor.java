package inter.prep.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Printer extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				sleep(1000);
				// System.out.println("Hello");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class FixedSizeThreadPoolExecutor {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService eS = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			eS.submit(new Printer());
		}
	}
}
