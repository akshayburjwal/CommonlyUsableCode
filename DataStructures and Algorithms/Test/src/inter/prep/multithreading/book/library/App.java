package inter.prep.multithreading.book.library;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		try {
			ExecutorService ec = null;
			Book[] books = new Book[Constant.COUNT_CHOP];
			Student[] students = new Student[Constant.COUNT_PHIL];
			for (int i = 0; i < Constant.COUNT_CHOP; i++) {
				books[i] = new Book(i);
			}
			for (int i = 0; i < Constant.COUNT_PHIL; i++) {
				students[i] = new Student(i);
			}
			ec = Executors.newFixedThreadPool(Constant.COUNT_PHIL);
			for (int i = 0; i < Constant.COUNT_PHIL; i++) {
				ec.execute(students[i]);
			}
			Thread.sleep(10000);
			for (int i = 0; i < Constant.COUNT_PHIL; i++) {
				students[i].setIsFull(true);
			}
			ec.shutdown();
			while (!ec.isTerminated())
				Thread.sleep(1000);
			for (int i = 0; i < Constant.COUNT_PHIL; i++) {
				System.out.println(students[i] + "eated " + students[i].eatcount);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
