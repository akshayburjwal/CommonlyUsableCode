package test.com.multithreading;

interface A {
	int data();
}

public class RuntimeExample {

	public void met() {
		int a1 = 3;
		A a = () -> {
			int a2 = 0;
			System.out.println("Value of i is " + (a2++));
			return a1;
		};
	}

}
