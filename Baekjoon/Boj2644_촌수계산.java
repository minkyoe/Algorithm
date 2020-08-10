import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, t1, t2, m, x, y; // 사람수, 구해야하는촌수 사람1, 2, 가족관계수, 자식, 부모
	private static int[][] family;
	private static boolean[] visited;
	private static int[] dep;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");
		t1 = Integer.parseInt(st.nextToken());
		t2 = Integer.parseInt(st.nextToken());
		family = new int[n + 1][n + 1]; // 0번안씀

		m = Integer.parseInt(bf.readLine());

		visited = new boolean[n + 1]; // 0번 안씀
		dep = new int[n + 1]; // 0번 안씀
		for (int i = 0; i < m; i++) { // 가족관계수만큼
			st = new StringTokenizer(bf.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			family[x][y] = 1;
			family[y][x] = 1;
		}

		bfs(t1);

		int ans = (dep[t2] == 0) ? -1 : dep[t2];
		System.out.println(ans);
	} // end of main

	private static void bfs(int t1) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(t1);
		visited[t1] = true;

		while (!q.isEmpty()) {
			int now = q.peek();
			q.poll();

			for (int i = 1; i <= n; i++) {
				if (family[now][i] == 1 && dep[i] == 0) {
					q.offer(i);
					dep[i] = dep[now] + 1;
					visited[i] = true;
				}
			}
		}

	}

} // end of class
