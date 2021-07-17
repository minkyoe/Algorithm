import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11060_점프점프 {

	private static int N;
	private static int[] jump;
	private static int[] dp;
	private static final int MAX = 1001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		jump = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			jump[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1];
		Arrays.fill(dp, -1);
		
		int ans = go(1);
		
		if (ans == MAX) ans = -1;
		System.out.println(ans);
	} //end of main

	private static int go(int idx) {
		if (idx == N) {
			return 0;
		}
		if (idx > N) {
			return MAX;
		}
		if (dp[idx] != -1) {
			return dp[idx];
		}
		
		dp[idx] = MAX;
		
		for (int i = 1; i <= jump[idx]; i++) {
			dp[idx] = Math.min(dp[idx], 1 + go(idx + i));
		}

		return dp[idx];
	}

} // end of class
