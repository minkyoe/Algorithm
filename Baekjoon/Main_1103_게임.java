import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1103_게임 {

	private static int N, M, ans;
	private static char[][] map;
	private static int[][] dp;
	private static boolean[][][] visited;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dp = new int[N][M];
		visited = new boolean[4][N][M];
		ans = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		visited[0][0][0] = true;
		if (dfs(0, 0, 1, map[0][0] - '0') == -1) ans = -1;

		System.out.println(ans);
	} // end of main

	private static int dfs(int r, int c, int cnt, int move) {
		if (cnt <= dp[r][c]) return dp[r][c];
		
		for (int i = 0; i < dc.length; i++) {
			int nr = r + dr[i] * move;
			int nc = c + dc[i] * move;
			
			// 범위 벗어나거나 구멍에 빠질때 정답 갱신시켜줌
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) { // 범위 벗어남
				ans = Math.max(ans, cnt);
				continue;
			}
			if (map[nr][nc] == 'H') { // 구멍에 빠짐
				ans = Math.max(ans, cnt);
				continue;
			}
			if (visited[i][nr][nc]) { // 사이클
				return -1;
			}
			
			visited[i][nr][nc] = true;
			int tmp = dfs(nr, nc, cnt+1, map[nr][nc] - '0');
			if (tmp == -1) return -1;
			visited[i][nr][nc] = false;
		}
		
		return dp[r][c] = cnt;
	}

} // end of class
