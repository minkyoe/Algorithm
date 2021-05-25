import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_21278_호석이두마리치킨 {

	private static int N, M, ansDist;
	private static ArrayList<Integer>[] list;
	private static int[] selected;
	private static int[] ans;
	private static int[][] distance; // 다익스트라
	private static class Vertex implements Comparable<Vertex>{
		int n;
		int dist;
		
		Vertex(int n, int dist) {
			this.n = n;
			this.dist = dist;
		}
		
		public int compareTo(Vertex o) {
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		selected = new int[2];
		ansDist = Integer.MAX_VALUE;
		ans = new int[2];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		go(1, 0);
		StringBuilder sb = new StringBuilder();
		sb.append(ans[0]).append(" ").append(ans[1]).append(" ").append(ansDist);
		System.out.println(sb);
		
	} // end of main
	

	private static void go(int idx, int cnt) {
		if (cnt == 2) {
			distance = new int[2][N+1];
			for (int i = 0; i < 2; i++) {
				int n = selected[i];
				Arrays.fill(distance[i], Integer.MAX_VALUE);
				distance[i][n] = 0;
				dijkstra(n, i);
			}
			
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (i == selected[0] || i == selected[1]) continue;
				sum += Math.min(distance[0][i], distance[1][i]) * 2;
			}
			
			if (sum < ansDist) {
				ansDist = sum;
				ans[0] = selected[0];
				ans[1] = selected[1];
			}
			else if (sum == ansDist) {
				if (ans[0] == selected[0]) {
					if (ans[1] > selected[1]) {
						ansDist = sum;
						ans[0] = selected[0];
						ans[1] = selected[1];
					}
				}
				else if (ans[0] > selected[0]) {
					ansDist = sum;
					ans[0] = selected[0];
					ans[1] = selected[1];
				}
			}
			
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			selected[cnt] = i;
			go(i+1, cnt+1);
		}
	}
	
	private static void dijkstra(int n, int order) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(n, 0));
		
		while (!pq.isEmpty()) {
			Vertex v = pq.poll();
			int now = v.n;
			int nowDist = v.dist;
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				if (distance[order][next] > nowDist + 1) {
					distance[order][next] = nowDist + 1;
					pq.offer(new Vertex(next, distance[order][next]));
				}
			}
		}
	}

} // end of class
