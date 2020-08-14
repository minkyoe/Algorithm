import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2458_키순서 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M; // 학생 수, 비교 횟수
	private static int[][] map;
	private static int[] cnt;
	private static int ans;
	static final int INF = 501;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		cnt = new int[N + 1];
		ans = 0;

		// map배열 INF로 초기화
		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}

		for (int k = 1; k <= N; k++) { // 거쳐가는 정점
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i != k || k != j)
						map[i][j] = (map[i][j] > map[i][k] + map[k][j]) ? map[i][k] + map[k][j] : map[i][j];
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (0 < map[i][j] && map[i][j] < INF) {
					cnt[i]++;
					cnt[j]++;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (cnt[i] == N - 1)
				ans++;
		}

		System.out.println(ans);

	} // end of main
} // end of class
