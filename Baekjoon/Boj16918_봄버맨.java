package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {

	private static int R;
	private static int C;
	private static int N;
	private static char[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		Queue<int[]> emptySpace = new LinkedList<>(); // 폭탄을 채워야 할 곳
		Queue<int[]> bombSpace = new LinkedList<>(); // 폭탄이 터져야 할 곳
		
		for (int i = 0; i < R; i++) {
			String s = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '.') emptySpace.offer(new int[] {i,j});
				else if (map[i][j] == 'O') bombSpace.offer(new int[] {i,j});
			}
		}
		
		
		int time = 0;
		while(time < N-1) {
			if (time % 2 == 0) { // 폭탄 채워야함 
				while (!emptySpace.isEmpty()) {
					int[] tmp = emptySpace.poll();
					map[tmp[0]][tmp[1]] = 'O';
				}
			}
			else if (time % 2 == 1) { // 폭탄 터트려야 함
				while (!bombSpace.isEmpty()) {
					int[] tmp = bombSpace.poll();
					int tr = tmp[0];
					int tc = tmp[1];
					map[tr][tc] = '.';
					emptySpace.offer(new int[] {tr, tc});
					
					for (int i = 0; i < 4; i++) {
						int nr = tr + dr[i];
						int nc = tc + dc[i];
						if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
						map[nr][nc] = '.';
						emptySpace.offer(new int[] {nr, nc});
					}
				}
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == 'O') bombSpace.offer(new int[] {i,j});
					}
				}
			}
			time++;
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		

	} // end of main

} // end of class
