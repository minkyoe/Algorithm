import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11123_양한마리양두마리 {

	private static int H, W;
	private static char[][] map;
	private static boolean[][] visited;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			visited = new boolean[H][W];
			ans = 0;
			
			for (int i = 0; i < H; i++) {
				String s = bf.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '#' && !visited[i][j]) {
						bfs(i, j);
						++ans;
					}
				}
			}
			
			System.out.println(ans);
		} // end of tc


	} // end of main

	private static void bfs(int r, int c) {
		visited[r][c] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
				if (map[nr][nc] == '.' || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
	}

} // end of class
