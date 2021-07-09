import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	private static int M, N;
	private static int[][] box;
	private static int notRiped;
	private static boolean[][] visited;
	private static int ans;
	private static int[] dr = {-1, 1, 0 ,0};
	private static int[] dc = {0, 0, -1 ,1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		notRiped = M * N; // 안익은 토마토 개수
		visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				box[i][j] = tmp;
				
				if (tmp == 0) continue;
				
				--notRiped;
				visited[i][j] = true;
				
				if (tmp == 1) q.offer(new int[] {i, j, notRiped, 0});
			}
		}
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			int remains = tmp[2];
			int past = tmp[3];
			
			if (remains == 0) {
				ans = past;
				break;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (visited[nr][nc] || box[nr][nc] == -1) continue;
				
				--notRiped;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, notRiped, past + 1});
			}
		}
		
		if (notRiped > 0) System.out.println(-1);
		else System.out.println(ans);
		
	} // end of main

} // end of class
