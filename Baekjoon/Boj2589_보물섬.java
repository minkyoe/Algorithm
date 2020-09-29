package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	private static int N;
	private static int M;
	private static char[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static boolean[][] visited;
	private static int maxCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		map = new char[N][M]; // 보물 지도
		visited = new boolean[N][M];
		maxCnt = 0;

		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
					
					// visited 초기화
					for (int k = 0; k < N; k++) {
						Arrays.fill(visited[k], false);
					}
				}
			}
		}
		
		System.out.println(maxCnt);
		
	} // end of main

	private static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {y,x,0});
		visited[y][x] = true;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int ty = tmp[0];
			int tx = tmp[1];
			cnt = tmp[2];
			
			for (int i = 0; i < 4; i++) {
				int ny = ty + dy[i];
				int nx = tx + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] == 'W') continue;
				
				visited[ny][nx] = true;
				q.offer(new int[] {ny, nx, cnt+1});
			}
		}
		
		maxCnt = maxCnt < cnt ? cnt : maxCnt;
	}
} // end of class
