import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {

	private static int W;
	private static int H;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) break;
			
			map = new char[H][W];
			visited = new boolean[H][W];
			
			for (int i = 0; i < H; i++) {
				String s = bf.readLine();
				for (int j = 0, index = 0; j < W; j++, index += 2) {
					map[i][j] = s.charAt(index);
				}
			}
			
			int islandCnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visited[i][j] && map[i][j] == '1') {
						++islandCnt;
						bfs(i, j);
					}
				}
			}
			
			sb.append(islandCnt).append("\n");
		} // end of while
		System.out.println(sb);
	} // end of main

	private static void bfs(int r, int c) {
		visited[r][c] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == '0' || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		
	}

} // end of class
