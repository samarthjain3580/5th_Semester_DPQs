package DP;
import java.util.*;	
public class longest_increasing_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(LIS(arr));
		sc.close();
	}
	
	public static int LIS(int[] arr) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < dp.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					int x = dp[j];
					dp[i] = Math.max(dp[i], x + 1);
				}

			}
		}
		return Arrays.stream(dp).max().getAsInt();

	}

}
