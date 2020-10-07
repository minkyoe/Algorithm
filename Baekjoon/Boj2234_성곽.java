package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2234_성곽 {
	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int roomMax;
	
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 열
		M = Integer.parseInt(st.nextToken()); // 행
		
		map = new int[M][N];
		visited = new boolean[M][N];
		roomMax = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int roomCnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				bfs(i,j);
				roomCnt++;
			}
		}
		System.out.println(roomCnt);
		System.out.println(roomMax);
		
		roomMax = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				int valueCopy = map[i][j];
				
				for (int k = 0; k < 4; k++) {
					if ((map[i][j] & (1<<k)) > 0) {
						map[i][j] = (map[i][j] & ~(1<<k));
						bfs(i,j);
						for (int l = 0; l < M; l++) {
							Arrays.fill(visited[l], false);
						}
						map[i][j] = valueCopy;
					}
	 			}
			}
		}
		System.out.println(roomMax);
		
	} // end of main

	private static void bfs(int r, int c) {
		visited[r][c] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c,1}); // 행, 열, 넓이
		int width = 1;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < 4; i++) {
				if ((map[tr][tc] & (1<<i)) > 0) continue;
				
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, width++});
 			}
		}
		roomMax = roomMax < width ? width : roomMax;
		return;
	}
} // end of class
