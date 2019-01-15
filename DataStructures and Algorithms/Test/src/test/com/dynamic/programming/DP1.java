package test.com.dynamic.programming;

// Longest common subsequence
public class DP1 {

	public static void main(String[] args) {
		String s = "ABCBDAB";
		String s2 = "BDCABA";
		DP1 d = new DP1();
		Integer lcsCount = d.getLCSCount(s, s2, s.length(), s2.length());
		System.out.println(lcsCount);
	}

	public Integer getLCSCount(String s, String s1, int lastS, int lastS1) {
		if (lastS == 0 || lastS1 == 0) {
			return 0;
		} else if (s.charAt(lastS - 1) == s1.charAt(lastS1 - 1)) {
			return 1 + getLCSCount(s, s1, lastS - 1, lastS1 - 1);
		} else {
			return Math.max(getLCSCount(s, s1, lastS - 1, lastS1), getLCSCount(s, s1, lastS, lastS1 - 1));
		}
	}
}
