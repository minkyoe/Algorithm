package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16194_카드구매하기2 {
	private static int N;
	private static int[] P;
	private static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // 카드 개수
		P = new int[N+1]; // 카드가 i개 포함된 카드팩의 가격
		dp = new int[N+1]; // 카드N개를 구매하기 위해 내야할 금액 최소값
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j]+P[j]);
			}
		}
		
		System.out.println(dp[N]);
	}// end of main
}
