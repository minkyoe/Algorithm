package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19952_인성문제있어 {
	static int H, W, O, F, X1, Y1, X2, Y2;
	private static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken()); // 장애물 개수
			F = Integer.parseInt(st.nextToken()); // 초기 힘
			X1 = Integer.parseInt(st.nextToken()); // 행 
			Y1 = Integer.parseInt(st.nextToken()); // 열 
			X2 = Integer.parseInt(st.nextToken());
			Y2 = Integer.parseInt(st.nextToken());
			
			map = new int[H+1][W+1];
			visited = new boolean[H+1][W+1];
			
			for (int i = 0; i < O; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int h = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[h][w] = c;
			}
			
			boolean tmp = bfs(X1, Y1, F);
			if (tmp) {
				System.out.println("잘했어!!");
			} else {
				System.out.println("인성 문제있어??");
			}
			
		}
		
		
	} // end of main

	private static boolean bfs(int x, int y, int p) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, p});
		visited[x][y] = true;
		boolean flag = false;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tx = tmp[0];
			int ty = tmp[1];
			int tp = tmp[2];
			
			if (tp == 0) {
				break;
			}
			if (tx == X2 && ty == Y2) {
				flag = true;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				
				if (nx <= 0 || nx > H || ny <= 0 || ny > W) continue;
				if (visited[nx][ny]) continue;
				if (map[nx][ny]-map[tx][ty] > tp) continue;
				
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny, tp-1});
			}
		
		}
		return flag;
	}
}