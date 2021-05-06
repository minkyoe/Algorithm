import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {

	private static int R, C, DR, DC, SR, SC;
	private static char[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	// D 비버 굴  S 고슴도치 
	// * 물 	    X 돌
	private static int ans;
	private static int[][] water;
	private static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		DR = 0; DC = 0; // 비버 굴 위치
		SR = 0; SC = 0; // 고슴도치 처음 위치
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[R][C];
		water = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'D') {
					DR = i; DC = j;
					water[i][j] = -1;
				}
				else if (map[i][j] == 'S') {
					SR = i; SC = j;
				}
				else if (map[i][j] == '*') {
					visited[i][j] = true;
					q.offer(new int[] {i, j, 0});
				}
				else if (map[i][j] == 'X') {
					water[i][j] = -1;
				}
			}
		}
		
		// 물 차는 시간 기록
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			water[tr][tc] = cnt;
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i]; 
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 'X' || map[nr][nc] == 'D') continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, cnt+1});
			}
		}
		
		// visited 초기화
		for (int i = 0; i < R; i++) {
			Arrays.fill(visited[i], false);
		}
		q.offer(new int[] {SR, SC, 0});
		visited[SR][SC] = true;
		ans = Integer.MAX_VALUE;
		
		// 고슴도치 이동
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			if (tr == DR && tc == DC) {
				ans = cnt;
				break;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i]; 
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (visited[nr][nc] || map[nr][nc] == 'X' || map[nr][nc] == '*') continue;
				if (water[nr][nc] != 0 && water[nr][nc] != -1 && (cnt+1) >= water[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, cnt+1});
			}
		}
		
		if (ans == Integer.MAX_VALUE) System.out.println("KAKTUS");
		else System.out.println(ans);

	} // end of main

} // end of class
