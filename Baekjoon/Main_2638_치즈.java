import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static int cheese;
	private static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cheese = 0;
		time = 0;
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 1) cheese++;
			}
		}

		
		while (cheese > 0) {
			// 외부 공기 구분해주기 (모눈종이의 맨 가장자리에는 치즈가 놓이지 않음)
			bfs(0, 0);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 치즈가 있는 곳이라면
					if (map[i][j] == 1) {
						int cnt = 0; // 외부 공기와 맞닿은 곳
						
						for (int k = 0; k < dr.length; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							
							if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
							if (map[nr][nc] == 2) cnt++;
						}
						
						if (cnt >= 2) {
							cheese--;
							map[i][j] = 0;
						}
					}
				}
			}
			time++;
		}
		
		System.out.println(time);
		
	} // end of main

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static void bfs(int i, int j) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		map[i][j] = 2; // 외부 공기
		visited[i][j] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int k = 0; k < dr.length; k++) {
				int nr = tr + dr[k];
				int nc = tc + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 1) continue;
				map[nr][nc] = 2;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
			
		}
		
	}

} // end of class
