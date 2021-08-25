import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(bf.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int[][] dp = new int[2][N+1];
			int[][] origin = new int[2][N+1];
			
			for (int r = 0; r < 2; r++) {
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
				for (int c = 1; c <= N; c++) {
					origin[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0] = dp[1][0] = 0;
			dp[0][1] = origin[0][1];
			dp[1][1] = origin[1][1];
			
			for (int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + origin[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + origin[1][i];
			}
			
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		} // end of testCase

	} // end of main

} // end of class
