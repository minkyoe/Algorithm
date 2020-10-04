package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	private static int N; // 집 개수
	private static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		dp = new int[N+1][4];
		
		StringTokenizer st; 
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 3; j++) {
				if (j == 1) {
					dp[i][j] += Math.min(dp[i-1][2], dp[i-1][3]);
				}
				else if (j == 2) {
					dp[i][j] += Math.min(dp[i-1][1], dp[i-1][3]);
				}
				else if (j == 3) {
					dp[i][j] += Math.min(dp[i-1][1], dp[i-1][2]);
				}
				
			}
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= 3; i++) {
			result = result > dp[N][i] ? dp[N][i] : result;
		}
		
		System.out.println(result);
		
		
	} // end of main
} // end of class
