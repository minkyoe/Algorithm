import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_18352_특정거리의도시찾기 {

	private static int N, M, K, X;
	private static ArrayList<Integer>[] list;
	private static ArrayList<Integer> ans;
	private static int[] dist;
	static class City implements Comparable<City>{
		int n;
		int w;
		
		City (int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(City o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 도시 개수 
		M = Integer.parseInt(st.nextToken()); // 도로 개수 
		K = Integer.parseInt(st.nextToken()); // 거리 정보 
		X = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		dist = new int[N+1];
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b); // 단방향
		}
		
		dist[X] = 0;
		dijkstra(X);
		ans = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if (i == X) continue;
			if (dist[i] == K) ans.add(i);
 		}
		
		if (ans.size() == 0) System.out.println("-1");
		else {
			for (int i = 0; i < ans.size(); i++) {
				System.out.println(ans.get(i));
			}
		}
	} // end of main

	private static void dijkstra(int start) {
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.offer(new City(start, 0));
		
		while (!pq.isEmpty()) {
			City tmp = pq.poll();
			int now = tmp.n;
			int nowDist = tmp.w;
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				
				if (dist[next] > nowDist + 1) {
					dist[next] = nowDist + 1;
					pq.offer(new City(next, dist[next]));
				}
			}
		}
	}

} // end of class
 