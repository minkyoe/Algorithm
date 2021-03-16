import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {

	private static int N;
	private static int[][] map;
	private static int[] selected;
	private static int ans;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		selected = new int[N];
		visited = new boolean[N];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		
		System.out.println(ans);
	} // end of main

	private static void comb(int idx, int cnt) {
		if (cnt == N) {
			check(selected[0]);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			selected[cnt] = i;
			visited[i] = true;
			comb(i, cnt+1);
			visited[i] = false;
		}
		
	}

	private static void check(int start) {
		if (map[selected[N-1]][start] == 0) return;

		int sum = map[selected[N-1]][start];
		
		for (int i = 0; i < N-1; i++) {
			if (map[selected[i]][selected[i+1]] == 0) return;
			sum += map[selected[i]][selected[i+1]];
		}
		
		ans = Math.min(ans, sum);
	}

} // end of class
