import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15661_링크와스타트 {

	private static int N, ans;
	private static int[][] map;
	private static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N+1][N+1];
		selected = new boolean[N+1];
		ans = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go(1, 0);
		
		System.out.println(ans);
	} // end of main

	private static void go(int idx, int cnt) {
		if (cnt == N) return;
		if (2 <= cnt && cnt < N-1) {
			int sumA = 0;
			int sumB = 0;
			boolean[][] visited = new boolean[N+1][N+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (selected[i] != selected[j] || i == j || visited[i][j]) continue;
					visited[i][j] = visited[j][i] = true;
					if (selected[i]) sumA += (map[i][j] + map[j][i]);
					else sumB += (map[i][j] + map[j][i]);
				} 
			}
			
			int tmp = Math.abs(sumA - sumB);
			ans = Math.min(tmp, ans);
		}
		
		for (int i = idx; i <= N; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			go(i+1, cnt+1);
			selected[i] = false;
		}
	}

} // end of class
