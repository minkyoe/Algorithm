import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {

	private static int N;
	private static int M;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String s = bf.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j-1) - '0';
			}
		}
		
		System.out.println(bfs(1, 1));
	} // end of main

	private static int bfs(int r, int c) {
		int cnt = 0;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][M+1];
		visited[r][c] = true;
		q.offer(new int[] {r, c, 1});
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int tCnt = tmp[2];
			
			if (tr == N && tc == M) {
				cnt = tCnt;
				break;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 1 || nr > N || nc < 1 || nc > M) continue;
				if (map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, tCnt + 1});
			}
			
		}
		return cnt;
	}

} // end of class
