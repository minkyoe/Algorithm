package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1189_컴백홈 {

	private static int R;
	private static int C;
	private static int K;
	private static char[][] map;
	private static int ans;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		ans = 0;
		
		for (int i = 0; i < R; i++) {
			String s = bf.readLine();
			map[i] = s.toCharArray();
		}
		
		visited = new boolean[R][C];
		visited[R-1][0] = true;
		dfs(R-1, 0, 1);
		System.out.println(ans);			
		
	} // end of main

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void dfs(int r, int c, int cnt) {
		if (r == 0 && c == C-1 && cnt == K) {
			++ans;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 'T') continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, cnt+1);
			visited[nr][nc] = false;
		}
		
	}

} // end of class
