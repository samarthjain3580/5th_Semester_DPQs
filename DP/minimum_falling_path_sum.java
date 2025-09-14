package DP;
import java.util.*;
public class minimum_falling_path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = Integer.MAX_VALUE;
		int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
		int[][] dp = new int[matrix.length][matrix[0].length];
		for(int[] d: dp) {
			Arrays.fill(d, -66666);
		}
		for(int c=0;c<matrix[0].length;c++) {
			ans = Math.min(ans, mimimun_falling_path(matrix, 0, c, dp));
		}
		System.out.println(ans);
	}
	
	public static int mimimun_falling_path(int[][] matrix, int cr, int cc, int[][] dp) {
		if (cr == matrix.length-1) {
			return matrix[cr][cc];
		}
		if (cc < 0 || cc >= matrix[0].length) {
			return Integer.MAX_VALUE;
		}
		if(dp[cr][cc] != -1) {
			return dp[cr][cc];
		} 
		int d = mimimun_falling_path(matrix, cr+1, cc, dp);
		int ld = mimimun_falling_path(matrix, cr+1, cc-1, dp);
		int rd = mimimun_falling_path(matrix, cr+1, cc+1, dp);
		return dp[cr][cc] = Math.min(rd, Math.min(ld, d)) + matrix[cr][cc];
	}

}
