package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_2xn타일링 {
	private static int n;
	private static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine()); // 2*n 타일링
		dp = new int[n+1];
		   
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2]; 
			dp[i] = dp[i] % 10007;
		}
		
		System.out.println(dp[n]);
		
	} // end of main
} // end of class
