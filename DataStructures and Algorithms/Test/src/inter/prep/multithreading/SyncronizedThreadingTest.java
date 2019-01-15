package inter.prep.multithreading;

public class SyncronizedThreadingTest {

	static int data1 = 1;
	static int data2 = 1;
	static Object lock1 = new Object();
	static Object lock2 = new Object();

	public static void incrementData1() {
		synchronized (lock1) {
			data1++;
		}
	}

	public static void incrementData2() {
		synchronized (lock2) {
			data2++;
		}
	}

	public static void compute() {
		for (int i = 0; i < 10; i++) {
			incrementData1();
			incrementData2();

		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				compute();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				compute();
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("data1-" + data1);
		System.out.println("data2-" + data2);
		System.out.println("Ended");
	}

}
