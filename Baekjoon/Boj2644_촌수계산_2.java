import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2644_촌수계산_2 {

	private static int N;
	private static int M;
	private static int a;
	private static int b;
	private static int[][] map;
	private static int[] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N+1][N+1];
		dist = new int[N+1];

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(bf.readLine());

		if (a == b)
			System.out.println(0);
		else {
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int aa = Integer.parseInt(st.nextToken());
				int bb = Integer.parseInt(st.nextToken());
				map[aa][bb] = 1;
				map[bb][aa] = 1;
			}
			
			bfs(a);
			
			if (dist[b] == 0) System.out.println("-1");
			else System.out.println(dist[b]);
		}
	} // end of main

	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if (now == b) return;
			
			for (int i = 1; i <= N; i++) {
				if (map[now][i] == 1 && dist[i] == 0) {
					dist[i] = dist[now] + 1;
					q.offer(i);
				}
			}
		}
		
	}

} // end of class
