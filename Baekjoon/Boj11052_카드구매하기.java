package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052_카드구매하기 {
	private static int N; // 카드 개수
	private static int[] p;
	private static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		p = new int[N+1]; // 카드 팩 가격
		dp = new int[N+1]; // 카드N개를 구매하기 위해 내야할 금액 최대값 
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		dp[1] = p[1];
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
			}
		}
		
		System.out.println(dp[N]);
		
	} // end of main
} // end of class
