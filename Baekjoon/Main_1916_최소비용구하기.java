import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {

	private static int N;
	private static int M;
	private static int[] dist;
	private static PriorityQueue<City> pq;
	private static int start;
	private static int end;
	private static ArrayList<City>[] info;
	
	private static class City implements Comparable<City>{
		int dest;
		int dist;
		
		City (int dest, int dist) {
			this.dest = dest;
			this.dist = dist;
		}
		
		public int compareTo(City o) {
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // 도시 개수
		M = Integer.parseInt(bf.readLine()); // 버스 개수
		dist = new int[N+1];
		pq = new PriorityQueue<City>();
		info = new ArrayList[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 1; i <= N; i++) {
			info[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			info[start].add(new City(from, distance));
		}
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dist[start] = 0;
		pq.offer(new City(start, 0));
		dijkstra();
		System.out.println(dist[end]);
	} // end of main

	private static void dijkstra() {
		while (!pq.isEmpty()) {
			City city = pq.poll();
			int now = city.dest;
			int nowDist = city.dist;
			
			if (nowDist > dist[now]) continue;
			
			for (int i = 0; i < info[now].size(); i++) {
				City nextCity = info[now].get(i);
				int next = nextCity.dest;
				int nextDist = nextCity.dist;
				
				if (nowDist + nextDist < dist[next]) {
					dist[next] = nowDist + nextDist;
					pq.offer(new City(next, dist[next]));
				}
			}
		}
	}

} // end of class
