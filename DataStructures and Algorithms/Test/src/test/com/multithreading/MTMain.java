package test.com.multithreading;

import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

public class MTMain {

	public static void main(String[] args) {
		System.out.println("hhh");
		TreeSet<Mythread> a = new TreeSet<>();
		Mythread e = new Mythread();
		Mythread e2 = new Mythread();
		// System.out.println(e);
		// System.out.println(e2);
		//
		// a.add(e);
		// a.add(e2);
		// a.forEach(at -> {
		// System.out.println(at);
		// });
		Mythread ob = new Mythread();
		// Thread t = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// System.out.println("pro method called");
		// try {
		// ob.pro();
		// } catch (RuntimeExample e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }
		// });
		// Thread t1 = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// System.out.println("con method called");
		// ob.con();
		//
		// }
		// });
		// t.start();
		// t1.start();

		System.out.println("end");

	}

}

class Mythread implements Comparable<Mythread> {
	// int a = 1;
	LinkedBlockingQueue b = new LinkedBlockingQueue(2);
	//
	// public void pro() throws RuntimeExample {
	// throw new RuntimeExample();
	// //
	// // synchronized (this) {
	// // System.out.println("pro called");
	// // // while (b.size() == 2) {
	// // // try {
	// // System.out.println("pro going to wait");
	// // try {
	// // wait();
	// // System.out.println("pro going to wait");
	// // } catch (InterruptedException e) {
	// // // TODO Auto-generated catch block
	// // e.printStackTrace();
	// // }
	// // // } catch (InterruptedException e) {
	// // // TODO Auto-generated catch block
	// // // e.printStackTrace();
	// // // }
	// }
	//
	// // try
	// //
	// // {
	// // b.put(1);
	// // } catch (InterruptedException e) {
	// // // TODO Auto-generated catch block
	// // e.printStackTrace();
	// // }
	// // System.out.println(b);
	// // this.notify();
	// // }
	//
	// // }
	//
	// public void con() {
	// synchronized (this) {
	// System.out.println("con called");
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// while (b.isEmpty()) {
	// try {
	// System.out.println("con going to wait");
	// this.wait();
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// Object remove = b.remove();
	// System.out.println("Removed " + remove.toString());
	//
	// this.notify();
	// }
	// }

	@Override
	public int compareTo(Mythread o) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int ran = r.nextInt() % 3;
		return ran - 1;
	}
}