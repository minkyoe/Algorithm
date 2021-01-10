package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {

	private static int N;
	private static int M;
	private static int X;
	private static final int INF = Integer.MAX_VALUE;
	private static int[][] list;
	private static int[][] reverse;
	private static int ans;
	
	static class Vertex implements Comparable<Vertex>{
		int v;
		int w;
		
		Vertex(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 도로 수
		X = Integer.parseInt(st.nextToken()); // 파티 마을
		ans = 0;
		
		list = new int[N+1][N+1];
		reverse = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from][to] = weight;
			reverse[to][from] = weight;
		}
		
		int[] go = dijkstra(list, X);
		int[] back = dijkstra(reverse, X);
		
		for (int i = 1; i <= N; i++) {
			if (X == i || go[i] == INF || back[i] == INF) continue;
			int tmp = go[i] + back[i];
			ans = ans < tmp ? tmp : ans;
		}
		
		System.out.println(ans);
	} // end of main

	private static int[] dijkstra(int[][] map, int start) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, 0));
		
		int[] dist = new int[N+1];
		for (int i = 1; i <= N; i++) {
			if (i == X) dist[i] = 0;
			else dist[i] = INF;
		}
		
		while(!pq.isEmpty()) {
			Vertex tmp = pq.poll();
			int now = tmp.v;
			int nowDist = tmp.w;
			
			for (int j = 1; j <= N; j++) {
				if (start == j || map[now][j] == 0) continue;
				int nextDist = map[now][j];
				
				if (nowDist + nextDist < dist[j]) {
					dist[j] = nowDist + nextDist;
					pq.offer(new Vertex(j, dist[j]));
				}
			}
		}
		
		return dist;
	}

} // end of class
