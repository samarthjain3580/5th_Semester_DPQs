package DP;
import java.util.*;
public class uncrossed_lines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] s1 = {1,4,2};
		int[] s2 = {1,2,4};
		System.out.println(lcsBU(s1, s2));
		sc.close();

	}
	
	public static int lcsBU(int[] s1, int[] s2) {
		int[][] dp = new int[s1.length+1][s2.length+1];
		
		for(int i=1;i<dp.length; i++) {
			for (int j=1; j<dp[0].length; j++) {
				int ans =0; 
				if (s1[i-1] == s2[j-1]) {
					ans = 1+dp[i-1][j-1];
				}
				else {
					int f =dp[i-1][j];
					int s = dp[i][j-1];
					ans= Math.max(f, s);
				}
				dp[i][j] = ans;
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
