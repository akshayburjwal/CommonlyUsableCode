package test.com.dynamic.programming;

// Longest common subsequence
public class LIS {

	public static void main(String[] args) {
		String s = "15248739";
		Integer subLength[] = new Integer[s.length()];
		Integer subString[] = new Integer[s.length()];

		LIS d = new LIS();
		for (int i = 0; i < s.length(); i++) {
			subLength[i] = 1;
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (Integer.parseInt(String.valueOf(s.charAt(i))) > Integer.parseInt(String.valueOf(s.charAt(j)))
						&& subLength[i] < subLength[j] + 1) {

				}
			}
		}
		Integer lcsCount = d.getLCSCount(s, s.length());
		System.out.println(lcsCount);
	}

	public Integer getLCSCount(String s, int lastS) {
		return lastS;
	}

}
