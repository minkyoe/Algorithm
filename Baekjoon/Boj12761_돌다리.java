import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12761_돌다리 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int A, B; // 스카이콩콩 힘
	static int N, M; // 동규, 주미의 위치
	static int ans = 0;
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		bfs(N, 0); // 동규 위치, cnt
		System.out.println(ans);
	} // end of main

	private static void bfs(int N, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { N, cnt });
		visited[N] = true;

		while (!q.isEmpty()) {
			int now = q.peek()[0];
			int count = q.peek()[1];
			q.poll();

			if (now == M) {
				ans = count;
				break;
			}

			if (0 <= now - 1 && now - 1 <= 100000 && !visited[now - 1]) {
				q.offer(new int[] { now - 1, count + 1 });
				visited[now - 1] = true;
			}
			if (0 <= now + 1 && now + 1 <= 100000 && !visited[now + 1]) {
				q.offer(new int[] { now + 1, count + 1 });
				visited[now + 1] = true;
			}
			if (0 <= now + A && now + A <= 100000 && !visited[now + A]) {
				q.offer(new int[] { now + A, count + 1 });
				visited[now + A] = true;
			}
			if (0 <= now + B && now + B <= 100000 && !visited[now + B]) {
				q.offer(new int[] { now + B, count + 1 });
				visited[now + B] = true;
			}
			if (0 <= now - A && now - A <= 100000 && !visited[now - A]) {
				q.offer(new int[] { now - A, count + 1 });
				visited[now - A] = true;
			}
			if (0 <= now - B && now - B <= 100000 && !visited[now - B]) {
				q.offer(new int[] { now - B, count + 1 });
				visited[now - B] = true;
			}
			if (0 <= now * A && now * A <= 100000 && !visited[now * A]) {
				q.offer(new int[] { now * A, count + 1 });
				visited[now * A] = true;
			}
			if (0 <= now * B && now * B <= 100000 && !visited[now * B]) {
				q.offer(new int[] { now * B, count + 1 });
				visited[now * B] = true;
			}

		}
		return;

	}
} // end of class
