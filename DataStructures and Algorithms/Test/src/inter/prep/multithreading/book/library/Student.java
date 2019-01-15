package inter.prep.multithreading.book.library;

import java.util.Random;

public class Student implements Runnable {
	Integer id;
	Book[] books;
	Random random;
	Integer readCount = 0;

	private volatile boolean isDone;

	public Student(Integer id, Book[] books) {
		super();
		this.id = id;
		this.books = books;
		this.random = new Random();
	}

	@Override
	public void run() {
		while (!isDone()) {
			try {
				if (books.getBook(this)) {
					reading();
					Thread.sleep(random.nextInt(1000));
					books.putDown(this);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void reading() throws InterruptedException {
		System.out.println(this + "Reading");
		Thread.sleep(1000);

		readCount++;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
