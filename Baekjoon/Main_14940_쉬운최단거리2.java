import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940_쉬운최단거리2 {

	private static int n;
	private static int m;
	private static int[][] map;
	private static int[][] ans;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		ans = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(ans[i], -1);
		}
		
		int startR = 0; int startC = 0;
		
		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			for (int j = 0, index = 0; j < m; j++, index += 2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 2) {
					startR = i;
					startC = j;
					ans[i][j] = 0;
				} else if (map[i][j] == 0) {
					ans[i][j] = 0;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startR, startC, 1});
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if (ans[nr][nc] != -1) continue;
				
				ans[nr][nc] = cnt;
				q.offer(new int[] {nr, nc, cnt+1});
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	} // end of main

} // end of class
