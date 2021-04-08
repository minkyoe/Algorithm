import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 물에 잠기지 않는 안전한 영역의 최대 개수
public class Main_2468_안전영역 {

	private static int N, ans, max;
	private static int[][] map;
	private static boolean[][] sink;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		sink = new boolean[N][N];
		ans = Integer.MIN_VALUE;
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		for (int i = 0; i <= max; i++) {
			// 잠긴 곳 표시
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] <= i) sink[j][k] = true;
				}
			}
			
			// 안전한 영역 개수 구하기
			int cnt = 0;
			boolean[][] visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!sink[j][k] && !visited[j][k]) {
						++cnt;
						Queue<int[]> q = new LinkedList<>();
						q.offer(new int[] {j, k});
						visited[j][k] = true;
						
						while (!q.isEmpty()) {
							int[] tmp = q.poll();
							int tr = tmp[0];
							int tc = tmp[1];
							
							for (int l = 0; l < 4; l++) {
								int nr = tr + dr[l];
								int nc = tc + dc[l];
								
								if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || sink[nr][nc]) continue;
								visited[nr][nc] = true;
								q.offer(new int[] {nr, nc});
							}
						} // end of while
				
					}
				}
			} // end of 안전영역구하기
			
			ans = Math.max(ans, cnt);
			
			// 잠긴 곳 원상복구
			for (int j = 0; j < N; j++) {
				Arrays.fill(sink[j], false);
			}
		}
		
		System.out.println(ans);
	} // end of main

} // end of class
