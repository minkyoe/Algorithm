import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {

	private static int N;
	private static int[] stair;
	private static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // 계단 개수
		stair = new int[N];
		dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			stair[i] = Integer.parseInt(bf.readLine());
		}
		
		if (N == 1) System.out.println(stair[0]);
		else if (N == 2) System.out.println(stair[0] + stair[1]);
		else {
			dp[0] = stair[0];
			dp[1] = Math.max(stair[0] + stair[1], stair[1]);
			dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
			
			for (int i = 3; i < N; i++) {
				dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
			}
			
			System.out.println(dp[N-1]);
		}
		
	} // end of main

} // end of class
