package inter.prep.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Caller implements Callable<Integer> {
	Integer id;

	public Caller(Integer id) {
		this.id = id;
	}

	@Override
	public Integer call() throws Exception {
		return id;
	}
}

public class CallableThreadPoolExecutor {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService eS = Executors.newFixedThreadPool(5);
		List<Future<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Future<Integer> submit = eS.submit(new Caller(i));
			ans.add(submit);
		}
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i).get());
		}
	}
}
