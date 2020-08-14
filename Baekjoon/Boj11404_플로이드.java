import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m; // 도시 수, 버스 수
	// 1 ≤ n ≤ 100
	// 1 ≤ m ≤ 100,000
	private static int[][] map;
	static final int INF = 10_000_000; // 100,000 * 100

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());

		map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = (map[a][b] > c) ? c : map[a][b]; // 더 최소인 값으로 갱신 (시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다)
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					if (i != k || k != j)
						map[i][j] = (map[i][j] > map[i][k] + map[k][j]) ? map[i][k] + map[k][j] : map[i][j];
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 0 || map[i][j] == INF)
					System.out.print("0 ");
				else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	} // end of main

} // end of class
