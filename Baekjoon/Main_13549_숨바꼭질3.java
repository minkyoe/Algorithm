import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3 {

	private static int N;
	private static int K;
	private static int ans;
	private static boolean[] visited;
	private static final int MAX = 10_0000;
	private static final int MIN = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[MAX*2+1];
		ans = Integer.MAX_VALUE;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		visited[N] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int time = tmp[1];
			
			if (now == K) {
				ans = time;
				break;
			}
			
			if (MIN <= (now * 2) && (now * 2) <= MAX && !visited[now * 2]) {
				visited[now * 2] = true;
				q.offer(new int[] {now * 2, time});
			}
			
			if (MIN <= (now - 1) && (now - 1) <= MAX && !visited[now - 1]) {
				visited[now - 1] = true;
				q.offer(new int[] {now - 1, time + 1});
			}
			
			if (MIN <= (now + 1) && (now + 1) <= MAX && !visited[now + 1]) {
				visited[now + 1] = true;
				q.offer(new int[] {now + 1, time + 1});
			}
		}
		
		System.out.println(ans);
	} // end of main

} // end of class
