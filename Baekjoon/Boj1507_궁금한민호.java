import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//플로이드는  dist[i][j] 값과 어떤 k 를 거칠 때 의 dist[i][k]+dist[k][j] 값이 같다면  i->j 와 i->k->j 이므로 i->j 간선이 필요 없어지는 것을 이용합니다.

public class Main_1507_궁금한민호 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 도시 개수
	private static int[][] map;
	private static boolean[][] ans;
	static boolean isPossible = true;
	static int sum = 0;
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		map = new int[N + 1][N + 1]; // 0번 인덱스 사용안함
		ans = new boolean[N + 1][N + 1]; // 0번 인덱스 사용안함
		visited = new boolean[N + 1][N + 1]; // 0번 인덱스 사용안함

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ex: for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;
					if (i != k && k != j) {
						if (map[i][j] > map[i][k] + map[k][j]) {
							isPossible = false;
							break ex;
						}
						if (map[i][j] == map[i][k] + map[k][j]) {
							// i->j == i->k->j
							ans[i][j] = ans[j][i] = true; // 합에 더하지 않
						}
					}
				} // end of j
			} // end of i
		} // end of k

		if (!isPossible)
			System.out.println("-1");
		else {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!ans[i][j] && !visited[i][j] && !visited[j][i]) {
						sum += map[i][j];
						visited[i][j] = visited[j][i] = true;
					}
				}
			}
			System.out.println(sum);
		}

	} // end of main
} // end of class
