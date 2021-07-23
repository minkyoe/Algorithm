import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {

	private static int N;
	private static int K;
	private static boolean[] visited;
	private static final int MAX = 20_0000;
	private static int[] dist = {2, -1, 1};
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[MAX+2]; // 현재 위치에서 1을 더한 것으로 방문 여부 판단 
		
		q.offer(new int[] {N, 0});
		visited[N+1] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int time = tmp[1];
			
			if (now == K) {
				ans = time;
				break;
			}
			
			for (int i = 0; i < dist.length; i++) {
				int next = now;
				if (dist[i] == 2) {
					next *= 2;
				} else {
					next += dist[i];
				}
				
				if (next < -1 || next > MAX || visited[next+1]) continue;
				visited[next+1] = true;
				q.offer(new int[] {next, time + 1});
			}
		}
		
		System.out.println(ans);
	} // end of main

} // end of class
