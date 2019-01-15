package inter.prep.multithreading.dining.phlosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		try {
			ExecutorService ec = null;
			Chopstick[] chopsticks = new Chopstick[Constant.COUNT_CHOP];
			Philosopher[] philLaegue = new Philosopher[Constant.COUNT_PHIL];
			for (int i = 0; i < Constant.COUNT_CHOP; i++) {
				chopsticks[i] = new Chopstick(i);
			}
			for (int i = 0; i < Constant.COUNT_PHIL; i++) {
				philLaegue[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % Constant.COUNT_CHOP]);
			}
			ec = Executors.newFixedThreadPool(Constant.COUNT_PHIL);
			for (int i = 0; i < Constant.COUNT_PHIL; i++) {
				ec.execute(philLaegue[i]);
			}
			Thread.sleep(10000);
			for (int i = 0; i < Constant.COUNT_PHIL; i++) {
				philLaegue[i].setIsFull(true);
			}
			ec.shutdown();
			while (!ec.isTerminated())
				Thread.sleep(1000);
			for (int i = 0; i < Constant.COUNT_PHIL; i++) {
				System.out.println(philLaegue[i] + "eated " + philLaegue[i].eatcount);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
