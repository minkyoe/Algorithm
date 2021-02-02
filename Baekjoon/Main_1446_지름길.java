package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1446_지름길 {
	private static class Road implements Comparable<Road>{
		int to;
		int weight;
		
		Road(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Road road) {
			return this.weight - road.weight;
		}
	}
	private static int N;
	private static int D;
	private static final int MAX = Integer.MAX_VALUE;
	private static ArrayList<Road>[] list;
	private static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 지름길 개수
		D = Integer.parseInt(st.nextToken()); // 고속도로 길이 
		list = new ArrayList[10001]; // 인덱스: 출발 지점
		
		for (int i = 0; i <= 10000; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Road(to, weight));
		}
		
		dist = new int[10001];
		Arrays.fill(dist, MAX);
		
		dijkstra(0);
		
		System.out.println(dist[D]);
	} // end of main
	private static void dijkstra(int start) {
		dist[start] = 0;
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.add(new Road(start, 0));
		
		while(!pq.isEmpty()) {
			Road tmp = pq.poll();
			int now = tmp.to;
			int nowDist = tmp.weight;
			
			if (nowDist > dist[now]) continue;
			
			for (int i = 0; i < list[now].size(); i++) {
				Road tmpNext = list[now].get(i);
				int next = tmpNext.to;
				int nextDist = tmpNext.weight;
				
				if (next > D) continue;
				if (nowDist + nextDist < dist[next]) {
					if (nowDist + (next - now) < nowDist + nextDist) {
						dist[next] = nowDist + (next - now);
					} else {
						dist[next] = nowDist + nextDist;
					}
					pq.add(new Road(next, dist[next]));
				}
				else if (nowDist + (next - now) < dist[next]) {
					dist[next] = nowDist + (next - now);
					pq.add(new Road(next, dist[next]));
				}
			}
			
			if (now + 1 <= D && dist[now+1] > nowDist+1) {
				dist[now+1] = nowDist+1;
				pq.add(new Road(now+1, nowDist+1));
			}
		}
		
	}
 
} // end of class
