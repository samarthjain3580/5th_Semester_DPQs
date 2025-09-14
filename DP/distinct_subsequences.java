package DP;
import java.util.*;
public class distinct_subsequences {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rabbbit", t = "rabbit";
		System.out.println(distinct_sub(s, t, 0, 0));
	}

// s--> coin | t--> amount | i--> s | j-->t
	public static int distinct_sub(String s, String t, int i, int j) {
		if (j == t.length()) {
			return 1;
		}
		if (i == s.length()) {
			return 0;
		}
		int inc = 0, exc = 0;
		if (s.charAt(i) == t.charAt(j)) {
			inc = distinct_sub(s, t, i + 1, j + 1);
		}
		exc = distinct_sub(s, t, i + 1, j);
		return inc + exc;
	}

}
