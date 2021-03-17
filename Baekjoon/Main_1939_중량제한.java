import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1939_중량제한 {
	static class Bridge {
		int n;
		int cost;
		
		Bridge (int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
	}
	private static int N;
	private static int M;
	private static ArrayList<Bridge>[] list;
	private static int to;
	private static int from;
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		ans = -1;
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Bridge>();
		}
		
		int left = 0;
		int right = -1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Bridge(b, c));
			list[b].add(new Bridge(a, c));
			right = Math.max(right, c);
		}
		
		st = new StringTokenizer(bf.readLine(), " ");
		to = Integer.parseInt(st.nextToken());
		from = Integer.parseInt(st.nextToken());
		
		while (left <= right) {
			int mid = (left + right) / 2; // 중량 제한
			
			if (check(mid)) { // 갈 수 있다면 중량 높임 
				ans = Math.max(ans, mid);
				left = mid + 1;
			} else { // 그렇지 않다면 중량 낮춤
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	} // end of main

	private static boolean check(int mid) {
		boolean[] visited = new boolean[N+1];
		visited[to] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(to);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < list[now].size(); i++) {
				Bridge tmp = list[now].get(i);
				int next = tmp.n;
				int nextCost = tmp.cost;
				
				if (visited[next] || nextCost < mid) continue;
				visited[next] = true;
				q.offer(next);
			}
		}
		
		return visited[from];
	}

} // end of class
