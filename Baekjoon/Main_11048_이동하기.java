import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11048_이동하기 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int max = getMax(dp[i-1][j], getMax(dp[i][j-1], dp[i-1][j-1]));
				
				dp[i][j] = max + map[i][j];
			}
		}
		
		System.out.println(dp[N][M]);

	} // end of main

	private static int getMax(int a, int b) {
		if (a < b) return b;
		return a;
	}

} // end of class
