package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림 {

	private static int N;
	private static int M;
	private static int[][] board;
	private static boolean[][] visited;
	private static int cnt;
	private static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		cnt = 0;
		max = 0;
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0,index=0; j < M; j++,index+=2) {
				board[i][j] = s.charAt(index) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void bfs(int r, int c) {
		++cnt; // 그림 개수 증가
		int size = 0;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		++size;
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (board[nr][nc] == 0 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				++size;
				q.offer(new int[] {nr, nc});
			}
			
		}
		
		max = size > max ? size : max;
	}

}
