package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14496_그대그머가되어 {
	
	private static int a;
	private static int b;
	private static int N;
	private static int M;
	private static int[] dist;
	private static ArrayList<Integer>[] list;
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 전체 문자의 수  
		M = Integer.parseInt(st.nextToken()); // 치환 가능한 문자쌍의 수
		dist = new int[N+1];
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
			if (i != a) dist[i] = INF;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		dijkstra(a);
		if (dist[b] == INF) System.out.println("-1");
		else System.out.println(dist[b]);
	} // end of main

	private static void dijkstra(int a) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(a);
		
		while (!pq.isEmpty()) {
			int now = pq.poll();
			int nowDist = dist[now];
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				if (dist[next] > nowDist + 1) {
					pq.offer(next);
					dist[next] = nowDist + 1;
				}
			}
		} // end of while
	} // end of dijkstra

}
