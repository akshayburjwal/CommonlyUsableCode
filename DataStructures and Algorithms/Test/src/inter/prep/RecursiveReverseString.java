package inter.prep;

public class RecursiveReverseString {
	public static void main(String[] args) {
		String s = "Helo you to the World";
		String recRev = recRev(0, s);
		System.out.println(recRev);
	}

	static String recRev(int end, String s) {
		String rev = "";
		end = s.indexOf(" ");
		if (end != -1) {
			rev = recRev(end + 1, s.substring(end + 1));
			rev = rev + " " + s.substring(0, end);

		} else {
			rev = s;
		}
		return rev;
	}
}
