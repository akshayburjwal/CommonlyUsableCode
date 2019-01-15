package inter.prep.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
	INSTANCE;
	Semaphore slock = new Semaphore(3);

	void download() throws InterruptedException {
		slock.acquire();
		try {
			System.out.println("Downloading");
			Thread.sleep(10000);
		} finally {
			slock.release();
		}
	}
}

public class DownloaderProblemWithSemaphore {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService eS = Executors.newCachedThreadPool();

		for (int i = 0; i < 100000; i++) {
			eS.submit(new Runnable() {

				@Override
				public void run() {
					try {
						Downloader.INSTANCE.download();
					} catch (InterruptedException e) {
					}
				}
			});
		}
	}
}
