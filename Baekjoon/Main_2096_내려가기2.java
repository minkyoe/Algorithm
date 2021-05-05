import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2096_내려가기2 {

	private static int N;
	private static int[][] arr;
	private static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N+1][3];
		dp = new int[N+1][3];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < 3; j++, index += 2) {
				arr[i][j] = s.charAt(index) - '0';
			}
		}
		if (N == 1) {
			sb.append(Math.max(Math.max(arr[1][0], arr[1][1]), arr[1][2]) + " ");
			sb.append(Math.min(Math.min(arr[1][0], arr[1][1]), arr[1][2]));
		} 
		else {
			dp[0][0] = 0;
			dp[0][1] = 0;
			dp[0][2] = 0;
			
			for (int i = 1; i <= N; i++) { // 행 
				dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i][0];
				dp[i][1] = Math.max(dp[i][0]-arr[i][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + arr[i][2];
			}
			sb.append(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]));
			sb.append(" ");
			
			dp[0][0] = 0;
			dp[0][1] = 0;
			dp[0][2] = 0;
			
			for (int i = 1; i <= N; i++) { // 행 
				dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][0];
				dp[i][1] = Math.min(dp[i][0]-arr[i][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][2];
			}
			
			sb.append(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
		}
		System.out.println(sb);
	} // end of main

} // end of class
