import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년 {

	private static int N;
	private static int[] arr;
	private static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		dp = new long[21][N]; // 연산결과 : 0 ~ 20
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(go(arr[0], 0));
	} // end of main

	private static long go(int n, int idx) {
		if (n < 0 || n > 20) return 0;
		if (dp[n][idx] > 0) return dp[n][idx];
		if (idx == N-2) {
			if (n == arr[N-1]) {
				return 1;
			}
			return 0;
		}
		
		dp[n][idx] += go(n + arr[idx+1], idx+1);
		dp[n][idx] += go(n - arr[idx+1], idx+1);
		return dp[n][idx];
	}

} // end of class
