import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3085_사탕게임 {

	private static int N, ans;
	private static char[][] arr;
	private static int[] dr = { 1, 0 };
	private static int[] dc = { 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		ans = 0;
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int dir = 0; dir < dr.length; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;

					// 값 바꾸기
					char tmp = arr[r][c];
					arr[r][c] = arr[nr][nc];
					arr[nr][nc] = tmp;

					check();

					// 값 원상복구
					tmp = arr[r][c];
					arr[r][c] = arr[nr][nc];
					arr[nr][nc] = tmp;

				}
			}
		}

		System.out.println(ans);

	} // end of main

	private static void check() {
		int cnt = 1;

		// 가로 (행) 체크
		for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 1; j < N; j++) {
				if (arr[i][j] == arr[i][j - 1]) {
					++cnt;
				} else {
					ans = Math.max(ans, cnt);
					cnt = 1;
				}
			}
			ans = Math.max(ans, cnt);
		}

		// 세로 (열) 체크
		for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 1; j < N; j++) {
				if (arr[j][i] == arr[j - 1][i]) {
					++cnt;
				} else {
					ans = Math.max(ans, cnt);
					cnt = 1;
				}
			}
			ans = Math.max(ans, cnt);
		}

	} // end of check

} // end of class
