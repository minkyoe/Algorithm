import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17070_파이프옮기기_dfs {
	private static int N;
	static int dr[] = {0, 1, 1}; // 가 세 대
	static int dc[] = {1, 0, 1}; // 가 세 대
	// 가 - 가, 대
	// 세 - 세, 대
	// 대 - 가, 세, 대
	private static char[][] map;
	private static boolean[][][] visited;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		map = new char[N+1][N+1];
		ans = 0;
		visited = new boolean[N+1][N+1][3];
		
		
		for (int i = 1; i <= N; i++) {
			String s = bf.readLine();
			for (int j = 1, index = 0; j <= N; j++,index+=2) {
				map[i][j] = s.charAt(index);
			}
		}
		
		dfs(1,2,0,0);
		System.out.println(ans);

	} // end of main

	private static void dfs(int er, int ec, int mode, int cnt) {
		if (er == N && ec == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if (mode + i == 1) continue;
			
			int nr = er + dr[i];
			int nc = ec + dc[i];
			
			
			if (nr > N || nc > N) continue;
			if (map[nr][nc] == '1' || visited[nr][nc][i]) continue;
			if (i == 2) {
				if(map[nr-1][nc] == '1' || map[nr][nc-1] == '1') continue;
			}
			
			visited[nr][nc][i] = true;
			if (i == 2) {
				visited[nr-1][nc][i] = true;
				visited[nr][nc-1][i] = true;
			}
			
			dfs(nr, nc, i, cnt+1);
			
			visited[nr][nc][i] = false;
			if (i == 2) {
				visited[nr-1][nc][i] = false;
				visited[nr][nc-1][i] = false;
			}
		}
		
	}
} // end of class
