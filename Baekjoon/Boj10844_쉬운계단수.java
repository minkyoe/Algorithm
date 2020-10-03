package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844_쉬운계단수 {
	private static int N; // 계단 길이
	private static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		dp = new long[N+1][10]; // 9: 계단의 마지막 숫자
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j-1 >= 0) dp[i][j] += dp[i-1][j-1];
				if (j+1 <= 9) dp[i][j] += dp[i-1][j+1];
				dp[i][j] = dp[i][j] % 1000000000L;
			}
		}
		
		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += dp[N][i];
		}
		
		System.out.println(ans % 1000000000L);
	} // end of main
} // end of class
