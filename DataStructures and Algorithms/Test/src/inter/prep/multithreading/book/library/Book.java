package inter.prep.multithreading.book.library;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
	Integer id;
	Lock lock;

	public Book(Integer id) {
		super();
		this.id = id;
		this.lock = new ReentrantLock();
	}

	boolean getBook(Student p) {
		try {
			if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
				System.out.println(p + " picked book" + this);
				return true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	void putDown(Student p) {
		System.out.println(p + " putdown" + this);
		lock.unlock();

	}

	@Override
	public String toString() {
		return " Book [id=" + id + "]";
	}

}
