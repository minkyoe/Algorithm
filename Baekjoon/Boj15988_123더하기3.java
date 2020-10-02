package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15988_123더하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= tc; i++) {
			int n = Integer.parseInt(bf.readLine());
			long[] dp = new long[1000001];
			dp[0] = 1; // 1,2,3중 아무것도 안쓰는 경우 (공집합 -> 크기는 0이지만 실제로 존재하는 집합)
			dp[1] = 1;
			dp[2] = 2;
			
			for (int j = 3; j <= n; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
				dp[j] = dp[j] % 1000000009L;
			}
			
			System.out.println(dp[n]);
		} // end of tc
		
		
	} // end of main
} // end of class
