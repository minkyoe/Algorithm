import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {

	private static int M, N;
	private static int[][] map, dp;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 세로 
		N = Integer.parseInt(st.nextToken()); // 가로
		map = new int[M][N];
		dp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	} // end of main

	private static int dfs(int r, int c) {
		if (r == M-1 && c == N-1) {
			return 1;
		}
		
		if (dp[r][c] > -1) return dp[r][c];
		dp[r][c] = 0;
		
		for (int i = 0; i < dc.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc] >= map[r][c]) continue;
			dp[r][c] += dfs(nr, nc);
		}
		
		return dp[r][c];
	}

} // end of class
