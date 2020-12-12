package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_1719_택배 {
	
	static class Spot implements Comparable<Spot> {
		int vertex;
		int dist;
		
		public Spot (int v, int d) {
			this.vertex = v;
			this.dist = d;
		}

		@Override
		public int compareTo(Spot o) {
			return this.dist - o.dist;
		}
	}

	private static int N;
	private static int M;
	private static int[][] list;
	private static int[] dist;
	private static int[] firstSpot;
	private static String[][] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 집하장 개수
		M = Integer.parseInt(st.nextToken()); // 경로 개수
		list = new int[N+1][N+1];
		ans = new String[N+1][N+1];
		dist = new int[N+1];
		firstSpot = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list[a][b] = time;
			list[b][a] = time;
		}
		
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(firstSpot, 0);
			
			dist[i] = 0; // 출발지점은 0으로 초기화
			dijkstra(i);
			
			for (int j = 1; j <= N; j++) {
				if (i == j) ans[i][j] = "-";
				else {
					ans[i][j] = String.valueOf(firstSpot[j]);
				}
			}
		}
		
		// 정답 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		
	} // end of main

	private static void dijkstra(int v) {
		PriorityQueue<Spot> pq = new PriorityQueue<>();
		pq.offer(new Spot(v, 0));
		
		while(!pq.isEmpty()) {
			Spot tmp = pq.poll();
			int now = tmp.vertex;
			int nowDist = tmp.dist;
			
			if (dist[now] < nowDist) continue;
			
			for (int i = 1; i <= N; i++) {
				if (i == now || list[now][i] == 0) continue;
				int next = i;
				int nextDist = nowDist + list[now][next];
				if (dist[next] > nextDist) {
					pq.offer(new Spot(next, nextDist));
					dist[next] = nextDist;
					if (now == v) firstSpot[next]= next;
					else firstSpot[next] = firstSpot[now]; // 현재 이어진 정점이 처음으로 거친 점을 대입
				}
			}
		}
		
	}

} // end of class
