import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {

	private static int N, M;
	private static int[][] map;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		int ans = 0;
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			bfs(i);
			++ans;
		}
		System.out.println(ans);
	} // end of main

	private static void bfs(int now) {
		visited[now] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(now);
		
		while (!q.isEmpty()) {
			int n = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if (i == n || visited[i]) continue;
				if (map[n][i] == 1 || map[i][n] == 1) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}

} // end of class
