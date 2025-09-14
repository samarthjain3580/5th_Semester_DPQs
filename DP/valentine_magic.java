package DP;

import java.util.Arrays;

public class Valentine_magic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] boy = {2,11,3};
		int[] girl = {5,7,3,2};
		Arrays.sort(boy);
		Arrays.sort(girl);
		System.out.println(Valentine(boy, girl ,0, 0));
	}
	
	public static int Valentine(int[] boy, int[] girl, int i, int j) {
		if(i == boy.length) return 0;
		if(j == girl.length) return 9999999;

		int sel = Math.abs(boy[i] - girl[j]) + Valentine(boy, girl, i+1, j+1);
		int rej = Valentine(boy, girl, i, j+1);

		return Math.min(sel, rej);
	}

}
