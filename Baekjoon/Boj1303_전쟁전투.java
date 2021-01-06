package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303_전쟁전투 {

	private static boolean[][] visited;
	private static int N;
	private static int M;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 가로 
		M = Integer.parseInt(st.nextToken()); // 세로 
		
		map = new char[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			String s = bf.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		int wSum = 0;
		int bSum = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					int cnt = bfs(i, j, map[i][j]);
					if (map[i][j] == 'B') bSum += cnt * cnt;
					else if (map[i][j] == 'W') wSum += cnt * cnt;
				}
			}
		}
		System.out.println(wSum + " " + bSum);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static int bfs(int r, int c, char v) {
		visited[r][c] = true;
		Queue<int[]> q = new LinkedList<>();
		int cnt = 1;
		q.offer(new int[] {r, c});
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				
				if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc]) continue;
				if (map[nr][nc] != v) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, cnt++});
			}
		}
		return cnt;
	}

}
