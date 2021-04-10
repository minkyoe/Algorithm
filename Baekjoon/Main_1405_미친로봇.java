import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1405_미친로봇 {

	private static int N;
	private static double ans;
	private static int[] percent;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		percent = new int[4];
		visited = new boolean[29][29];
		ans = 0;
		
		for (int i = 0; i < percent.length; i++) {
			percent[i] = Integer.parseInt(st.nextToken());
		}
		
		visited[14][14] = true;
		dfs(14, 14, 1.0 , 0);
		System.out.println(ans);
	} // end of main

	// 동 서 남 북
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	private static void dfs(int r, int c, double p, int cnt) {
		if (cnt == N) {
			ans += p;
			return;
		}
		
		for (int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= 29 || nc < 0 || nc >= 29 || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, p * percent[i] * 0.01, cnt+1);
			visited[nr][nc] = false;
		}
		
	}

} // end of class
