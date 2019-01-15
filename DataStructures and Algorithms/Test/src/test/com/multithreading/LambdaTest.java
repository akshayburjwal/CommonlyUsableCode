package test.com.multithreading;

//interface A {
//	int data();
//}

public class LambdaTest {
	public static void main(String args[]) {
		RuntimeExample e = new RuntimeExample();
		// System.out.println(e.getA().data());
		int q = 1;
		A a = () -> {
			// System.out.println(q++);
			return q;
		};
	}

}
