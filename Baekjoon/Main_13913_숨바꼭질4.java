import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4 {

	private static int N, K, totalTime;
	private static int[] path;
	private static ArrayList<Integer> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		path = new int[10_0000_2];
		totalTime = 0;
		ans = new ArrayList<Integer>();
		
		boolean[] visited = new boolean[10_0000_2];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		visited[N+1] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int time = tmp[1];
			
			if (now == K) {
				totalTime = time;
				break;
			}
			
			if (now * 2 <= 100000 && !visited[now * 2 + 1]) {
				visited[now * 2 + 1] = true;
				q.offer(new int[] {now * 2, time + 1});
				path[now * 2] = now;
			}
			
			if (now + 1 <= 100000 && !visited[now + 2]) {
				visited[now + 2] = true;
				q.offer(new int[] {now + 1, time + 1});
				path[now + 1] = now;
			}

			if (now - 1 >= 0 && now - 1 <= 100000 && !visited[now]) {
				visited[now] = true;
				q.offer(new int[] {now - 1, time + 1});
				path[now - 1] = now;
			}
  		}
		
		int now = K;
		while (now != N) {
			ans.add(now);
			now = path[now];
		}
		ans.add(now);
		
		sb.append(totalTime).append("\n");
		for (int i = ans.size()-1; i >= 0; i--) {
			sb.append(ans.get(i)).append(" ");
		}

		System.out.println(sb);
	} // end of main

} // end of class
