import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1767_프로세서연결하기 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int tc;

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> coreList = new ArrayList<>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		tc = Integer.parseInt(bf.readLine());
		for (int testCase = 1; testCase <= tc; testCase++) {
			/************ 초기화 *************/
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			coreList.clear();
			ans = Integer.MAX_VALUE;
			/*******************************/

			for (int i = 0; i < N; i++) {
				String str = bf.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					map[i][j] = str.charAt(index) - '0';
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					if (map[i][j] == 1) {
						if (isBlocked(i,j,0) && isBlocked(i,j,1) && isBlocked(i,j,2) && isBlocked(i,j,3)) continue;
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) continue;
						coreList.add(new int[] {i,j});
					}
				}
			}
			
			dfs(0, 0, 0); // list idx, 연결개수, 전선 길이 합
			
			System.out.println("#"+testCase+" "+ans);

		} // end of testCase

	} // end of main

	private static void dfs(int idx, int cnt, int sum) {
		if (cnt == coreList.size()) {
			ans = ans > sum ? sum : ans;
			return;
		}

		int y = coreList.get(idx)[0];
		int x = coreList.get(idx)[1];

		for (int j = 0; j < dx.length; j++) {
			if (isBlocked(y, x, j)) continue;
			int len = visitCheck(y, x, j, true);
			dfs(idx + 1, cnt + 1, sum + len);
			visitCheck(y, x, j, false);
		}

	} // end of dfs

	private static int visitCheck(int y, int x, int dir, boolean flag) {
		int len = 0;
		if (dir == 0) { // 상
			for (int r = y-1; r >= 0; r--) {
				visited[r][x] = flag;
				++len;
			}
		}

		else if (dir == 1) { // 하
			for (int r = y+1; r < N; r++) {
				visited[r][x] = flag;
				++len;
			}
		}

		else if (dir == 2) { // 좌
			for (int c = x-1; c >= 0; c--) {
				visited[y][c] = flag;
				++len;
			}
		}

		else if (dir == 3) { // 우
			for (int c = x+1; c < N; c++) {
				visited[y][c] = flag;
				++len;
			}
		}
		return len;
	}

	private static boolean isBlocked(int y, int x, int dir) {
		if (dir == 0) { // 상
			for (int r = y-1; r >= 0; r--) {
				if (visited[r][x] || map[r][x] == 1) {
					return true;
				}
			}
		}

		else if (dir == 1) { // 하
			for (int r = y+1; r < N; r++) {
				if (visited[r][x] || map[r][x] == 1) {
					return true;
				}
			}
		}

		else if (dir == 2) { // 좌
			for (int c = x-1; c >= 0; c--) {
				if (visited[y][c] || map[y][c] == 1) {
					return true;
				}
			}
		}

		else if (dir == 3) { // 우
			for (int c = x+1; c < N; c++) {
				if (visited[y][c] || map[y][c] == 1) {
					return true;
				}
			}
		}

		return false;
	}
} // end of class
