package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획 {
	private static int N;
	private static int M;
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 집의 개수
		M = Integer.parseInt(st.nextToken()); // 길의 개수
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Vertex(from, to, weight));
		}
		
		int cnt = 0;
		int ans = 0; // 총 최소 유지비
		while(!pq.isEmpty()) {
			if (cnt == N-2) break;
			
			Vertex v = pq.poll();
			if (union(v.from, v.to)) {
				ans += v.weight;
				cnt++;
			}
		}
		
		System.out.println(ans);
		
	} // end of main

	private static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if (ra == rb) return false;
		parents[rb] = ra;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
} // end of class

class Vertex implements Comparable<Vertex> {
	int from;
	int to;
	int weight;
	
	public Vertex() {
	}
	
	public Vertex(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Vertex o) {
		return this.weight - o.weight;
	}
}
