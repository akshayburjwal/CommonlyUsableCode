
package test.com.multithreading;

public class JavaTest {
	Object o1 = new Object();
	Object o2 = new Object();

	public void m1() {

		try {
			synchronized (JavaTest.class) {
				System.out.println("m1 " + Thread.currentThread());
				try {
					JavaTest.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("m1 " + Thread.currentThread());

			}
		} finally {
		}

	}
	// System.out.println(Thread.currentThread());

	public synchronized void m2() {
		try {
			// synchronized(o2) {
			System.out.println("m2 " + Thread.currentThread());
			Thread.sleep(2000);
			// }
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}