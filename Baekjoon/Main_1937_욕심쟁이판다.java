import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {

	private static int N;
	private static int[][] map;
	private static int ans;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
		ans = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = 1;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, dfs(i, j));
			}
		}

		System.out.println(ans);
	} // end of main

	private static int dfs(int r, int c) {
		if (dp[r][c] != 1) return dp[r][c];
		
		for (int i = 0; i < dc.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if (map[nr][nc] <= map[r][c]) continue;
			dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
		}
		
		return dp[r][c];
	}



} // end of class
