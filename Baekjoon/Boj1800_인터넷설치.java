import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1800_인터넷설치 {

	private static int N;
	private static int P;
	private static int K;
	private static final int MAX = Integer.MAX_VALUE;
	private static ArrayList<Vertex>[] list;
	private static int[] dist;
	private static int max;
	
	static class Vertex implements Comparable<Vertex>{
		int v;
		int w;
		
		Vertex (int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		public int compareTo(Vertex o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		P = Integer.parseInt(st.nextToken()); // 케이블 개수
		K = Integer.parseInt(st.nextToken()); // 공짜 케이블 개수
		dist = new int[N+1];
		max = 0;
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Vertex(b, w));
			list[b].add(new Vertex(a, w));
			max = max < w ? w : max;
		}
		
		int left = 0;
		int right = max;
		int ans = Integer.MIN_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (dijkstra(mid)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		if (ans == Integer.MIN_VALUE) System.out.println("-1");
		else System.out.println(ans);
		
	} // end of main

	private static boolean dijkstra(int mid) {
		for (int i = 1; i <= N; i++) {
			dist[i] = MAX;
		}
		dist[1] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.offer(new Vertex(1, 0));
		
		while(!pq.isEmpty()) {
			Vertex tmp = pq.poll();
			int now = tmp.v;
			int nowCost = tmp.w;
			
			if (nowCost > mid) nowCost += 1;
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i).v;
				int nextCost = nowCost;
				
				if (list[now].get(i).w > mid) nextCost += 1;
				
				if (dist[next] > nextCost) {
					dist[next] = nextCost;
					pq.offer(new Vertex(next, dist[next]));
				}
			}
		}
		return dist[N] <= K;
	}

} // end of class
