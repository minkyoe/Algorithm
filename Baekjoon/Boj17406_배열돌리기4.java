import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_Boj_17406_배열돌리기4 {

	static int N, M, K;
	static ArrayList<int[]> rotation = new ArrayList<int[]>();
	static boolean[] selected;
	static ArrayList<int[]> realRotation = new ArrayList<int[]>();

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int[][] map;
	private static int[][] copy;

	static int ans = Integer.MAX_VALUE;

	// 우 하 좌 상
	static int[] dirY = { 0, 1, 0, -1 };
	static int[] dirX = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		selected = new boolean[K];
		map = new int[N + 1][M + 1]; // 0번 안씀
		copy = new int[N + 1][M + 1]; // 0번 안씀

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
			}
		}

		// 회전정보 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rotation.add(new int[] { r, c, s });
		}

		// 회전 순서 순열
		perm(0);

		System.out.println(ans);

	} // end of main

	private static void copy() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	private static int getMinSum() {
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;

			for (int j = 1; j <= M; j++) {
				sum = sum + copy[i][j];
			}
			result = result > sum ? sum : result;
		}
		return result;
	}

	private static void perm(int cnt) {
		if (cnt == K) {
			// 복사 (map -> copy)
			for (int i = 0; i < map.length; i++) {
				copy[i] = map[i].clone();
			}

			// 회전정보 수 만큼 실행
			for (int i = 0; i < realRotation.size(); i++) {
				rotate(realRotation.get(i)[0], realRotation.get(i)[1], realRotation.get(i)[2]);
			}

			int tmp = getMinSum();
			ans = ans > tmp ? tmp : ans;
			return;
		}

		for (int i = 0; i < rotation.size(); i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			realRotation.add(new int[] { rotation.get(i)[0], rotation.get(i)[1], rotation.get(i)[2] });
			perm(cnt + 1);
			realRotation.remove(realRotation.size() - 1);
			selected[i] = false;
		}
	}

	private static void rotate(int r, int c, int s) {
		for (int j = 1; j <= s; j++) {
			int y = r - j;
			int x = c - j;
			int size = j * 2 + 1;

			int tmp = copy[y][x];

			for (int i = 1; i < size; i++) {
				copy[y][x] = copy[y + 1][x];
				y++;
			}
			for (int i = 1; i < size; i++) {
				copy[y][x] = copy[y][x + 1];
				x++;
			}
			for (int i = 1; i < size; i++) {
				copy[y][x] = copy[y - 1][x];
				y--;
			}
			for (int i = 1; i < size; i++) {
				copy[y][x] = copy[y][x - 1];
				x--;
			}

			copy[y][x + 1] = tmp;
		}
	}

} // end of class
