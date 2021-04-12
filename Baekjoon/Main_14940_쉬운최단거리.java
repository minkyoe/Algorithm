import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940_쉬운최단거리 {

	private static int N, M, startY, startX;
	private static int[][] map, ans;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0,index = 0; j < M; j++, index+=2) {
				map[i][j] = s.charAt(index) - '0';
				if (map[i][j] == 2) {
					startY = i;
					startX = j;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		visited[startY][startX] = true;
		q.offer(new int[] {startY, startX, 0});
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int cnt = tmp[2];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				ans[nr][nc] = cnt + 1;
				q.offer(new int[] {nr, nc, cnt+1});
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ans[i][j] == 0) {
					if (map[i][j] == 0 || map[i][j] == 2) System.out.print("0 ");
					else System.out.print("-1 ");
				}
				else System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		

	} // end of main
 
} // end of class
