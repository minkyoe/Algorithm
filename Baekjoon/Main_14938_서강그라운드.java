import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14938_서강그라운드 {

	private static int n, m, r, ans;
	private static int[] items, dist;
	private static ArrayList<Point>[] list;
	
	static class Point implements Comparable<Point>{
		int to;
		int weight;
		
		Point (int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Point p) {
			return this.weight - p.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken()); // 지역 개수 
		m = Integer.parseInt(st.nextToken()); // 수색 범위 
		r = Integer.parseInt(st.nextToken()); // 길의 개수
		
		items = new int[n+1];
		dist = new int[n+1];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
			dist[i] = Integer.MAX_VALUE;
		}
		
		list = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Point(b, c));
			list[b].add(new Point(a, c));
		}
		
		ans = 0;
		for (int i = 1; i <= n; i++) {
			dist[i] = 0;
			dijkstra(i);
			
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[j] <= m) sum += items[j];
			}
			ans = Math.max(ans, sum);
			
			Arrays.fill(dist, Integer.MAX_VALUE);
		}
		
		System.out.println(ans);
	} // end of main

	private static void dijkstra(int n) {
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(n, 0));
		
		while (!pq.isEmpty()) {
			Point tmp = pq.poll();
			int now = tmp.to;
			int nowDist = tmp.weight;
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i).to;
				int nextDist = list[now].get(i).weight;
				if (dist[next] > nowDist + nextDist) {
					dist[next] = nowDist + nextDist;
					pq.offer(new Point(next, dist[next]));
				}
			}
		}
	}

} // end of class
