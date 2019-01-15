package inter.prep.multithreading;

class MyThread implements Runnable {
	int name = 1;

	public MyThread(int name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(name + "MT" + i);
		}
	}

}

class YourThread extends Thread {
	int name = 0;

	public YourThread(int name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(name + "YT" + i);
		}
	}

}

public class JoinThreadingTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread(5));
		Thread t2 = new YourThread(6);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ended");
	}

}
