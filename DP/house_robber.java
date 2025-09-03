package DP;
import java.util.*;
public class house_robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,7,9,3,1};
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		System.out.println(RobberBU(arr));
	}
	
	public static int RobberBU(int[] arr) {
		if(arr.length==1) return arr[0];
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for(int i=2;i<arr.length;i++) {
			int rob = arr[i]+dp[i-2];
			int dont_rob = dp[i-1];
			dp[i] = Math.max(rob, dont_rob);
		}
		return dp[dp.length-1];
	}
	
	
}
