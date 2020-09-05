import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1916_최소비용구하기 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int INF = 10000_0001; // 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수고 도시 개수는 최대 1000개
	static int N, M; // 도시 개수, 버스 개수
	static int start, dest; // 출발 도시 번호, 도착 도시 번호
	static ArrayList<Node> list[]; // 인접리스트
	static int[] dist; // 최단거리 갱신해줄 배열
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node() {
		}
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		list = new ArrayList[N+1]; // 0번 안씀 
		dist = new int[N+1]; // 0번 안씀
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dist, INF);
		dist[start] = 0; // 시작 정점은 0으로 초기화
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.to;
			int weight = node.weight;
			
			if (dist[now] < weight) continue;
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i).to;
				int nextDist = list[now].get(i).weight;
				
				if (dist[next] > nextDist + weight) {
					pq.offer(new Node (next, nextDist + weight));
					dist[next] = nextDist + weight;
				}
			}
		}
		
		System.out.println(dist[dest]);
		
		
	} // end of main

} // end of class
