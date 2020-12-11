package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17086_아기상어2 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] startVisited;
	private static boolean[][] visited;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		startVisited = new boolean[N][M];
		ans = 0;

		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < M; j++, index+=2) {
				map[i][j] = s.charAt(index) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !startVisited[i][j]) {
					startVisited[i][j] = true;
					visited = new boolean[N][M];
					bfs(i,j);
				}
			}
		}
		
		System.out.println(ans);
		
	} // end of main
	
	// 상 부터 시계방향 
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c,0});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			if (map[tr][tc] == 1 && !(tr == r && tc == c)) {
				ans = ans < cnt ? cnt : ans;
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, cnt+1});
			}
		}
		
		
	}

} // end of class
