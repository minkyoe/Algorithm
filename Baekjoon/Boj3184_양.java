package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3184_양 {

	private static int R;
	private static int C;
	private static char[][] map;
	private static int wolfCnt;
	private static int sheepCnt;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		wolfCnt = 0;
		sheepCnt = 0;
		
		for (int i = 0; i < R; i++) {
			String s = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'o') sheepCnt++;
				else if(map[i][j] == 'v') wolfCnt++;
			}
		}

		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[i][j]) continue;
				if (map[i][j] == 'v' || map[i][j] == 'o') {
					visited[i][j] = true;
					bfs(i,j);
				}			
			}
		}
		
		System.out.println(sheepCnt + " " + wolfCnt);
	} // end of main
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	private static void bfs(int r, int c) {
		visited[r][c] = true;
		int wCnt = 0;
		int sCnt = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			if (map[tr][tc] == 'v') ++wCnt;
			else if (map[tr][tc] == 'o')++sCnt;
			
			for (int d = 0; d < 4; d++) {
				int nr = tr + dr[d];
				int nc = tc + dc[d];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (map[nr][nc] == '#') continue;
				if (visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
			
		}
		
		if (wCnt == 0 || sCnt == 0) return;
		if (wCnt < sCnt) {
			wolfCnt -= wCnt;
		}
		else {
			sheepCnt -= sCnt;
		}
		
	}

}
