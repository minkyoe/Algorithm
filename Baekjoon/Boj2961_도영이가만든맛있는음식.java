package live06_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2961 {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 재료의 개수
	static int ans = 1000_000_000;
	static int[][] arr;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][2];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			arr[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}

		for (int i = 1; i <= N; i++) { // 조합 개수 최대 4개
			Arrays.fill(selected, false);
			comb(0, 0, i); // arr[0]부터시작해서 i개 고름. 현재 고른 개수는 0
		}
		System.out.println(ans);
	} // end of main

	private static void comb(int start, int cnt, int R) {
		if (cnt == R) {
			int sin = 1; // 곱
			int sseun = 0; // 합
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					sin *= arr[i][0];
					sseun += arr[i][1];
				}
			}
			int diff = Math.abs(sin - sseun);
			ans = (ans > diff) ? diff : ans;
		}

		for (int i = start; i < N; i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			comb(i + 1, cnt + 1, R);
			selected[i] = false;
		}

	}

} // end of class
