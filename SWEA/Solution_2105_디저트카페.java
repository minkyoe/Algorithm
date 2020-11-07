import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
1
4
9 8 9 8
4 6 9 4
8 7 7 8
4 5 3 5
*/
public class Solution_2105_디저트카페 {
	private static int N;
	private static int[][] map;
	private static int ans;
	
	// 하우 하좌 상좌 상우
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};
	private static boolean[] dessert;
	private static int startR;
	private static int startC;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			ans = 0; //  가능한 경우 중 디저트를 가장 많이 먹을 때의 디저트 수
			dessert = new boolean[101];
			startR = 0;
			startC = 0;
			
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					startR = i;
					startC = j;
					dfs(i,j,0,0);
				}
			}
			
			if (ans == 0) ans = -1;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ").append(ans);
			System.out.println(sb.toString());
		} // end of testCase
	} // end of main

	private static void dfs(int r, int c, int dir, int cnt) {
		if (startR == r && startC == c && cnt != 0) {
			ans = ans < cnt ? cnt : ans;
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			if (dir == 3 && i == 1) {
				break;
			}
			int nr = r + dr[dir+i];
			int nc = c + dc[dir+i];
			if (0<= nr && nr < N && 0<= nc && nc < N && !dessert[map[nr][nc]]) {
				dessert[map[nr][nc]] = true;
				dfs(nr, nc, dir+i, cnt+1);
				dessert[map[nr][nc]] = false;
			}
		}
		
	} // end of dfs
}
