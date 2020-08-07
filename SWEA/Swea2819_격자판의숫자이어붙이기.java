import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map = new int[4][4];

	// 동서남북
	static int[] dirY = { 0, 0, 1, -1 };
	static int[] dirX = { 1, -1, 0, 0 };
	static HashSet<String> hs = new HashSet<String>();
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(bf.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {
			hs.clear();
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, String.valueOf(map[i][j]));
				}

			}

			ans = hs.size();

			System.out.println("#" + testCase + " " + ans);

		}
	} // end of main

	private static void dfs(int i, int j, String str) {
		if (str.length() == 7) {
			hs.add(str); // 어차피 hashset 중복 제거해주니까 바로 add
			return;
		}

		for (int d = 0; d < 4; d++) {
			int ny = i + dirY[d];
			int nx = j + dirX[d];

			if (0 <= ny && ny < 4 && 0 <= nx && nx < 4) {
				dfs(ny, nx, str + String.valueOf(map[ny][nx]));
			}
		}
	}
} // end of class
