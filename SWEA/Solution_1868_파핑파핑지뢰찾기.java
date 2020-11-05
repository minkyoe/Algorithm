package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1868_파핑파핑지뢰찾기 {
	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	// 좌상 상 우상 우 우하 하 좌하 좌
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= tc; testCase++) {
        	N = Integer.parseInt(bf.readLine());
        	
        	map = new char[N][N];
        	visited = new boolean[N][N];
        	
        	for (int i = 0; i < N; i++) {
        		String s = bf.readLine();
        		for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
        	
        	int ans = 0;
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			if (map[i][j] == '.' && !visited[i][j]) {
        				int bomb = 0;
        				for (int k = 0; k < 8; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							
							if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
							if (map[nr][nc] == '*') bomb++;
						}
        				
        				// 1. 8방에 지뢰 없는 곳 먼저 클릭
        				if (bomb == 0) {
        					++ans;
        					visited[i][j] = true;
        					map[i][j] = (char)(0+'0');
        					for (int k = 0; k < 8; k++) {
        						int nr = i + dr[k];
        						int nc = j + dc[k];
        						if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
        						go(nr, nc);
        					}
        				}
        			}
        		}
        	}
        	
        	// 2. 나머지 클
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			if (map[i][j] == '.' && !visited[i][j]) {
        				visited[i][j] = true;
        				++ans;
        			}
        		}
        	}
        	
        	StringBuilder sb = new StringBuilder();
        	sb.append("#").append(testCase).append(" ").append(ans);
        	System.out.println(sb.toString());
        } // end of tc
	} // end of main

	private static void go(int r, int c) {
		int bomb = 0;
		for (int k = 0; k < 8; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			if (map[nr][nc] == '*') bomb++;
		}
		
		if (bomb == 0) {
			visited[r][c] = true;
			map[r][c] = (char)(0+'0');
			for (int k = 0; k < 8; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				go(nr, nc);
			}
			
		} else {
			visited[r][c] = true;
			map[r][c] = (char)(bomb+'0');
		}
		
		return;
	}

}
