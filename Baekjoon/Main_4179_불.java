import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179_불 {

	private static int R;
	private static int C;
	private static int sr, sc; // 지훈 시작 위치
	private static int ans;
	private static char[][] map;
	private static int[][] fire;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		fire = new int[R][C];
		Queue<int[]> q = new LinkedList<>();
		ans = 0;
		
		for (int i = 0; i < R; i++) {
			String s = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'F') {
					fire[i][j] = -1; // 불 초기 위치
					q.offer(new int[] {i, j, 0});
				}
				else if (map[i][j] == 'J') {
					sr = i;
					sc = j;
				}
			}
		}
		
		// 불 번지기
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '#' || fire[nr][nc] == -1) continue;
				if (fire[nr][nc] == 0) {
					fire[nr][nc] = cnt + 1;
					q.offer(new int[] {nr, nc, cnt+1});
				}
				else if (fire[nr][nc] > (cnt+1)) {
					fire[nr][nc] = cnt + 1;
					q.offer(new int[] {nr, nc, cnt+1});
				}
			}
		}
		
		// 지훈 이동
		q.offer(new int[] {sr, sc, 0});
		boolean[][] visited = new boolean[R][C];
		visited[sr][sc] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			if (tr == 0 || tr == R-1 || tc == 0 || tc == C-1) {
				ans = cnt+1;
				break;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == '#' 
						|| fire[nr][nc] == -1 || (fire[nr][nc] != 0 && fire[nr][nc] <= (cnt+1))) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, cnt+1});
			}
			
		}
		
		if (ans == 0) System.out.println("IMPOSSIBLE");
		else System.out.println(ans);
	} // end of main
} // end of class
