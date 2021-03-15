import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {

	private static int N;
	private static int M;
	private static int X;
	private static final int INF = Integer.MAX_VALUE;
	private static ArrayList<Loc>[] list;
	private static int[] go;
	private static int ans;
	private static int[] back;
	
	static class Loc implements Comparable<Loc>{
		int v;
		int w;
		
		Loc (int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		public int compareTo(Loc o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 학생 수 
		M = Integer.parseInt(st.nextToken()); // 단방향 도로 수
		X = Integer.parseInt(st.nextToken()); // 모일 마을 
		ans = Integer.MIN_VALUE;
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Loc>();
		}
		
		go = new int[N+1];
		back = new int[N+1];
		Arrays.fill(go, INF);
		Arrays.fill(back, INF);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Loc(b, w));
		}
		
		dijkstraBack(X);
		
		for (int i = 1; i <= N; i++) {
			if (i == X) continue;
			int sum = back[i];
			dijkstra(i);
			sum += go[X];
			ans = Math.max(ans, sum);
			Arrays.fill(go, INF);
		}
		
		System.out.println(ans);
	} // end of main
	
	private static void dijkstraBack(int i) {
		PriorityQueue<Loc> pq = new PriorityQueue<>();
		pq.offer(new Loc(i, 0));
		go[i] = 0;
		
		while (!pq.isEmpty()) {
			Loc tmp = pq.poll();
			int now = tmp.v;
			int nowDist = tmp.w;
			
			for (int j = 0; j < list[now].size(); j++) {
				int next = list[now].get(j).v;
				int nextDist = list[now].get(j).w;
				if (nowDist + nextDist < back[next]) {
					back[next] = nowDist + nextDist;
					pq.offer(new Loc(next, back[next]));
				}
			}
		}
	}
	
	private static void dijkstra(int i) {
		PriorityQueue<Loc> pq = new PriorityQueue<>();
		pq.offer(new Loc(i, 0));
		go[i] = 0;
		
		while (!pq.isEmpty()) {
			Loc tmp = pq.poll();
			int now = tmp.v;
			int nowDist = tmp.w;
			
			for (int j = 0; j < list[now].size(); j++) {
				int next = list[now].get(j).v;
				int nextDist = list[now].get(j).w;
				if (nowDist + nextDist < go[next]) {
					go[next] = nowDist + nextDist;
					pq.offer(new Loc(next, go[next]));
				}
			}
		}
	}

} // end of class
