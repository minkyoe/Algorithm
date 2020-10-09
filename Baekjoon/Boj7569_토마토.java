package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	private static int M;
	private static int N;
	private static int H;
	private static int[][][] map;
	private static int notCherised;
	
//	위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향
	static int dy[] = {0, 0, 0, 0, 1, -1};
	static int dx[] = {0, 0, -1, 1, 0, 0};
	static int dz[] = {-1, 1, 0, 0, 0, 0};
	private static int day;
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이
		map = new int[H][N][M];
		notCherised = 0;
		Queue<int[]> q = new LinkedList<>();
		day = 0;
		
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(bf.readLine());
				for (int m = 0; m < M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					if (map[h][n][m] == 0) notCherised++;
					else if (map[h][n][m] == 1) q.offer(new int[] {h, n, m, 0});
				}
			}
		}
		
		if (notCherised == 0) {
			System.out.println("0");
		}
		else {
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				int h = tmp[0];
				int y = tmp[1];
				int x = tmp[2];
				day = tmp[3];
				
				for (int d = 0; d < dy.length; d++) {
					int nh = h + dz[d];
					int ny = y + dy[d];
					int nx = x + dx[d];
					
					if (nh < 0 || nh >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
					if (map[nh][ny][nx] != 0) continue;
					
					map[nh][ny][nx] = 1;
					notCherised--;
					q.offer(new int[] {nh, ny, nx, day+1});
				}
			}
			
			if (notCherised > 0) System.out.println("-1");
			else System.out.println(day);
		}
		
	} // end of main
} // end of class
