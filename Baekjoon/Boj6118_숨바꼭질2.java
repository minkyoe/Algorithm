package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @author minkyoe
 * 다익스트라 버전
 */
public class Main_6118_숨바꼭질2 {
	
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

	private static int N; // 헛간 개수, 2 <= N <= 20,000
	private static int M; // 길의 개수 (양방향), 1<= M <= 50,000
	private static ArrayList<Integer>[] map;
	private static boolean[] visited;
	private static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1];
		dist = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		
		dist[1] = 0;
		dijkstra(1);
		
		int maxDist = 0;
		int maxSpot = 0;
		int maxCnt = 0;
		for (int i = 1; i <= N; i++) {
			if (maxDist < dist[i]) {
				maxDist = dist[i];
				maxSpot = i;
				maxCnt = 1;
			}
			else if (maxDist == dist[i]) {
				maxCnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(maxSpot).append(" ").append(maxDist).append(" ").append(maxCnt);
		System.out.println(sb);

	} // end of main

	private static void dijkstra(int v) {
		PriorityQueue<Spot> pq = new PriorityQueue<>();
		pq.offer(new Spot(v, 0));
		
		while(!pq.isEmpty()) {
			Spot tmp = pq.poll();
			int nowVertex = tmp.vertex;
			int nowDist = tmp.dist;
			
			if (dist[nowVertex] < nowDist) continue;
			
			for (int i = 0; i < map[nowVertex].size(); i++) {
				int next = map[nowVertex].get(i);
				int nextDist = nowDist + 1;
				if (dist[next] > nextDist) {
					pq.offer(new Spot(next, nextDist));
					dist[next] = nextDist;
				}
			}
			
		}
		
		
		
	}

} // end of class
