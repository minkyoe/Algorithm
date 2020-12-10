package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1인 곳을 큐에 담아서 bfs : 24368kb 304ms
 * 그냥 2차원 배열 돌면서 bfs : 21180	kb 284ms
 * 
 */

public class Main_14716_현수막 {

	private static int M;
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		ans = 0;
		map = new int[M][N];
		visited = new boolean[M][N];
//		Queue<int[]> spot = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			String s = bf.readLine();
			for (int j = 0,index = 0; j < N; j++,index+=2) {
				map[i][j] = s.charAt(index) - '0';
//				if (map[i][j] == 1) spot.offer(new int[] {i,j});
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i,j);
				}
			}
		}
		
//		while(!spot.isEmpty()) {
//			int[] tmp = spot.poll();
//			int r = tmp[0];
//			int c = tmp[1];
//			
//			if(visited[r][c]) continue;
//			
//			visited[r][c] = true;
//			bfs(r,c);
//		}
		System.out.println(ans);
	} // end of main
	
	// 상 하 좌 우 우상 좌상 우하 좌하 
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};
	private static void bfs(int r, int c) {
		++ans;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr,nc});
			}
		}
		
	}

} // end of class
